package com.yh.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseManager<T> {

    private int code;

    private T date;

    private String msg;
}
