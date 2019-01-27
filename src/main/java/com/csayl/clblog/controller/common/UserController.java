package com.csayl.clblog.controller.common;

import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: chen
 * @date: 2019/1/21
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseData<UserBo> getUserByUserId(@PathVariable("id") Long userId) {
        UserBo userBo;
        try {
            userBo = userService.selectSimpleUserByUserId(userId);
        } catch (NoSuchBeanException e) {
            LOGGER.debug("获得用户：" + userId + " 时", e);
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(userBo);
    }

    @PostMapping("/login")
    public ResponseData<UserBo> login(UserBo userBo, HttpServletRequest request) {
        UserBo info = (UserBo) request.getSession().getAttribute("info");
        if (info != null) {
            return ResponseData.fail("已经登录");
        }
        try {
            userBo = userService.login(userBo);
        } catch (WrongFieldException e) {
            return ResponseData.fail(e.getMessage());
        }
        request.getSession().setAttribute("info", userBo);
        return ResponseData.succeed(userBo);
    }

    @PostMapping("/register")
    public ResponseData<UserBo> register(UserBo userBo) {
        try {
            userService.insertUser(userBo);
        } catch (WrongFieldException e) {
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(userBo);
    }


    @PostMapping("/update")
    public ResponseData<UserBo> update(UserBo userBo, HttpServletRequest request) {
        UserBo info = (UserBo) request.getSession().getAttribute("info");
        if (info == null || !info.getUser().getUserId().equals(userBo.getUser().getUserId())) {
            return ResponseData.fail("请正确输入信息");
        }
        try {
            userService.updateUser(userBo);
        } catch (WrongFieldException e) {
            return ResponseData.fail(e.getMessage());
        }
        return ResponseData.succeed(userBo);
    }
}
