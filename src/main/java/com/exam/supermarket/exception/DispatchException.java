package com.exam.supermarket.exception;

import com.exam.core.common.exception.SystemException;
import jakarta.servlet.http.HttpServletResponse;

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

    @Override
    protected void init() {
        this.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
    }
}
