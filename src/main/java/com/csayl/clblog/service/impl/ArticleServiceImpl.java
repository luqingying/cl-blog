package com.csayl.clblog.service.impl;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.mapper.ArticleCategoryMapper;
import com.csayl.clblog.mapper.ArticleContentMapper;
import com.csayl.clblog.mapper.ArticleMapper;
import com.csayl.clblog.mapper.CommentMapper;
import com.csayl.clblog.model.bo.ArticleBo;
import com.csayl.clblog.model.bo.CategoryBo;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.model.domain.*;
import com.csayl.clblog.service.ArticleService;
import com.csayl.clblog.service.CategoryService;
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
 * @date: 2019/1/16
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    private final ArticleMapper articleMapper;

    private final ArticleContentMapper contentMapper;

    private final ArticleCategoryMapper articleCategoryMapper;

    private final CommentMapper commentMapper;

    private final UserService userService;

    private final CategoryService categoryService;


    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper, ArticleContentMapper contentMapper, ArticleCategoryMapper articleCategoryMapper, CommentMapper commentMapper, UserService userService, CategoryService categoryService) {
        this.articleMapper = articleMapper;
        this.contentMapper = contentMapper;
        this.articleCategoryMapper = articleCategoryMapper;
        this.commentMapper = commentMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Transactional
    @Override
    public void insertArticle(ArticleBo articleBo) throws WrongFieldException {
        if (articleBo == null) {
            throw new WrongFieldException("文章不能为空");
        }
        try {
            Article article = articleBo.getArticle();
            ArticleContent content = articleBo.getContent();
            List<CategoryBo> categories = articleBo.getCategories();

            articleMapper.insertSelective(article);
            content.setPArticleId(article.getArticleId());
            contentMapper.insertSelective(content);

            //将该文章涉及的所有类别都插入
            insertCategoriesByArticleId(article.getArticleId(), categories);
        } catch (Exception e) {
            LOGGER.error("更新文章：" + articleBo + " 出错，原因：", e);
            throw new WrongFieldException("文章不符合规范，请重新输入");
        }
    }

    @Override
    @Transactional
    public void updateArticle(ArticleBo articleBo) throws WrongFieldException {
        if (articleBo == null) {
            throw new WrongFieldException("文章不能为空");
        }
        try {
            Article article = articleBo.getArticle();
            List<CategoryBo> categories = articleBo.getCategories();
            ArticleContent content = articleBo.getContent();

            articleMapper.updateByPrimaryKeySelective(article);
            contentMapper.updateByPrimaryKeySelective(content);
            //将该文章涉及的所有类别先删除，再插入
            ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
            articleCategoryExample.createCriteria().andPArticleIdEqualTo(article.getArticleId());
            articleCategoryMapper.deleteByExample(articleCategoryExample);

            insertCategoriesByArticleId(article.getArticleId(), categories);
        } catch (Exception e) {
            LOGGER.error("插入文章：" + articleBo + " 出错，原因：", e);
            throw new WrongFieldException("文章不符合规范，请重新输入");
        }
    }

    @Cacheable("article")
    @Override
    public ArticleBo selectArticleByArticleId(Long articleId) throws NoSuchBeanException {
        List<Long> list = new ArrayList<>();
        list.add(articleId);
        ArticleBo res = selectArticles(list, 1, 1).getList().get(0);
        if (res == null) {
            throw new NoSuchBeanException("该文章不存在");
        } else {
            ArticleContent content = getContentsOfAticle(articleId).get(0);

            //增加阅读量
            articleMapper.updateByPrimaryKeySelective(new Article(res.getArticle().getArticleReading() + 1));

            //拼装信息
            res.setContent(content);
        }
        return res;
    }

    @Cacheable("article")
    @Override
    public PageInfo<ArticleBo> selectArticlesByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return selectArticlesByCategoryId(categoryId, pageNum, pageSize, true, OrderBy.CREATE_TIME_DESC);
    }

    @Cacheable("article")
    @Override
    public PageInfo<ArticleBo> selectArticlesByCategoryId(Long categoryId, Integer pageNum, Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException {
        try {
            return selectArticles(null, categoryId, null, pageNum, pageSize, top, orderBy);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该分类暂无文章");
        }
    }

    @Cacheable(value = "article")
    @Override
    public PageInfo<ArticleBo> selectArticlesByUserId(Long userId, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return selectArticlesByUserId(userId, pageNum, pageSize, true, OrderBy.CREATE_TIME_DESC);
    }

    @Cacheable("article")
    @Override
    public PageInfo<ArticleBo> selectArticlesByUserId(Long userId, Integer pageNum, Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException {
        try {
            return selectArticles(userId, null, null, pageNum, pageSize, top, orderBy);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("该用户暂无文章");
        }
    }

    @Cacheable(value = "article")
    @Override
    public PageInfo<ArticleBo> selectArticles(Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        try {
            return selectArticles(null, null, null, pageNum, pageSize, true, OrderBy.CREATE_TIME_DESC);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("目前暂无文章");
        }
    }

    @Cacheable(value = "article")
    @Override
    public PageInfo<ArticleBo> selectArticles(List<Long> articleIds, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        try {
            return selectArticles(null, null, articleIds, pageNum, pageSize, true, OrderBy.CREATE_TIME_DESC);
        } catch (NoSuchBeanException e) {
            throw new NoSuchBeanException("目前暂无文章");
        }
    }

    @Cacheable(value = "article")
    @Override
    public PageInfo<ArticleBo> selectArticles(Long userId, Long categoryId, List<Long> articleIds, Integer pageNum,
                                              Integer pageSize, Boolean top, OrderBy orderBy) throws NoSuchBeanException {
        PageHelper.startPage(pageNum, pageSize);
        //查询文章
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause((top ? "article_is_top desc ," : "") +
                orderBy.getField());
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleIsDeletedEqualTo(false);
        if (categoryId != null) {
            //得到该分类里所有文章ID
            articleIds = getArticleIdsOfCategory(categoryId);
        }
        if (articleIds != null) {
            criteria.andArticleIdIn(articleIds);
        }
        if (userId != null) {
            criteria.andArticleUserIdEqualTo(userId);
        }
        List<Article> articles = articleMapper.selectByExample(articleExample);
        if (articles == null || articles.isEmpty()) {
            throw new NoSuchBeanException("暂无文章");
        }

        //组装信息
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        PageInfo<ArticleBo> res = PageUtils.copyPageInfo(pageInfo);
        //得到类别信息
        List<List<CategoryBo>> categories = new ArrayList<>();

        for (Article article : articles) {
            categories.add(categoryService.selectCategoriesByArticleId(article.getArticleId()));
        }
        //得到文章对应用户信息
        List<UserBo> userBos = getUsersOfArticles(articles);

        //将上述得到的信息组装
        res.setList(assembleArticles(articles, categories, userBos));

        return res;
    }

    @Transactional
    @Override
    public void deleteArticleByArticleId(Long articleId) throws NoSuchBeanException {
        if (articleId == null || articleMapper.deleteByPrimaryKey(articleId) == 0) {
            LOGGER.debug("Id：" + articleId + " 文章不存在");
            throw new NoSuchBeanException("该文章不存在");
        }

        //删除文章内容
        ArticleContentExample articleContentExample = new ArticleContentExample();
        articleContentExample.createCriteria().andPArticleIdEqualTo(articleId);
        contentMapper.deleteByExample(articleContentExample);

        //删除评论
        deleteCommentsByArticleId(articleId);

        //删除文章与分类关系
        deleteArticleCategoriesByArticleId(articleId);

    }

    //----------------------------Common Method----------------------------


    private void insertCategoriesByArticleId(Long articleId, List<CategoryBo> categories) {
        ArticleCategory articleCategory;
        for (CategoryBo category : categories) {
            articleCategory = new ArticleCategory();
            articleCategory.setPCategoryId(category.getCategory().getCategoryId());
            articleCategory.setPArticleId(articleId);
            articleCategoryMapper.insertSelective(articleCategory);
        }
    }

    private void deleteArticleCategoriesByArticleId(Long articleId) throws NoSuchBeanException {
        if (articleId == null) {
            throw new NoSuchBeanException("该文章不存在");
        }
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andPArticleIdEqualTo(articleId);
        articleCategoryMapper.deleteByExample(articleCategoryExample);
    }

    private void deleteCommentsByArticleId(Long articleId) throws NoSuchBeanException {
        if (articleId == null) {
            throw new NoSuchBeanException("该文章不存在");
        }
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPArticleIdEqualTo(articleId);
        commentMapper.deleteByExample(commentExample);
    }

    private List<ArticleContent> getContentsOfAticle(Long articleId) {
        ArticleContentExample contentExample = new ArticleContentExample();
        contentExample.createCriteria().andPArticleIdEqualTo(articleId);
        return contentMapper.selectByExample(contentExample);
    }

    private List<UserBo> getUsersOfArticles(List<Article> articles) throws NoSuchBeanException {
        List<UserBo> res = new ArrayList<>();
        for (Article article : articles) {
            res.add(userService.selectSimpleUserByUserId(article.getArticleUserId()));
        }
        return res;
    }

    private List<Long> getArticleIdsOfCategory(Long categoryId) {
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andPCategoryIdEqualTo(categoryId);
        List<ArticleCategory> articleCategories = articleCategoryMapper.selectByExample(articleCategoryExample);
        List<Long> res = new ArrayList<>();
        //得到文章ID
        for (ArticleCategory articleCategory : articleCategories) {
            res.add(articleCategory.getPArticleId());
        }
        return res;
    }


    /**
     * 将文章、类别、作者信息拼装
     *
     * @param articles   文章信息
     * @param categories 类别信息
     * @param userBos    作者信息
     * @return 拼装后结果
     */
    private List<ArticleBo> assembleArticles(List<Article> articles, List<List<CategoryBo>> categories, List<UserBo> userBos) {
        List<ArticleBo> articleBos = new ArrayList<>();
        ArticleBo articleBo;
        for (int i = 0; i < articles.size(); i++) {
            articleBos.add(new ArticleBo(userBos.get(i), articles.get(i), null, categories.get(i)));
        }
        return articleBos;
    }
}
