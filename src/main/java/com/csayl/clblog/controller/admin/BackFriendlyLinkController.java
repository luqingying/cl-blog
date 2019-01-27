package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.FriendlyLinkBo;
import com.csayl.clblog.service.FriendlyLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RestController
@RequestMapping("/admin/link")
public class BackFriendlyLinkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackCommentController.class);

    private final FriendlyLinkService friendlyLinkService;

    @Autowired
    public BackFriendlyLinkController(FriendlyLinkService friendlyLinkService) {
        this.friendlyLinkService = friendlyLinkService;
    }

    @PostMapping("/delete")
    public ResponseData<String> deleteLink(Integer linkId) {
        try {
            friendlyLinkService.deleteLinkByLinkId(linkId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("删除友链", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }


    @PostMapping("/add")
    public ResponseData<String> addLink(FriendlyLinkBo friendlyLinkBo) {
        try {
            friendlyLinkService.insertLink(friendlyLinkBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("增加友链", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }


    @PostMapping("/update")
    public ResponseData<String> updateLink(FriendlyLinkBo friendlyLinkBo) {
        try {
            friendlyLinkService.updateLink(friendlyLinkBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("修改友链", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
