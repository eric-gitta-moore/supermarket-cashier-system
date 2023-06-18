package com.exam.core.common.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

public class SystemException extends RuntimeException {

    @Getter
    @Setter
    private int statusCode;

    private static final long serialVersionUID = -6700617689220076334L;

    public SystemException() {
        this.init();
    }

    public SystemException(String message) {
        super(message);
        this.init();
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
        this.init();
    }

    public SystemException(Throwable cause) {
        super(cause);
        this.init();
    }

    protected void init() {
        this.statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }
}
