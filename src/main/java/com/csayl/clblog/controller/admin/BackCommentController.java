package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.service.CommentService;
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
@RequestMapping("/admin/comment")
public class BackCommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackCommentController.class);

    private final CommentService commentService;

    @Autowired
    public BackCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

     @PostMapping("/delete")
    public ResponseData<String> deleteComment(Long commentId) {
        try {
            commentService.deleteCommentByCommentId(commentId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("删除评论", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
