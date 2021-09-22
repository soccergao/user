package com.soccergao.user.exceptions;

public class JsonConversionException extends BaseException {
    public JsonConversionException() {
        super();
    }

    public JsonConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonConversionException(String message) {
        super(message);
    }

    public JsonConversionException(Throwable cause) {
        super(cause);
    }
}
