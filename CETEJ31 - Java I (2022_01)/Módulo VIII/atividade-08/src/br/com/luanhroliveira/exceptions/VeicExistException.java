package br.com.luanhroliveira.exceptions;

public class VeicExistException extends RuntimeException {

    private static final String MESSAGE = "Já existe um veículo com esta placa";

    public VeicExistException() {
        super(MESSAGE);
    }

}
