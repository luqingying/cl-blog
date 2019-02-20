package com.csayl.clblog.controller.common;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.ArticleBo;
import com.csayl.clblog.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chen
 * @date: 2019/1/20
 **/

@RestController
@RequestMapping("/article")
public class ArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    private final static String PAGE_SIZE = "5";

    private final ArticleService articleService;


    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseData<ArticleBo> getArticle(@PathVariable("id") Long articleId) {
        ArticleBo obj;
        try {
            obj = articleService.selectArticleByArticleId(articleId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询文章" + articleId + "时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(obj);
    }

    @GetMapping("/all")
    public ResponseData<PageInfo<ArticleBo>> getArticles(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<ArticleBo> pageInfo;
        try {
            pageInfo = articleService.selectArticles(pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询所有文章时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/c")
    public ResponseData<PageInfo<ArticleBo>> getArticlesOfCategory(@RequestParam(value = "c_id") Long categoryId,
                                                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<ArticleBo> pageInfo;
        try {
            pageInfo = articleService.selectArticlesByCategoryId(categoryId, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询分类 ID:" + categoryId + " 下文章时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/u")
    public ResponseData<PageInfo<ArticleBo>> getArticlesOfUser(@RequestParam(value = "u_id") Long userId,
                                                               @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                               @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<ArticleBo> pageInfo;
        try {
            pageInfo = articleService.selectArticlesByUserId(userId, pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询用户 ID:" + userId + " 下文章时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @GetMapping("/count")
    public ResponseData<Integer> getCount() {
        Integer count;
        try {
            count = articleService.getCount();
        } catch (Exception e) {
            LOGGER.debug("获取文章数量时,", e);
            return ResponseData.fail("暂无文章");
        }
        return ResponseData.succeed(count);
    }
}
