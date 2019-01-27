package com.csayl.clblog.util;

import com.github.pagehelper.PageInfo;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
public class PageUtils {
    /**
     * 复制原有的分页信息（不包括数据）
     *
     * @param origin 待复制的分页信息
     * @param <T>    结果类型
     * @return 除数据的所有分页信息
     */
    public static <T> PageInfo<T> copyPageInfo(PageInfo origin) {
        PageInfo<T> res = new PageInfo<>();
        res.setPageSize(origin.getPageSize());
        res.setPageNum(origin.getPageNum());
        res.setEndRow(origin.getEndRow());
        res.setTotal(origin.getTotal());
        res.setHasNextPage(origin.isHasNextPage());
        res.setHasPreviousPage(origin.isHasPreviousPage());
        res.setIsFirstPage(origin.isIsFirstPage());
        res.setIsLastPage(origin.isIsLastPage());
        res.setNavigateFirstPage(origin.getNavigateFirstPage());
        res.setNavigateLastPage(origin.getNavigateLastPage());
        res.setNavigatepageNums(origin.getNavigatepageNums());
        res.setSize(origin.getSize());
        res.setPrePage(origin.getPrePage());
        res.setNextPage(origin.getNextPage());
        return res;
    }
}
