package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Veiculo;

import java.util.List;
import java.util.Scanner;

public class VeiculoService {

    public void adicionarNovoVeiculoALista(List<Veiculo> veiculoList, Scanner sc) {
        Veiculo veiculo = new Veiculo();

        System.out.println("Digite a placa:");
        sc.nextLine();
        veiculo.setPlaca(sc.nextLine());

        System.out.println("Digite a marca:");
        veiculo.setMarca(sc.nextLine());

        System.out.println("Digite o modelo:");
        veiculo.setModelo(sc.nextLine());

        System.out.println("Digite a cor:");
        veiculo.setCor(sc.nextLine());

        System.out.println("Digite velocidade máxima:");
        veiculo.setVelocMax(sc.nextFloat());

        System.out.println("Digite a quantidade de rodas:");
        veiculo.setQtdRodas(sc.nextInt());

        System.out.println("Digite a quantidade de pistões:");
        int qtdPist = sc.nextInt();

        System.out.println("Digite a potência:");
        int potencia = sc.nextInt();

        veiculo.setMotor(qtdPist, potencia);

        veiculoList.add(veiculo);
    }

    public void listarVeiculos(List<Veiculo> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }
}
