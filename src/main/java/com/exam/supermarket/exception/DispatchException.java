package com.exam.supermarket.exception;

import com.exam.core.common.exception.SystemException;

public class DispatchException extends SystemException {

    private static final long serialVersionUID = 8394597082398429124L;

    public DispatchException() {
        super();
    }

    public DispatchException(String message) {
        super(message);
    }

    public DispatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DispatchException(Throwable cause) {
        super(cause);
    }
}
