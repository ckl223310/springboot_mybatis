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

    private int code;

    private T date;

    private String msg;
}
