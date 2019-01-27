package com.csayl.clblog.service;

import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.ArticleBo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testSelectById() {
        Long id = 1L;
        try {
            articleService.selectArticleByArticleId(id);
        } catch (NoSuchBeanException e) {
            e.printStackTrace();
            System.out.println("?");
        }
    }

    @Test
    public void testSelectAll() {
        try {
//            PageInfo<ArticleBo> pageInfo = articleService.selectArticles(1, 5, true, OrderBy.CREATE_TIME_DESC);
            PageInfo<ArticleBo> pageInfo = articleService.selectArticles(1, 5);
            System.out.println(pageInfo.getList());
        } catch (NoSuchBeanException e) {
            e.printStackTrace();
            System.out.println("?");
        }
    }

    @Test
    public void testDeleteById() {
        try {
            articleService.deleteArticleByArticleId(1L);
        } catch (NoSuchBeanException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {

    }

}
