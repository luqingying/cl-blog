package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CommentBo;
import com.csayl.clblog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RestController
@RequestMapping("/admin/comment")
public class BackCommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackCommentController.class);

    private final static String PAGE_SIZE = "5";

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


    @GetMapping("/all")
    public ResponseData<PageInfo<CommentBo>> getComments(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<CommentBo> pageInfo;
        try {
            pageInfo = commentService.selectComments(pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询所有评论时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/count")
    public ResponseData<Integer> getCount() {
        Integer count;
        try {
            count = commentService.getCount();
        } catch (Exception e) {
            LOGGER.debug("获取评论数量时,", e);
            return ResponseData.fail("暂无评论");
        }
        return ResponseData.succeed(count);
    }
}
