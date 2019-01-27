package com.csayl.clblog.controller.common;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CommentBo;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: chen
 * @date: 2019/1/20
 **/

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final static String COMMENT_NUM = "5";
    private final static String PAGE_SIZE = "5";

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/latest")
    public ResponseData<PageInfo<CommentBo>> getLatestComments(@RequestParam(value = "c_num", required = false, defaultValue = COMMENT_NUM) Integer commentNum) {
        PageInfo<CommentBo> pageInfo;
        try {
            pageInfo = commentService.selectLatestComments(commentNum);
        } catch (WrongFieldException e) {
            LOGGER.debug("查询最新评论时，", e);
            return ResponseData.fail("请输入正确的评论数量");
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询最新评论时，", e);
            return ResponseData.fail("暂无评论");
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/u")
    public ResponseData<PageInfo<CommentBo>> getCommentsByUserId(@RequestParam(value = "u_id") Long userId,
                                                                 @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize
    ) {
        PageInfo<CommentBo> pageInfo;
        try {
            pageInfo = commentService.selectCommentsByUserId(userId, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询用户 ID：" + userId + " 评论时，", e);
            return ResponseData.fail("该用户暂无评论");
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/a")
    public ResponseData<PageInfo<CommentBo>> getCommentsByArticleId(@RequestParam(value = "a_id") Long articleId,
                                                                    @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                    @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize
    ) {
        PageInfo<CommentBo> pageInfo;
        try {
            pageInfo = commentService.selectRootCommentsByArticleId(articleId, OrderBy.CREATE_TIME_DESC, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询文章 ID：" + articleId + " 评论时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/c")
    public ResponseData<PageInfo<CommentBo>> getCommentsByRootCommentId(@RequestParam(value = "c_id") Long rootCommentId,
                                                                        @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                        @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize
    ) {
        PageInfo<CommentBo> pageInfo;
        try {
            pageInfo = commentService.selectCommentsByRootCommentId(rootCommentId, OrderBy.CREATE_TIME_DESC, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询根评论 ID：" + rootCommentId + " 子评论时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }


    @PostMapping("/add")
    public ResponseData<String> addComment(CommentBo commentBo, HttpServletRequest request) {
        UserBo info = (UserBo) request.getSession().getAttribute("info");
        if (info == null) {
            return ResponseData.fail("请登录后评论");
        }
        try {
            commentBo.getComment().setPUserId(info.getUser().getUserId());
            commentService.insertComment(commentBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("添加文字", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
