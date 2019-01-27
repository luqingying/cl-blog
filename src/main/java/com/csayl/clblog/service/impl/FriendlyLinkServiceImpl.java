package com.csayl.clblog.service.impl;

import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.mapper.FriendlyLinkMapper;
import com.csayl.clblog.model.bo.FriendlyLinkBo;
import com.csayl.clblog.model.domain.FriendlyLink;
import com.csayl.clblog.service.FriendlyLinkService;
import com.csayl.clblog.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
@Service
public class FriendlyLinkServiceImpl implements FriendlyLinkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FriendlyLinkServiceImpl.class);

    private final FriendlyLinkMapper friendlyLinkMapper;

    @Autowired
    public FriendlyLinkServiceImpl(FriendlyLinkMapper friendlyLinkMapper) {
        this.friendlyLinkMapper = friendlyLinkMapper;
    }

    @Transactional
    @Override
    public void insertLink(FriendlyLinkBo friendlyLinkBo) throws WrongFieldException {
        FriendlyLink friendlyLink;
        if (friendlyLinkBo == null || (friendlyLink = friendlyLinkBo.getLink()) == null) {
            throw new WrongFieldException("请重新输入友链信息");
        }
        try {
            friendlyLinkMapper.insertSelective(friendlyLink);
        } catch (Exception e) {
            LOGGER.error("插入友链信息", e);
            throw new WrongFieldException("请重新输入友链信息");
        }
    }

    @Override
    public void updateLink(FriendlyLinkBo friendlyLinkBo) throws WrongFieldException {
        FriendlyLink friendlyLink;
        if (friendlyLinkBo == null || (friendlyLink = friendlyLinkBo.getLink()) == null) {
            throw new WrongFieldException("请重新输入友链信息");
        }
        try {
            friendlyLinkMapper.updateByPrimaryKeySelective(friendlyLink);
        } catch (Exception e) {
            LOGGER.error("更改友链信息", e);
            throw new WrongFieldException("请重新输入友链信息");
        }
    }

    @Cacheable("link")
    @Override
    public FriendlyLinkBo selectLinkByLinkId(Integer linkId) throws NoSuchBeanException {
        FriendlyLinkBo friendlyLinkBo = new FriendlyLinkBo();
        if (linkId == null) {
            throw new NoSuchBeanException("该友链不存在");
        }
        try {
            FriendlyLink friendlyLink = friendlyLinkMapper.selectByPrimaryKey(linkId);
            friendlyLinkBo.setLink(friendlyLink);
        } catch (Exception e) {
            throw new NoSuchBeanException("该友链不存在");
        }
        return friendlyLinkBo;
    }

    @Cacheable("link")
    @Override
    public PageInfo<FriendlyLinkBo> selectLinks(Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        PageHelper.startPage(pageNum, pageSize);
        List<FriendlyLink> friendlyLinks = friendlyLinkMapper.selectByExample(null);
        if (friendlyLinks == null || friendlyLinks.isEmpty()) {
            throw new NoSuchBeanException("暂无友链");
        }
        PageInfo<FriendlyLink> pageInfo = new PageInfo<>(friendlyLinks);
        PageInfo<FriendlyLinkBo> res = PageUtils.copyPageInfo(pageInfo);
        try {
            List<FriendlyLinkBo> list = new ArrayList<>();
            for (FriendlyLink friendlyLink : friendlyLinks) {
                FriendlyLinkBo friendlyLinkBo = new FriendlyLinkBo();
                friendlyLinkBo.setLink(friendlyLink);
                list.add(friendlyLinkBo);
            }
            res.setList(list);
        } catch (Exception e) {
            LOGGER.error("查询友链 ", e);
            throw new NoSuchBeanException("暂无友链");
        }
        return res;
    }

    @Override
    public void deleteLinkByLinkId(Integer linkId) throws NoSuchBeanException {
        if (linkId == null) {
            throw new NoSuchBeanException("该友链不存在");
        }
        try {
            friendlyLinkMapper.deleteByPrimaryKey(linkId);
        } catch (Exception e) {
            throw new NoSuchBeanException("该友链不存在");
        }
    }
}
