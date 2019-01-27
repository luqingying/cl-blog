package com.csayl.clblog.controller.common;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.FriendlyLinkBo;
import com.csayl.clblog.service.FriendlyLinkService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chen
 * @date: 2019/1/21
 **/
@RestController
@RequestMapping("/link")
public class FriendlyLinkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FriendlyLinkController.class);

    private final static String PAGE_SIZE = "5";

    private final FriendlyLinkService friendlyLinkService;

    @Autowired
    public FriendlyLinkController(FriendlyLinkService friendlyLinkService) {
        this.friendlyLinkService = friendlyLinkService;
    }

    @GetMapping("/{id}")
    public ResponseData<FriendlyLinkBo> getLinkByLinkId(@PathVariable("id") Integer linkId) {
        FriendlyLinkBo friendlyLinkBo;
        try {
            friendlyLinkBo = friendlyLinkService.selectLinkByLinkId(linkId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询友链 ID：" + linkId + " 时， ", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(friendlyLinkBo);
    }

    @GetMapping("/all")
    public ResponseData<PageInfo<FriendlyLinkBo>> getLinks(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<FriendlyLinkBo> pageInfo;
        try {
            pageInfo = friendlyLinkService.selectLinks(pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询友链时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }
}
