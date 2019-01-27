package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CategoryBo;
import com.csayl.clblog.model.bo.FriendlyLinkBo;
import com.csayl.clblog.service.CategoryService;
import com.csayl.clblog.service.FriendlyLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RestController
@RequestMapping("/admin/category")
public class BackCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackCommentController.class);

    private final CategoryService categoryService;

    @Autowired
    public BackCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/delete")
    public ResponseData<String> deleteCategory(Long categoryId) {
        try {
            categoryService.deleteCategoryByCategoryId(categoryId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("删除类别", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }


    @PostMapping("/add")
    public ResponseData<String> addCategory(CategoryBo categoryBo) {
        try {
            categoryService.insertCategory(categoryBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("增加类别", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }


    @PostMapping("/update")
    public ResponseData<String> updateCategory(CategoryBo categoryBo) {
        try {
            categoryService.updateCategory(categoryBo);
        } catch (WrongFieldException e) {
            LOGGER.debug("修改类别", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
