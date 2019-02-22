package com.csayl.clblog.service.impl;

import com.csayl.clblog.config.UserConfiguration;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.mapper.CommentMapper;
import com.csayl.clblog.mapper.UserMapper;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.model.domain.CommentExample;
import com.csayl.clblog.model.domain.User;
import com.csayl.clblog.model.domain.UserExample;
import com.csayl.clblog.service.UserService;
import com.csayl.clblog.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;

    private final CommentMapper commentMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, CommentMapper commentMapper) {
        this.userMapper = userMapper;
        this.commentMapper = commentMapper;
    }

    @Transactional
    @Override
    public void insertUser(UserBo userBo) throws WrongFieldException {
        User user;
        if (userBo == null || (user = userBo.getUser()) == null
                || user.getUserName() == null || user.getUserPassword() == null || user.getUserEmail() == null) {
            throw new WrongFieldException("请正确输入个人信息");
        }
        //置管理员为false
        user.setIsAdmin(false);

        checkLength(user);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        if (userMapper.countByExample(userExample) != 0) {
            throw new WrongFieldException("用户名已存在，请重新输入");
        }

        //密码加密
        String md5Password = DigestUtils.md5DigestAsHex((user.getUserPassword() + UserConfiguration.PasswordSalt).getBytes());
        user.setUserPassword(md5Password);
        try {
            userMapper.insertSelective(user);
        } catch (Exception e) {
            LOGGER.error("插入用户：" + userBo + " 出错，原因：", e);
            throw new WrongFieldException("请正确输入个人信息");
        }
    }

    @Override
    public void updateUser(UserBo userBo) throws WrongFieldException {
        User user;
        if (userBo == null || (user = userBo.getUser()) == null
                || user.getUserName() == null || user.getUserPassword() == null) {
            throw new WrongFieldException("请正确输入个人信息");
        }
        //置管理员为false
        user.setIsAdmin(false);
        user.setUserName(null);

        checkLength(user);

        String md5Password = DigestUtils.md5DigestAsHex((user.getUserPassword() + UserConfiguration.PasswordSalt).getBytes());
        user.setUserPassword(md5Password);
        try {
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            LOGGER.error("插入用户：" + userBo + " 出错，原因：", e);
            throw new WrongFieldException("请正确输入个人信息");
        }
    }

    @Override
    public void setUserToAdminByUserId(Long userId) throws NoSuchBeanException {
        if (userId == null || userMapper.selectByPrimaryKey(userId) == null) {
            throw new NoSuchBeanException("该用户不存在");
        }
        try {
            User user = new User();
            user.setUserId(userId);
            user.setIsAdmin(true);
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            LOGGER.error("授予用户 :" + userId + "权限失败", e);
            throw new NoSuchBeanException("授予权限失败");
        }
    }

    @Override
    public UserBo login(UserBo userBo) throws WrongFieldException {
        User user;
        if (userBo == null || (user = userBo.getUser()) == null
                || user.getUserName() == null || user.getUserPassword() == null || user.getUserEmail() == null) {
            throw new WrongFieldException("请正确输入个人信息");
        }

        checkLength(user);

        //密码加密
        String md5Password = DigestUtils.md5DigestAsHex((user.getUserPassword() + UserConfiguration.PasswordSalt).getBytes());
        user.setUserPassword(md5Password);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName())
                .andUserPasswordEqualTo(user.getUserPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            throw new WrongFieldException("用户名或密码错误，请重新输入");
        }
        return new UserBo(users.get(0));
    }

    @Cacheable("user")
    @Override
    public UserBo selectSimpleUserByUserId(Long userId) throws NoSuchBeanException {
        List<Long> list = new ArrayList<>();
        list.add(userId);
        return selectSimpleUsersByUserIds(list).get(0);
    }

    @Cacheable("user")
    @Override
    public List<UserBo> selectSimpleUsersByUserIds(List<Long> userIds) throws NoSuchBeanException {
        PageInfo<UserBo> pageInfo = selectUsers(userIds, 1, userIds.size());
        return pageInfo.getList();
    }

    @Cacheable("user")
    @Override
    public PageInfo<UserBo> selectUsers(Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return selectUsers(null, pageNum, pageSize);
    }

    @Cacheable("user")
    @Override
    public PageInfo<UserBo> selectUsers(List<Long> ids, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample = new UserExample();
        if (ids != null) {
            userExample.createCriteria().andUserIdIn(ids);
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            throw new NoSuchBeanException("用户不存在");
        }
        //将User拼装为UserBo
        PageInfo<User> pageInfo = new PageInfo<>(users);
        PageInfo<UserBo> res = PageUtils.copyPageInfo(pageInfo);
        List<UserBo> userBos = new ArrayList<>();
        for (User user : users) {
            UserBo userBo = new UserBo();
            userBo.setUser(user);
            userBos.add(userBo);
        }
        res.setList(userBos);
        return res;
    }

    @Transactional
    @Override
    public void deleteUserByUserId(Long userId) throws NoSuchBeanException {
        if (userId == null || userMapper.deleteByPrimaryKey(userId) == 0) {
            throw new NoSuchBeanException("该用户不存在");
        }
        deleteCommentsByUserId(userId);
    }

    private void deleteCommentsByUserId(Long userId) throws NoSuchBeanException {
        if (userId == null) {
            throw new NoSuchBeanException("该用户不存在");
        }
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPUserIdEqualTo(userId);
        commentMapper.deleteByExample(commentExample);
    }

    /**
     * 检查 user 邮箱，用户名，密码长度
     *
     * @param user 待检查的对象
     * @throws WrongFieldException 长度错误
     */
    private static void checkLength(User user) throws WrongFieldException {
        if (user.getUserEmail() != null
                && (user.getUserEmail().length() >= UserConfiguration.MaxEmailLength
                || user.getUserEmail().length() <= UserConfiguration.MinEmailLength)) {
            throw new WrongFieldException("邮箱长度错误，请重新输入");
        }
        if (user.getUserName().length() >= UserConfiguration.MaxUsernameLength
                || user.getUserName().length() <= UserConfiguration.MinUsernameLength
                || user.getUserPassword().length() >= UserConfiguration.MaxPasswordLength
                || user.getUserPassword().length() <= UserConfiguration.MinPasswordLength) {
            throw new WrongFieldException("用户名或密码长度错误，请重新输入");
        }
    }
}
