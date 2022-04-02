package br.com.luanhroliveira.entity;

public final class Carga extends Veiculo {

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
    public String toString() {
        return
            super.toString() +
                " Carga{" +
                "cargaMax=" + cargaMax +
                ", tara=" + tara +
                "}" +
                '}';
    }
}
