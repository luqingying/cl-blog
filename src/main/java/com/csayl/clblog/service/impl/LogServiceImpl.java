package com.csayl.clblog.service.impl;

import com.csayl.clblog.constant.OrderBy;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.mapper.LogMapper;
import com.csayl.clblog.model.bo.LogBo;
import com.csayl.clblog.model.domain.Log;
import com.csayl.clblog.model.domain.LogExample;
import com.csayl.clblog.service.LogService;
import com.csayl.clblog.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class LogServiceImpl implements LogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);

    private final LogMapper logMapper;

    @Autowired
    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }


    @Transactional
    @Override
    public void insertLog(LogBo logBo) {
        logMapper.insert(logBo.getLog());
    }

    @Cacheable("log")
    @Override
    public PageInfo<LogBo> selectLogByIp(String ip, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return getLogBoPageInfo(new Attribute(Type.IP, ip), pageNum, pageSize, OrderBy.CREATE_TIME_DESC);
    }

    @Cacheable("log")
    @Override
    public PageInfo<LogBo> selectLogByUrl(String url, Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return getLogBoPageInfo(new Attribute(Type.URL, url), pageNum, pageSize, OrderBy.CREATE_TIME_DESC);
    }

    @Cacheable("log")
    @Override
    public Integer getCount() {
        return logMapper.countByExample(null);
    }

    @Cacheable("log")
    @Override
    public PageInfo<LogBo> selectAllLog(Integer pageNum, Integer pageSize) throws NoSuchBeanException {
        return getLogBoPageInfo(new Attribute(Type.ALL, null), pageNum, pageSize, OrderBy.CREATE_TIME_DESC);
    }

    @Override
    public void deleteByIds(List<Long> ids) throws NoSuchBeanException {
        try {
            LogExample logExample = new LogExample();
            if (ids != null && !ids.isEmpty()) {
                logExample.createCriteria().andLogIdIn(ids);
            }
            logMapper.deleteByExample(logExample);
        } catch (Exception e) {
            LOGGER.debug("该日志不存在", e);
            throw new NoSuchBeanException("该日志不存在");
        }
    }


    //----------------------------Common Method----------------------------
    @Data
    @AllArgsConstructor
    private class Attribute {
        private Type type;
        private String val;
    }

    private enum Type {
        IP, URL, ALL
    }

    private PageInfo<LogBo> getLogBoPageInfo(Attribute attribute, Integer pageNum, Integer pageSize, OrderBy orderBy) throws NoSuchBeanException {
        PageHelper.startPage(pageNum, pageSize);
        LogExample logExample = new LogExample();
        logExample.setOrderByClause(orderBy.getField());

        switch (attribute.type) {
            case IP:
                logExample.createCriteria().andVisitorIpEqualTo(attribute.val);
                break;
            case URL:
                logExample.createCriteria().andVisitUrlEqualTo(attribute.val);
                break;
        }

        List<Log> logs = logMapper.selectByExample(logExample);
        if (logs == null || logs.isEmpty()) {
            throw new NoSuchBeanException("暂时没有日志");
        }

        //将Log拼装为LogBo
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        PageInfo<LogBo> res = PageUtils.copyPageInfo(pageInfo);
        List<LogBo> list = new ArrayList<>();
        for (Log log : logs) {
            LogBo logBo = new LogBo();
            logBo.setLog(log);
            list.add(logBo);
        }
        res.setList(list);
        return res;
    }
}
