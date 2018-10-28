package com.yh.exception;

/**
 * 异常捕捉
 */
public class StudentException extends Exception {

    public StudentException() {super();}

    public StudentException(String msg) {super(msg);}

    public StudentException(String msg, Throwable throwable) {super(msg, throwable);}

    public StudentException(Throwable throwable) {super(throwable);}

    public StudentException(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {super(message, cause, enableSuppression, writableStackTrace);
    }
}
