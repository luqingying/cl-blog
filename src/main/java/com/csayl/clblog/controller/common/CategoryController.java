package com.csayl.clblog.controller.common;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.CategoryBo;
import com.csayl.clblog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/20
 **/

@RequestMapping("/category")
@RestController
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseData<List<CategoryBo>> getAllCategories() {
        List<CategoryBo> list;
        try {
            list = categoryService.selectCategories(OrderBy.CREATE_TIME_ASC);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询所有类别时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(list);
    }

    @GetMapping("/{id}")
    public ResponseData<List<CategoryBo>> getCategoriesOfArticle(@PathVariable("id") Long articleId) {
        List<CategoryBo> list;
        try {
            list = categoryService.selectCategoriesByArticleId(articleId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询文章" + articleId + "类别时，", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(list);
    }
}
