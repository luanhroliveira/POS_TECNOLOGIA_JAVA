package br.com.luanhroliveira.exceptions;

public class VeicExistException extends RuntimeException{

    public VeicExistException() {
    }

    public VeicExistException(String message) {
        super(message);
    }

    public VeicExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public VeicExistException(Throwable cause) {
        super(cause);
    }

    public VeicExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
