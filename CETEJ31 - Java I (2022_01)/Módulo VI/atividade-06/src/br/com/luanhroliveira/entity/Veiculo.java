package br.com.luanhroliveira.entity;

import br.com.luanhroliveira.exceptions.VelocException;

public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velocMax = 0F;
        this.qtdRodas = 0;
        this.motor = new Motor();
    }

    public Veiculo(
        String placa,
        String marca,
        String modelo,
        String cor,
        float velocMax,
        int qtdRodas,
        int qtdPist,
        int potencia
    ) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = new Motor(qtdPist, potencia);
    }

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) throws VelocException {
        if (velocMax < 80 || velocMax > 110) {
            throw new VelocException("“A velocidade máxima está fora dos limites brasileiros");
        }
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(int qtdPist, int potencia) {
        this.motor = new Motor(qtdPist, potencia);
    }

    abstract float calcVel(float velocMax);

    @Override
    public String toString() {
        return "Veiculo{" +
            "placa='" + placa + '\'' +
            ", marca='" + marca + '\'' +
            ", modelo='" + modelo + '\'' +
            ", cor='" + cor + '\'' +
            ", velocMax=" + velocMax +
            ", qtdRodas=" + qtdRodas +
            ", motor=" + motor;
    }
}
