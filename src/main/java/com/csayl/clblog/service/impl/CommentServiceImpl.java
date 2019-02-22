package com.csayl.clblog.service.impl;

import com.csayl.clblog.config.CommentConfiguration;
import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.mapper.CommentMapper;
import com.csayl.clblog.model.bo.CommentBo;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.model.domain.Comment;
import com.csayl.clblog.model.domain.CommentExample;
import com.csayl.clblog.service.CommentService;
import com.csayl.clblog.service.UserService;
import com.csayl.clblog.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentMapper commentMapper;

    private final UserService userService;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper, UserService userService) {
        this.commentMapper = commentMapper;
        this.userService = userService;
    }

    @Transactional
    @Override
    public void insertComment(CommentBo commentBo) throws WrongFieldException {
        Comment category;
        String content;
        if (commentBo == null || (category = commentBo.getComment()) == null
                || (content = category.getCommentContent()) == null
                || content.length() <= CommentConfiguration.MinCommentContent
                || content.length() >= CommentConfiguration.MaxCommentContent) {
            throw new WrongFieldException("请正确输入评论内容");
        } else {
            try {
                commentMapper.insertSelective(category);
            } catch (Exception e) {
                LOGGER.debug("评论插入时发生错误", e);
                throw new WrongFieldException("请正确输入评论信息");
            }
        }
    }

    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectRootCommentsByArticleId(Long articleId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageInfo<CommentBo> res;
        try {
            res = selectComments(null, articleId, 0L, orderBy, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该文章暂无评论");
        }
        return res;
    }

    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectCommentsByRootCommentId(Long rootCommentId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageInfo<CommentBo> res;
        try {
            res = selectComments(null, null, rootCommentId, orderBy, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该根评论暂无子评论");
        }
        return res;
    }

    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectCommentsByUserId(Long userId, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageInfo<CommentBo> res;
        try {
            res = selectComments(userId, null, null, OrderBy.CREATE_TIME_DESC, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该用户暂无评论");
        }
        return res;
    }


    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectLatestComments(Integer commentNum) throws WrongFieldException, NoSuchBeanException {
        return selectComments(1, commentNum);
    }

    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectComments(Integer pageNum, Integer commentNum) throws WrongFieldException, NoSuchBeanException {
        if (commentNum <= CommentConfiguration.MinCommentNum || commentNum >= CommentConfiguration.MaxCommentNum) {
            throw new WrongFieldException("请输入正确的评论数量");
        }
        return selectComments(null, null, null, OrderBy.CREATE_TIME_DESC, pageNum, commentNum);
    }

    @Cacheable("comment")
    @Override
    public PageInfo<CommentBo> selectComments(Long userId, Long articleId, Long rootCommentId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageHelper.startPage(pageNum, pageSize);
        //获得该用户，该文章下的所有评论
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause(orderBy.getField());

        if (userId != null) {
            commentExample.createCriteria().andPUserIdEqualTo(userId);
        }

        if (articleId != null) {
            commentExample.createCriteria().andPArticleIdEqualTo(articleId);
        }

        if (rootCommentId != null) {
            commentExample.createCriteria().andRootCommentIdEqualTo(articleId);
        }

        List<Comment> comments = commentMapper.selectByExample(commentExample);

        if (comments == null || comments.isEmpty()) {
            throw new NoSuchBeanException("暂无评论");
        }

        //将comments封装成commentBo
        return assembleCommentBo(comments);
    }

    @Override
    public void deleteCommentByCommentId(Long commentId) throws NoSuchBeanException {
        if (commentId == null || commentMapper.deleteByPrimaryKey(commentId) == 0) {
            LOGGER.debug("ID：" + commentId + " 的评论不存在！");
            throw new NoSuchBeanException("该评论不存在");
        }
    }

    //----------------------------Common Method----------------------------
    private PageInfo<CommentBo> assembleCommentBo(List<Comment> comments) throws NoSuchBeanException {
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        PageInfo<CommentBo> res = PageUtils.copyPageInfo(pageInfo);
        List<UserBo> userBos = new ArrayList<>();

        for (Comment comment : comments) {
            userBos.add(userService.selectSimpleUserByUserId(comment.getPUserId()));
        }

        List<CommentBo> list = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            list.add(new CommentBo(comments.get(i), userBos.get(i)));
        }
        res.setList(list);
        return res;
    }
}
