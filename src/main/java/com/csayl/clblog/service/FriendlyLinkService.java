package com.csayl.clblog.service;

import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.exception.WrongFieldException;
import com.csayl.clblog.model.bo.FriendlyLinkBo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
public interface FriendlyLinkService {

    @Transactional
    void insertLink(FriendlyLinkBo friendlyLinkBo) throws WrongFieldException;

    void updateLink(FriendlyLinkBo friendlyLinkBo) throws WrongFieldException;

    FriendlyLinkBo selectLinkByLinkId(Integer linkId) throws NoSuchBeanException;

    PageInfo<FriendlyLinkBo> selectLinks(Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    void deleteLinkByLinkId(Integer linkId) throws NoSuchBeanException;
}
