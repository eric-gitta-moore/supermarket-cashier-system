package com.exam.supermarket.exception;

import com.exam.core.common.exception.SystemException;

public class ConfigParseException extends SystemException {

    private static final long serialVersionUID = 8394597082398429124L;

    public ConfigParseException() {
        super();
    }

    public ConfigParseException(String message) {
        super(message);
    }

    public ConfigParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigParseException(Throwable cause) {
        super(cause);
    }
}
