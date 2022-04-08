package br.com.luanhroliveira.services;

import java.util.Scanner;

public class Leitura {

    public static String entDados(String entDados) {
        Scanner sc = new Scanner(System.in);
        System.out.println(entDados);
        String saidaDados = sc.nextLine();
        sc.close();
        return saidaDados;
    }
}
