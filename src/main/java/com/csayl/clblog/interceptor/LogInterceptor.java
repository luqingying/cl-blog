package com.csayl.clblog.interceptor;

import com.csayl.clblog.model.bo.LogBo;
import com.csayl.clblog.model.domain.Log;
import com.csayl.clblog.service.LogService;
import com.csayl.clblog.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: chen
 * @date: 2019/1/22
 **/

@Component
public class LogInterceptor implements HandlerInterceptor {

    private final LogService logService;

    @Autowired
    public LogInterceptor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Log log = new Log(IPUtils.getRealIp(request), request.getRequestURL().toString(), new Date());
        logService.insertLog(new LogBo(log));
        return true;
    }
}
