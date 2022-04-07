package br.com.luanhroliveira.entity;

import br.com.luanhroliveira.interfaces.Calcular;

public final class Carga extends Veiculo implements Calcular {

    private int cargaMax;
    private int tara;

    private static final int HUNDRED_THOUSAND = 100000;


    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    float calcVel(float velocMax) {
        return velocMax * HUNDRED_THOUSAND;
    }

    @Override
    public int calcular() {
        return getPlaca().length()
            + getCor().length()
            + getMarca().length()
            + getModelo().length();
    }

    @Override
    public String toString() {
        return
            super.toString() +
                " Carga{" +
                "cargaMax=" + cargaMax +
                ", tara=" + tara +
                ", calculo=" + calcular() +
                ", Cm/h=" + calcVel(getVelocMax()) +
                "}" +
                '}';
    }

}
