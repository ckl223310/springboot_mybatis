package com.yh.utils;


import com.yh.exception.ResponseManager;

public class ResultUtils {

    private ResultUtils() {
    }

    public static <T> ResponseManager<T> success(int code, T data, String msg) {
        ResponseManager<T> responseManager = new ResponseManager<T>();

        code = code < 0 ? 0 : code;

        responseManager.setCode(code);
        responseManager.setDate(data);
        responseManager.setMsg(msg);
        return responseManager;
    }

    public static <T> ResponseManager<T> success(T data) {
        return success(0, data, "成功");
    }

    public static <T> ResponseManager<T> success(String msg) {
        return success(0, null, msg);
    }

    public static <T> ResponseManager<T> success() {
        return success(0, null, "成功");
    }

    public static <T> ResponseManager<T> error(int code, T data, String msg) {
        ResponseManager<T> responseManager = new ResponseManager<T>();
        code = code >= 0 ? -1 : code;
        responseManager.setCode(code);
        responseManager.setDate(data);
        responseManager.setMsg(msg);

        return responseManager;
    }

    public static <T> ResponseManager<T> error(int code, String msg) {
        return error(code, null, msg);
    }

    public static <T> ResponseManager<T> error(int code) {
        return error(code, null, "失败");
    }

    public static <T> ResponseManager<T> error(String msg) {
        return error(-1, null, msg);
    }

}
