package br.com.luanhroliveira.services;

import java.util.Scanner;

public class Leitura {

    private static final Scanner sc = new Scanner(System.in);

    public static String entDados(String entDados) {
        System.out.println(entDados);
        return sc.nextLine();
    }
}
