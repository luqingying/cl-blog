package com.csayl.clblog.service;

import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.LogBo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/15
 **/
public interface LogService {
    @Transactional
    void insertLog(LogBo logBo);

    PageInfo<LogBo> selectAllLog(Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<LogBo> selectLogByIp(String ip, Integer pageNum, Integer pageSize) throws NoSuchBeanException;

    PageInfo<LogBo> selectLogByUrl(String url, Integer pageNum, Integer pageSize) throws NoSuchBeanException;


    /**
     * 删除日志，ids为null，即删除所有
     *
     * @param ids 待删除日志ID
     * @throws NoSuchBeanException 该日志不存在
     */
    void deleteByIds(List<Long> ids) throws NoSuchBeanException;
}
