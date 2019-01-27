package com.csayl.clblog.service.impl;

import com.csayl.clblog.config.CategoryConfiguration;
import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.mapper.ArticleCategoryMapper;
import com.csayl.clblog.mapper.CategoryMapper;
import com.csayl.clblog.model.bo.CategoryBo;
import com.csayl.clblog.model.domain.ArticleCategory;
import com.csayl.clblog.model.domain.ArticleCategoryExample;
import com.csayl.clblog.model.domain.Category;
import com.csayl.clblog.model.domain.CategoryExample;
import com.csayl.clblog.service.CategoryService;
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
 * @date: 2019/1/16
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);


    private final ArticleCategoryMapper articleCategoryMapper;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(ArticleCategoryMapper articleCategoryMapper, CategoryMapper categoryMapper) {
        this.articleCategoryMapper = articleCategoryMapper;
        this.categoryMapper = categoryMapper;
    }

    @Transactional
    @Override
    public void insertCategory(CategoryBo categoryBo) throws WrongFieldException {
        Category category;
        String content;
        if (categoryBo == null || (category = categoryBo.getCategory()) == null
                || (content = category.getCategoryContent()) == null
                || content.length() <= CategoryConfiguration.MinCategoryContent
                || content.length() >= CategoryConfiguration.MaxCategoryContent) {
            throw new WrongFieldException("请正确输入类别信息");
        } else {
            try {
                categoryMapper.insertSelective(category);
            } catch (Exception e) {
                LOGGER.debug("类别插入时发生错误", e);
                throw new WrongFieldException("请正确输入类别信息");
            }
        }
    }

    @Override
    public void updateCategory(CategoryBo categoryBo) throws WrongFieldException {
        Category category = categoryBo.getCategory();
        String content = category.getCategoryContent();
        if (content == null
                || content.length() <= CategoryConfiguration.MinCategoryContent
                || content.length() >= CategoryConfiguration.MaxCategoryContent) {
            throw new WrongFieldException("请正确输入类别信息");
        } else {
            try {
                categoryMapper.updateByPrimaryKeySelective(category);
            } catch (Exception e) {
                LOGGER.error("类别更新时发生错误", e);
                e.printStackTrace();
                throw new WrongFieldException("请正确输入类别信息");
            }
        }
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategoriesByArticleId(Long articleId) throws NoSuchBeanException {
        return selectCategoriesByArticleId(articleId, OrderBy.CREATE_TIME_ASC);
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategoriesByArticleId(Long articleId, OrderBy orderBy) throws NoSuchBeanException {
        try {
            return selectCategories(articleId, null, orderBy);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该文章暂无类别");
        }
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategories(List<Long> categoryIds) throws NoSuchBeanException {
        return selectCategories(categoryIds, OrderBy.CREATE_TIME_ASC);
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategories(OrderBy orderBy) throws NoSuchBeanException {
        return selectCategories(null, orderBy);
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategories(List<Long> categoryIds, OrderBy orderBy) throws
            NoSuchBeanException {
        return selectCategories(null, categoryIds, orderBy);
    }

    @Cacheable("category")
    @Override
    public List<CategoryBo> selectCategories(Long articleId, List<Long> categoryIds, OrderBy orderBy) throws
            NoSuchBeanException {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause(orderBy.getField());
        CategoryExample.Criteria criteria = categoryExample.createCriteria();

        if (articleId != null) {
            //得到该文章的所有分类
            categoryIds = getCategoryIdsOfArticle(articleId);
        }
        if (categoryIds != null) {
            criteria.andCategoryIdIn(categoryIds);
        }
        List<Category> categories = categoryMapper.selectByExample(categoryExample);

        //拼装信息
        List<CategoryBo> categoryBos = new ArrayList<>();
        for (Category category : categories) {
            categoryBos.add(new CategoryBo(category));
        }
        return categoryBos;
    }


    @Transactional
    @Override
    public void deleteCategoryByCategoryId(Long categoryId) throws NoSuchBeanException {
        if (categoryId == null || categoryMapper.deleteByPrimaryKey(categoryId) == 0) {
            throw new NoSuchBeanException("该类别不存在");
        }
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andPCategoryIdEqualTo(categoryId);
        articleCategoryMapper.deleteByExample(articleCategoryExample);
    }


    //----------------------------Common Method----------------------------
    private List<Long> getCategoryIdsOfArticle(Long articleId) throws NoSuchBeanException {
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andPArticleIdEqualTo(articleId);
        List<ArticleCategory> ac = articleCategoryMapper.selectByExample(articleCategoryExample);
        if (ac == null || ac.isEmpty()) {
            throw new NoSuchBeanException("该文章暂无分类");
        }
        //返回文章对应所有类别的ID
        List<Long> categoryIds = new ArrayList<>();
        for (ArticleCategory articleCategory : ac) {
            categoryIds.add(articleCategory.getPCategoryId());
        }
        return categoryIds;
    }
}