package br.com.luanhroliveira;

import java.rmi.Naming;

public class CalculadoraCliente {

    public static void main(String args[]) {
        try {
            Calculadora calc =
                (Calculadora) Naming.lookup("rmi://localhost/CalcServer");
            System.out.println("A SOMA de 1 e 5 é: " + calc.add(1, 5));
            System.out.println("A SUBTRAÇÃO de 1 e 5 é: " + calc.sub(1, 5));
            System.out.println("A MULTIPLICAÇÃO de 1 e 5 é: " + calc.mul(1, 5));
            System.out.println("A DIVISÃO de 1 e 5 é: " + calc.div(1, 5));

            int inicio, x;
            x = 0;
            inicio = 10;

            if(inicio % x == 0){

            }

        } catch (Exception e) {
            System.out.println("Erro RMI: " + e.toString());
        }
    }

}
