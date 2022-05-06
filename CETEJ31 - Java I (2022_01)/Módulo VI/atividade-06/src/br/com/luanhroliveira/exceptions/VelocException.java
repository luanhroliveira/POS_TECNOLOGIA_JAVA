package br.com.luanhroliveira.exceptions;

public class VelocException extends RuntimeException{

    public VelocException() {
    }

    public VelocException(String message) {
        super(message);
    }

    public VelocException(String message, Throwable cause) {
        super(message, cause);
    }

    public VelocException(Throwable cause) {
        super(cause);
    }

    public VelocException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
