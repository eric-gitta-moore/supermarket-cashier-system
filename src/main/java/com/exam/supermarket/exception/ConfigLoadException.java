package com.exam.supermarket.exception;

import com.exam.core.common.exception.SystemException;

public class ConfigLoadException extends SystemException {

    private static final long serialVersionUID = 8394597082398429124L;

    public ConfigLoadException() {
        super();
    }

    public ConfigLoadException(String message) {
        super(message);
    }

    public ConfigLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigLoadException(Throwable cause) {
        super(cause);
    }
}
