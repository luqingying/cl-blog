package com.csayl.clblog.controller.admin;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.model.domain.User;
import com.csayl.clblog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RestController
@RequestMapping("/admin/user")
public class BackUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackUserController.class);

    private final static String PAGE_SIZE = "5";

    private final UserService userService;

    @Autowired
    public BackUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseData<PageInfo<UserBo>> getUsers(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize", required = false, defaultValue = PAGE_SIZE) Integer pageSize) {
        PageInfo<UserBo> pageInfo;
        try {
            pageInfo = userService.selectUsers(pageNum, pageSize);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("查询所有用户", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(pageInfo);
    }

    @PostMapping("/delete")
    public ResponseData<String> deleteUser(Long userId) {
        try {
            userService.deleteUserByUserId(userId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("删除ID：" + userId + "用户", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }

    @PostMapping("/set")
    public ResponseData<String> setUserToAdmin(Long userId) {
        try {
            userService.setUserToAdminByUserId(userId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("设置ID：" + userId + "用户管理员权限", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed();
    }
}
