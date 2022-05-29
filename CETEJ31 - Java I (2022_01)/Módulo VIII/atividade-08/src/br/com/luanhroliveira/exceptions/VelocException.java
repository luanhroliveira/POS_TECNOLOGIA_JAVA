package br.com.luanhroliveira.exceptions;

public class VelocException extends RuntimeException {

    private static final String MESSAGE = "A velocidade máxima está fora dos limites brasileiros";

    public VelocException() {
        super(MESSAGE);
    }

}
