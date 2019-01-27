package com.csayl.clblog.service;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CategoryBo;
import com.csayl.clblog.model.domain.Category;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testSelectAll() throws NoSuchBeanException {
        List<CategoryBo> bos = categoryService.selectCategories(OrderBy.CREATE_TIME_DESC);
        System.out.println(bos.get(0).getCategory());
    }

    @Test
    public void testInsert() throws WrongFieldException {
        CategoryBo categoryBo = new CategoryBo();
        Category category = new Category();
        category.setCategoryContent("Html");
        categoryBo.setCategory(category);
        categoryService.insertCategory(categoryBo);
    }

    @Test
    public void testUpdate() {
        CategoryBo categoryBo = new CategoryBo();
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryContent("avaJ");
        categoryBo.setCategory(category);
        try {
            categoryService.updateCategory(categoryBo);
        } catch (WrongFieldException e) {
            e.printStackTrace();
        }
    }
}
