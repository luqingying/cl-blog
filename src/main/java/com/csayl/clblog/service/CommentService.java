package com.csayl.clblog.service;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CommentBo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/15
 **/
public interface CommentService {
    @Transactional
    void insertComment(CommentBo commentBo) throws WrongFieldException;

    /**
     * 查询该文章的所有根评论（即评论的rootCommentId为0）
     *
     * @param articleId 文章ID
     * @param orderBy   排序依据
     * @param pageNum   当前页
     * @param pageSize  页的数量
     * @return 所有根评论
     * @throws NoSuchBeanException 该文章暂无评论
     */
    PageInfo<CommentBo> selectRootCommentsByArticleId(Long articleId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<CommentBo> selectCommentsByRootCommentId(Long rootCommentId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<CommentBo> selectCommentsByUserId(Long userId, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<CommentBo> selectLatestComments(Integer commentNum) throws WrongFieldException, NoSuchBeanException;

    PageInfo<CommentBo> selectComments(Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    /**
     * 查询关于该用户、该文章的所有评论
     *
     * @param userId        用户
     * @param articleId     文章
     * @param rootCommentId 所属的根评论
     * @param orderBy       排序依据
     * @param pageNum       当前页
     * @param pageSize      页的数量
     * @return 评论
     * @throws NoSuchBeanException 评论不存在
     */
    PageInfo<CommentBo> selectComments(Long userId, Long articleId, Long rootCommentId, OrderBy orderBy, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    Integer getCount();

    void deleteCommentByCommentId(Long commentId) throws NoSuchBeanException;
}
