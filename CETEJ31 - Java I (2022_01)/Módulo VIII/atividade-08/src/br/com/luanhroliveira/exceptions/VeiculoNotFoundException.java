package br.com.luanhroliveira.exceptions;

public class VeiculoNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Veiculo não encontrado";

    public VeiculoNotFoundException() {
        super(MESSAGE);
    }

}
