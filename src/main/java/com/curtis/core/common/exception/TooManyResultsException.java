package com.curtis.core.common.exception;

public class TooManyResultsException extends SystemException {

    private static final long serialVersionUID = 3880059165357791683L;

    public TooManyResultsException() {
    }

    public TooManyResultsException(String message) {
        super(message);
    }

    public TooManyResultsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyResultsException(Throwable cause) {
        super(cause);
    }
}
