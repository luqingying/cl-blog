package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.LogBo;
import com.csayl.clblog.service.LogService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RestController
@RequestMapping("/admin/log")
public class BackLogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackLogController.class);

    private final static String PAGE_SIZE = "5";

    private final LogService logService;

    @Autowired
    public BackLogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/all")
    public ResponseData<PageInfo<LogBo>> getLogs(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<LogBo> pageInfo;
        try {
            pageInfo = logService.selectAllLog(pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询所有日志", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }


    @GetMapping("/ip")
    public ResponseData<PageInfo<LogBo>> getLogsByIP(@RequestParam(value = "ip") String ip,
                                                     @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<LogBo> pageInfo;
        try {
            pageInfo = logService.selectLogByIp(ip, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询IP:" + ip + "日志", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/url")
    public ResponseData<PageInfo<LogBo>> getLogsByURL(@RequestParam(value = "url") String url,
                                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<LogBo> pageInfo;
        try {
            pageInfo = logService.selectLogByUrl(url, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询url:" + url + "日志", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }
}
