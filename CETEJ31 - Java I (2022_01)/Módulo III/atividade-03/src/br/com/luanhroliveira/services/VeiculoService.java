package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.entity.Veiculo;

import java.util.List;
import java.util.Scanner;

public class VeiculoService {

    public void adicionarNovoVeiculoDePasseioALista(List<Veiculo> veiculoList, Scanner sc) {
        Passeio passeio = new Passeio();

        System.out.println("Digite a placa:");
        sc.nextLine();
        passeio.setPlaca(sc.nextLine());

        System.out.println("Digite a marca:");
        passeio.setMarca(sc.nextLine());

        System.out.println("Digite o modelo:");
        passeio.setModelo(sc.nextLine());

        System.out.println("Digite a cor:");
        passeio.setCor(sc.nextLine());

        System.out.println("Digite velocidade máxima:");
        passeio.setVelocMax(sc.nextFloat());

        System.out.println("Digite a quantidade de rodas:");
        passeio.setQtdRodas(sc.nextInt());

        System.out.println("Digite a quantidade de pistões do Motor:");
        int qtdPist = sc.nextInt();

        System.out.println("Digite a potência do Motor:");
        int potencia = sc.nextInt();

        passeio.setMotor(qtdPist, potencia);

        System.out.println("Digite a quantidade de passageiros do veículo:");
        passeio.setQtdPassageiros(sc.nextInt());

        veiculoList.add(passeio);
    }

    public void adicionarNovoVeiculoDeCargaALista(List<Veiculo> veiculoList, Scanner sc) {
        Carga carga = new Carga();

        System.out.println("Digite a placa:");
        sc.nextLine();
        carga.setPlaca(sc.nextLine());

        System.out.println("Digite a marca:");
        carga.setMarca(sc.nextLine());

        System.out.println("Digite o modelo:");
        carga.setModelo(sc.nextLine());

        System.out.println("Digite a cor:");
        carga.setCor(sc.nextLine());

        System.out.println("Digite velocidade máxima:");
        carga.setVelocMax(sc.nextFloat());

        System.out.println("Digite a quantidade de rodas:");
        carga.setQtdRodas(sc.nextInt());

        System.out.println("Digite a quantidade de pistões do Motor:");
        int qtdPist = sc.nextInt();

        System.out.println("Digite a potência do Motor:");
        int potencia = sc.nextInt();

        carga.setMotor(qtdPist, potencia);

        System.out.println("Digite a carga máxima:");
        carga.setCargaMax(sc.nextInt());

        System.out.println("Digite a tara:");
        carga.setTara(sc.nextInt());

        veiculoList.add(carga);
    }

    public void listarVeiculos(List<Veiculo> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }

    public void listarVeiculosDePasseio(List<Veiculo> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.stream()
                .filter(passeio -> passeio.getClass().equals(Passeio.class))
                .forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }

    public void listarVeiculosDeCarga(List<Veiculo> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.stream()
                .filter(passeio -> passeio.getClass().equals(Carga.class))
                .forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }
}
