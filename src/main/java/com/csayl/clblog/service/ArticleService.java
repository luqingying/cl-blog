package com.csayl.clblog.service;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.ArticleBo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/15
 **/
public interface ArticleService {
    /**
     * 插入文章
     *
     * @param articleBo 文章信息
     * @throws WrongFieldException 文章信息错误
     */
    @Transactional
    void insertArticle(ArticleBo articleBo) throws WrongFieldException;

    @Transactional
    void updateArticle(ArticleBo articleBo) throws WrongFieldException, NoSuchBeanException;

    /**
     * 查找文章
     *
     * @param articleId 待查找文章的ID
     * @return 文章信息，包括内容，作者等
     * @throws NoSuchBeanException 没有该文章
     */
    ArticleBo selectArticleByArticleId(Long articleId) throws NoSuchBeanException;


    /**
     * 根据分类下所有文章信息
     *
     * @param categoryId 待查询分类
     * @param pageNum    当前页
     * @param pageSize   每页的数量
     * @return 该分类的文章
     * @throws NoSuchBeanException 该分类不存在
     */
    PageInfo<ArticleBo> selectArticlesByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    /**
     * 根据分类下所有文章信息
     *
     * @param categoryId 待查询分类
     * @param pageNum    当前页
     * @param pageSize   每页的数量
     * @param top        是否置顶
     * @param orderBy    排序依据
     * @return 该分类的文章
     * @throws NoSuchBeanException 该分类不存在
     */
    PageInfo<ArticleBo> selectArticlesByCategoryId(Long categoryId, Integer pageNum, Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException;

    PageInfo<ArticleBo> selectArticlesByUserId(Long userId, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    /**
     * 查询所有文章
     *
     * @param userId   文章作者ID
     * @param pageNum  当前页
     * @param pageSize 每页的数量
     * @param top      置顶
     * @param orderBy  排序依据
     * @return 结果
     * @throws NoSuchBeanException 没有文章时
     */
    PageInfo<ArticleBo> selectArticlesByUserId(Long userId, Integer pageNum, Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException;

    /**
     * 查询所有文章
     *
     * @param pageNum  当前页
     * @param pageSize 每页的数量
     * @return 文章
     * @throws NoSuchBeanException 文章不存在
     */
    PageInfo<ArticleBo> selectArticles(Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<ArticleBo> selectArticles(List<Long> articleIds, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<ArticleBo> selectArticles(Long userId, Long categoryId, List<Long> articleIds, Integer pageNum,
                                       Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException;

    Integer getCount();

    @Transactional
    void deleteArticleByArticleId(Long articleId) throws NoSuchBeanException;
}
