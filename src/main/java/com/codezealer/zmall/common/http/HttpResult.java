package com.codezealer.zmall.common.http;

import lombok.Data;

@Data
public class HttpResult<T> {
    private String code;
    private String msg;

    private T data;

    public HttpResult() {
        this.code = ResultCode.SUCCESS.code();
    }

    public HttpResult(String code, String msg, T data) {
        this.code = ResultCode.SUCCESS.code();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(ResultCode resultCode) {
        this.code = ResultCode.SUCCESS.code();
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public static <T> HttpResult<T> error() {
        return error(ResultCode.SYSTEM_ERROR.code(), ResultCode.SYSTEM_ERROR.msg());
    }

    public static <T> HttpResult<T> error(String msg) {
        return error(ResultCode.FAIL.code(), msg);
    }

    public static <T> HttpResult<T> error(String code, String msg) {
        HttpResult<T> r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> HttpResult<T> error(ResultCode resultCode) {
        return error(resultCode.code(), resultCode.msg());
    }

    public static <T> HttpResult<T> ok(T data) {
        HttpResult<T> r = new HttpResult();
        r.setData(data);
        return r;
    }

    public static <T> HttpResult<T> ok() {
        HttpResult<T> httpResult = new HttpResult();
        httpResult.setMsg(ResultCode.SUCCESS.msg());
        return httpResult;
    }
}
