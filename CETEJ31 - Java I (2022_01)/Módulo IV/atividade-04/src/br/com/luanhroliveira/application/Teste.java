package br.com.luanhroliveira.application;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.services.VeiculoService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VeiculoService veiculoService = new VeiculoService();

        List<Passeio> passeios = new ArrayList<>();
        List<Carga> cargas = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("----------------------------------------------");
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial\n");
            System.out.println("1. Cadastrar Veículo de Passeio");
            System.out.println("2. Cadastrar Veículo de Carga");
            System.out.println("3. Imprimir Todos os Veículos de Passeio");
            System.out.println("4. Imprimir Todos os Veículos de Carga");
            System.out.println("5. Imprimir Veículo de Passeio pela Placa");
            System.out.println("6. Imprimir Veículo de Carga pela Placa");
            System.out.println("7. Sair do Sistema \n");
            System.out.print("Digite: ");

            try {
                int acao = sc.nextInt();
                switch (acao) {
                    case 1:
                        veiculoService.adicionarNovoVeiculoDePasseioALista(passeios, sc);
                        System.out.println("Veículo de passeio cadastrado com sucesso!");
                        break;
                    case 2:
                        veiculoService.adicionarNovoVeiculoDeCargaALista(cargas, sc);
                        System.out.println("Veículo de carga cadastrado com sucesso!");
                        break;
                    case 3:
                        veiculoService.listarVeiculosDePasseio(passeios);
                        System.out.println();
                        break;
                    case 4:
                        veiculoService.listarVeiculosDeCarga(cargas);
                        System.out.println();
                        break;
                    case 5:
                        veiculoService.listarVeiculoDePasseioPorPlaca(passeios, sc);
                        System.out.println();
                        break;
                    case 6:
                        veiculoService.listarVeiculoDeCargaPorPlaca(cargas, sc);
                        System.out.println();
                        break;
                    case 7:
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
