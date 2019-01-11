package com.yh.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 便于包装返回信息并将其返回给前台
 * @param <T>
 */
@Setter
@Getter
@ToString
public class ResponseManager<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回数据
     */
    private T date;

    /**
     * 返回消息
     */
    private String msg;
}
