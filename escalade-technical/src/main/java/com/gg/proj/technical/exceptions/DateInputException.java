package com.gg.proj.technical.exceptions;

public class DateInputException extends Exception {
    public DateInputException() {
        super();
    }

    public DateInputException(String message) {
        super(message);
    }

    public DateInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateInputException(Throwable cause) {
        super(cause);
    }

    protected DateInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
