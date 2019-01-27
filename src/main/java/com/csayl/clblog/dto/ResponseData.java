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
    private T data;


    public static <T> ResponseData<T> succeed() {
        return succeed(null);
    }

    public static <T> ResponseData<T> succeed(T data) {
        return succeed("操作成功", data);
    }

    public static <T> ResponseData<T> succeed(String msg) {
        return succeed(msg, null);
    }

    public static <T> ResponseData<T> succeed(String msg, T data) {
        return new ResponseData<>(StatusCode.SUCCESS, msg, data);
    }

    public static <T> ResponseData<T> fail() {
        return fail(null);
    }

    public static <T> ResponseData<T> fail(T data) {
        return fail("操作失败", data);
    }

    public static <T> ResponseData<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> ResponseData<T> fail(String msg, T data) {
        return new ResponseData<>(StatusCode.FAILURE, msg, data);
    }
}
