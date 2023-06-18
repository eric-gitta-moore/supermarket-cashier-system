package com.exam.supermarket.exception;

import com.exam.core.common.exception.SystemException;
import jakarta.servlet.http.HttpServletResponse;

public class UnauthorizedException extends SystemException {

    private static final long serialVersionUID = 8394597082398429124L;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    @Override
    protected void init() {
        this.setStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
