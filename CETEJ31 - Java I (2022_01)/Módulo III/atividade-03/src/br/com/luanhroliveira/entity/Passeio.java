package br.com.luanhroliveira.entity;

public final class Passeio extends Veiculo {

    private int qtdPassageiros;

    private static final int ONE_THOUSAND = 1000;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    float calcVel(float velocMax) {
        return velocMax * ONE_THOUSAND;
    }

    @Override
    public String toString() {
        return
            super.toString() +
                " Passeio{" +
                "qtdPassageiros=" + qtdPassageiros +
                "}" +
                "}";
    }
}
