package com.codezealer.zmall.common.http;

public enum ResultCode {
    SUCCESS("0", "操作成功"),
    FAIL("-1", "操作失败"),
    SYSTEM_ERROR("10000", "系统异常，请稍后再试"),
    CONTENT_IS_EXIST("10001", "已经存在，请勿重复"),
    ERR_TIME_EXPIRE("10004", "请求超时，请重试"),
    ERR_MISS_TOKEN("10008", "参数token缺失"),
    ERR_CONTENT_NOT_NULL("10011", "请填写内容，不能为空"),

    ;
    private String code;
    private String msg;

    public String code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }

    private ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}