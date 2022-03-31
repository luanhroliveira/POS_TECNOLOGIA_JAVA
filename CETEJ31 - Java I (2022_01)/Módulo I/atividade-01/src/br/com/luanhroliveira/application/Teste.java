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
            System.out.println("1 - Cadastrar um novo veiculo.");
            System.out.println("2 - Listar todos os veículos.");
            System.out.println("3 - Sair. \n");
            System.out.print("Digite: ");

            try {
                acao = sc.nextInt();
                switch (acao) {
                    case 1:
                        veiculoService.adicionarNovoVeiculoALista(veiculos, sc);
                        System.out.println("Veículo cadastrado com sucesso!");
                        break;
                    case 2:
                        veiculoService.listarVeiculos(veiculos);
                        System.out.println();
                        break;
                    case 3:
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
