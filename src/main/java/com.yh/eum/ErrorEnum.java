package com.yh.eum;

public enum ErrorEnum {

    ERROR(-1, "失败"),

    NOT_VALUE_ERROR(-2, "传参不能为空"),

    NOT_PHONE(-3, "该手机号码格式不正确！");

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
