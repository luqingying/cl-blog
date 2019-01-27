package com.csayl.clblog.service;

import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.UserBo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
public interface UserService {

    @Transactional
    void insertUser(UserBo userBo) throws WrongFieldException;

    void updateUser(UserBo userBo) throws WrongFieldException;

    void setUserToAdminByUserId(Long userId) throws NoSuchBeanException;

    UserBo login(UserBo userBo) throws WrongFieldException;

    UserBo selectSimpleUserByUserId(Long userId) throws NoSuchBeanException;

    List<UserBo> selectSimpleUsersByUserIds(List<Long> userIds) throws NoSuchBeanException;

    PageInfo<UserBo> selectUsers(Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<UserBo> selectUsers(List<Long> ids, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    @Transactional
    void deleteUserByUserId(Long userId) throws NoSuchBeanException;
}
