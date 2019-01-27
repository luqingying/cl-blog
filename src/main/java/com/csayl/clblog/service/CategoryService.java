package com.csayl.clblog.service;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CategoryBo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
public interface CategoryService {

    /**
     * 添加类别
     *
     * @param categoryBo 待添加的类别
     * @throws WrongFieldException 类别信息不正确
     */
    @Transactional
    void insertCategory(CategoryBo categoryBo) throws WrongFieldException;

    void updateCategory(CategoryBo categoryBo) throws WrongFieldException;

    List<CategoryBo> selectCategoriesByArticleId(Long articleId) throws NoSuchBeanException;

    /**
     * 查询文章对应的分类
     *
     * @param articleId 待查询的文章ID
     * @param orderBy   排序依据
     * @return 该文章的所有分类
     * @throws NoSuchBeanException 该文章不存在时
     */
    List<CategoryBo> selectCategoriesByArticleId(Long articleId, OrderBy orderBy) throws NoSuchBeanException;

    List<CategoryBo> selectCategories(List<Long> categoryIds) throws NoSuchBeanException;

    List<CategoryBo> selectCategories(OrderBy orderBy) throws NoSuchBeanException;

    /**
     * 查询所有分类
     *
     * @param categoryIds 待查询的所有类别ID
     * @param orderBy     排序依据
     * @return 查询后结果
     * @throws NoSuchBeanException 查询类别不存在
     */
    List<CategoryBo> selectCategories(List<Long> categoryIds, OrderBy orderBy) throws NoSuchBeanException;

    List<CategoryBo> selectCategories(Long articleId, List<Long> categoryIds, OrderBy orderBy) throws
            NoSuchBeanException;

    /**
     * 删除类别，并同时删除文章-类别表中对应数据
     *
     * @param categoryId 待删除类别的信息
     * @throws NoSuchBeanException 类别不存在
     */
    @Transactional
    void deleteCategoryByCategoryId(Long categoryId) throws NoSuchBeanException;
}
