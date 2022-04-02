package br.com.luanhroliveira.application;

import br.com.luanhroliveira.entity.Veiculo;
import br.com.luanhroliveira.services.VeiculoService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VeiculoService veiculoService = new VeiculoService();

        List<Veiculo> veiculos = new ArrayList<>();
        int acao;

        boolean exit = false;
        while (!exit) {
            System.out.println("-----------------------------");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar um novo veiculo do tipo Passeio.");
            System.out.println("2 - Cadastrar um novo veiculo do tipo Carga.");
            System.out.println("3 - Listar todos os veículos de Passeio.");
            System.out.println("4 - Listar todos os veículos de Carga.");
            System.out.println("5 - Listar todos os veículos.");
            System.out.println("6 - Sair. \n");
            System.out.print("Digite: ");

            try {
                acao = sc.nextInt();
                switch (acao) {
                    case 1:
                        veiculoService.adicionarNovoVeiculoDePasseioALista(veiculos, sc);
                        System.out.println("Veículo de passeio cadastrado com sucesso!");
                        break;
                    case 2:
                        veiculoService.adicionarNovoVeiculoDeCargaALista(veiculos, sc);
                        System.out.println("Veículo de carga cadastrado com sucesso!");
                        break;
                    case 3:
                        veiculoService.listarVeiculosDePasseio(veiculos);
                        System.out.println();
                        break;
                    case 4:
                        veiculoService.listarVeiculosDeCarga(veiculos);
                        System.out.println();
                        break;
                    case 5:
                        veiculoService.listarVeiculos(veiculos);
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Finalizando...");
                        exit = true;
                        sc.close();
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente! \n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada de dados inválida!\nVerifique o tipo de dado que está inserindo.");
                sc.nextLine();
            }
        }
    }
}
