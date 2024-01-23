package com.example.springboot.utils;

import com.example.springboot.exception.ErrorCode;
import lombok.Data;

@Data
public class Result {
    // 消息码
    private int code;
    // 消息体
    private Object data;
    // 消息提示
    private String msg;

    public Result() {
    }

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result success(String msg, Object data, int errorCode) {
        this.code = errorCode;
        this.msg = msg;
        this.data = data;
        return this;
    }


    public Result success(String msg, Object data) {
        this.code = ErrorCode.NORMAL_SUCCESS;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Result success(String msg) {
        this.code = ErrorCode.NORMAL_SUCCESS;
        this.msg = msg;
        return this;
    }

    public Result fail(String msg, Object data, int errorCode) {
        this.code = errorCode;
        this.msg = msg;
        this.data = data;
        return this;
    }


    public Result fail(String msg, Object data) {
        this.code = ErrorCode.NORMAL_ERROR;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Result fail(String msg) {
        this.code = ErrorCode.NORMAL_ERROR;
        this.msg = msg;
        return this;
    }

}
