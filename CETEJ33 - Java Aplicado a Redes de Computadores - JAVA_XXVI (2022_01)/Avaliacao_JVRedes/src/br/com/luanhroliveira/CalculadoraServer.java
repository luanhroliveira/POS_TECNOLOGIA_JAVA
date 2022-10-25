package br.com.luanhroliveira;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraServer {
    public CalculadoraServer() {
    }

    public static void main(String args[]) {
        try {
            Calculadora calc = new CalculadoraImpl();
            Registry registro = LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/CalcServer", calc);
        } catch (Exception e) {
            System.out.println("Erro RMI: " + e.toString());
        }
    }

}
