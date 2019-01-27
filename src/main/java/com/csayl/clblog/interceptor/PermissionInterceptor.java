package com.csayl.clblog.interceptor;

import com.csayl.clblog.model.bo.UserBo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: chen
 * @date: 2019/1/22
 **/
@Component
public class PermissionInterceptor implements HandlerInterceptor {
    private String adminLogin = "/admin/login";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserBo info = (UserBo) request.getSession().getAttribute("info");
        if (info != null && info.getUser().getIsAdmin()) {
            return true;
        } else {
            response.sendRedirect(adminLogin);
            return false;
        }
    }
}
