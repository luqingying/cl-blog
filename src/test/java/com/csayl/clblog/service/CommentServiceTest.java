package com.csayl.clblog.service;

import com.csayl.clblog.config.CommentConfiguration;
import com.csayl.clblog.config.OSSConfiguration;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.CommentBo;
import com.csayl.clblog.model.domain.Comment;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void testSelectLatest() {
        try {
            PageInfo<CommentBo> pageInfo = commentService.selectLatestComments(5);
            System.out.println(pageInfo.getList());
        } catch (WrongFieldException | NoSuchBeanException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        Comment comment = new Comment(null, "Test", null, null, 1L, 1L, new Date(), new Date());
        try {
            commentService.insertComment(new CommentBo(comment, null));
        } catch (WrongFieldException e) {
            e.printStackTrace();
        }

    }
}
