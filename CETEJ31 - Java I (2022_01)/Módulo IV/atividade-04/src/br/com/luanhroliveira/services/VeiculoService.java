package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.entity.Veiculo;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VeiculoService {

    public void adicionarNovoVeiculoDePasseioALista(List<Passeio> veiculoList, Scanner sc) {
        boolean exit = false;
        while (!exit) {
            if (veiculoList.size() >= 5) {
                System.out.println("Limite máximo de 5 carros atingido!\n");
                return;
            }

            Passeio passeio = new Passeio();

            System.out.println("Digite a placa:");
            sc.nextLine();
            String placa = sc.nextLine();

            boolean veiculoExistente = veiculoList.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
            if (veiculoExistente) {
                System.out.println("Veículo já cadastrado!\n");
                return;
            }
            passeio.setPlaca(placa);

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

            System.out.print("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ");
            exit = sc.nextLine().equals("S");
        }
    }

    public void adicionarNovoVeiculoDeCargaALista(List<Carga> veiculoList, Scanner sc) {
        boolean exit = false;
        while (!exit) {
            if (veiculoList.size() >= 5) {
                System.out.println("Limite máximo de 5 carros atingido!\n");
                return;
            }

            Carga carga = new Carga();

            System.out.println("Digite a placa:");
            sc.nextLine();
            String placa = sc.nextLine();

            boolean veiculoExistente = veiculoList.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
            if (veiculoExistente) {
                System.out.println("Veículo já cadastrado!\n");
                return;
            }

            carga.setPlaca(placa);

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

            System.out.print("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ");
            exit = sc.nextLine().equals("S");
        }
    }

    public void listarVeiculosDePasseio(List<Passeio> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }

    public void listarVeiculosDeCarga(List<Carga> veiculoList) {
        if (!veiculoList.isEmpty()) {
            veiculoList.forEach(System.out::println);
        } else System.out.println("Não existem veículos cadastrados. \n");
    }

    public void listarVeiculoDePasseioPorPlaca(List<Passeio> passeios, Scanner sc) {
        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();
        passeios.stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .forEach(System.out::println);
    }

    public void listarVeiculoDeCargaPorPlaca(List<Carga> cargas, Scanner sc) {
        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();
        cargas.stream()
            .filter(carga -> carga.getPlaca().equals(placa))
            .forEach(System.out::println);
    }
}
