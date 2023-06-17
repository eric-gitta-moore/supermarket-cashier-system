package com.exam.core.common.exception;

public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -6700617689220076334L;

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
