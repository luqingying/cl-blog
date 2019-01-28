package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.ArticleBo;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: chen
 * @date: 2019/1/22
 **/
@RestController
@RequestMapping("/admin/article")
public class BackArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackArticleController.class);

    private final ArticleService articleService;

    @Autowired
    public BackArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PostMapping("/delete")
    public ResponseData<String> deleteArticle(Long articleId) {
        try {
            articleService.deleteArticleByArticleId(articleId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("删除文章", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }

    @PostMapping("/add")
    public ResponseData<String> addArticle(ArticleBo articleBo, HttpServletRequest request) {
        try {
            //获得作者
            UserBo info = (UserBo) request.getSession().getAttribute("info");
            articleBo.getArticle().setArticleUserId(info.getUser().getUserId());
            articleService.insertArticle(articleBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("添加文章", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }

    @PostMapping("/update")
    public ResponseData<String> updateArticle(ArticleBo articleBo) {
        try {
            articleService.updateArticle(articleBo);
        } catch (WrongFieldException | NoSuchBeanException e) {
            LOGGER.debug("修改文章", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
