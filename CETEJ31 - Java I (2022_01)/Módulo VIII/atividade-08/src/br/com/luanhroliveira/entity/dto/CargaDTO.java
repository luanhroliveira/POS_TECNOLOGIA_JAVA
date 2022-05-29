package br.com.luanhroliveira.entity.dto;

import br.com.luanhroliveira.entity.Carga;

public class CargaDTO {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private int qtdPist;
    private int potencia;
    private int cargaMax;
    private int tara;

    public CargaDTO() {
    }

    public CargaDTO(
        String placa,
        String marca,
        String modelo,
        String cor,
        float velocMax,
        int qtdRodas,
        int qtdPist,
        int potencia,
        int cargaMax,
        int tara
    ) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.qtdPist = qtdPist;
        this.potencia = potencia;
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public CargaDTO(Carga carga) {
        this.placa = carga.getPlaca();
        this.marca = carga.getMarca();
        this.modelo = carga.getModelo();
        this.cor = carga.getCor();
        this.velocMax = carga.getVelocMax();
        this.qtdRodas = carga.getQtdRodas();
        this.qtdPist = carga.getMotor().getQtdPist();
        this.potencia = carga.getMotor().getPotencia();
        this.cargaMax = carga.getCargaMax();
        this.tara = carga.getTara();
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

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }
}
