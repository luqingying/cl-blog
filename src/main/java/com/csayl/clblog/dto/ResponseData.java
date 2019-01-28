package com.csayl.clblog.dto;

import com.csayl.clblog.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chen
 * @date: 2019/1/20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {
    //状态码
    private StatusCode statusCode;

    //信息
    private String msg;

    //返回数据
    private T resource;


    public static <T> ResponseData<T> succeed() {
        return succeed(null);
    }

    public static <T> ResponseData<T> succeed(T resource) {
        return succeed("操作成功", resource);
    }

    public static <T> ResponseData<T> succeed(String msg) {
        return succeed(msg, null);
    }

    public static <T> ResponseData<T> succeed(String msg, T resource) {
        return new ResponseData<>(StatusCode.SUCCESS, msg, resource);
    }

    public static <T> ResponseData<T> fail() {
        return fail(null);
    }

    public static <T> ResponseData<T> fail(T resource) {
        return fail("操作失败", resource);
    }

    public static <T> ResponseData<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> ResponseData<T> fail(String msg, T resource) {
        return new ResponseData<>(StatusCode.FAILURE, msg, resource);
    }
}
