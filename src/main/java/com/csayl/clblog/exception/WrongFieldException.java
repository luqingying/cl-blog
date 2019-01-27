package com.csayl.clblog.exception;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
public class WrongFieldException extends Exception {
    public WrongFieldException() {
        super();
    }

    public WrongFieldException(String message) {
        super(message);
    }

    public WrongFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFieldException(Throwable cause) {
        super(cause);
    }

    protected WrongFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
