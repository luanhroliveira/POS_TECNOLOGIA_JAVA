package br.com.luanhroliveira.application;

import br.com.luanhroliveira.repositories.BDVeiculos;
import br.com.luanhroliveira.services.Leitura;
import br.com.luanhroliveira.services.VeiculoService;

import java.util.InputMismatchException;

public class Teste {

    public static void main(String[] args) {

        VeiculoService veiculoService = new VeiculoService();

        BDVeiculos veiculoRepository = new BDVeiculos();

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

            try {
                int acao = Integer.parseInt(Leitura.entDados("Digite: "));
                switch (acao) {
                    case 1:
                        System.out.println(veiculoService.adicionarNovoVeiculoDePasseioALista(veiculoRepository.getPasseios()));
                        System.out.println();
                        break;
                    case 2:
                        System.out.println(veiculoService.adicionarNovoVeiculoDeCargaALista(veiculoRepository.getCargas()));
                        System.out.println();
                        break;
                    case 3:
                        System.out.println(veiculoService.listarVeiculosDePasseio(veiculoRepository.getPasseios()));
                        System.out.println();
                        break;
                    case 4:
                        System.out.println(veiculoService.listarVeiculosDeCarga(veiculoRepository.getCargas()));
                        System.out.println();
                        break;
                    case 5:
                        System.out.println(veiculoService.listarVeiculoDePasseioPorPlaca(veiculoRepository.getPasseios()));
                        System.out.println();
                        break;
                    case 6:
                        System.out.println(veiculoService.listarVeiculoDeCargaPorPlaca(veiculoRepository.getCargas()));
                        System.out.println();
                        break;
                    case 7:
                        System.out.println("Finalizando...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente! \n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada de dados inválida!\nVerifique o tipo de dado que está inserindo.");
            }
        }
    }
}
