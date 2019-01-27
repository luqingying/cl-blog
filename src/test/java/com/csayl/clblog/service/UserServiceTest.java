package com.csayl.clblog.service;

import com.csayl.clblog.config.UserConfiguration;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.model.domain.User;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: chen
 * @date: 2019/1/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserConfiguration configuration;

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        UserBo userBo = new UserBo();
        User user = new User();
        user.setUserName("user1");
        user.setUserPassword("password1");
        user.setUserImageUrl("userImageUrl");
        userBo.setUser(user);
        try {
            userService.insertUser(userBo);
        } catch (WrongFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() throws NoSuchBeanException {
        PageInfo<UserBo> pageInfo = userService.selectUsers(1, 4);
        System.out.println(pageInfo.getList());
    }

    @Test
    public void testDeleteUser() {
        try {
            userService.deleteUserByUserId(2L);
        } catch (NoSuchBeanException e) {
            e.printStackTrace();
        }

    }

}
