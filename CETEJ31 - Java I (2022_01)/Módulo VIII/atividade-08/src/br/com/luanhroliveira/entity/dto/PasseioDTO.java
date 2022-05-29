package br.com.luanhroliveira.entity.dto;

import br.com.luanhroliveira.entity.Passeio;

public class PasseioDTO {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private int qtdPist;
    private int potencia;
    private int qtdPassageiros;

    public PasseioDTO() {
    }

    public PasseioDTO(
        String placa,
        String marca,
        String modelo,
        String cor,
        float velocMax,
        int qtdRodas,
        int qtdPist,
        int potencia,
        int qtdPassageiros
    ) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.qtdPist = qtdPist;
        this.potencia = potencia;
        this.qtdPassageiros = qtdPassageiros;
    }

    public PasseioDTO(Passeio passeio) {
        this.placa = passeio.getPlaca();
        this.marca = passeio.getMarca();
        this.modelo = passeio.getModelo();
        this.cor = passeio.getCor();
        this.velocMax = passeio.getVelocMax();
        this.qtdRodas = passeio.getQtdRodas();
        this.qtdPist = passeio.getMotor().getQtdPist();
        this.potencia = passeio.getMotor().getPotencia();
        this.qtdPassageiros = passeio.getQtdPassageiros();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }


}
