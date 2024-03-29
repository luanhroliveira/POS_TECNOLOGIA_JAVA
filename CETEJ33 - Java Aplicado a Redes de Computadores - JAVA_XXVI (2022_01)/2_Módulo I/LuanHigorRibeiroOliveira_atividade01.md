````java
package br.com.luanhroliveira.validator;

import java.util.InputMismatchException;

/*
 * @Link{https://github.com/feharaujo/Cpf-Validator/blob/master/src/com/fearaujo/CpfValidator.java}
 */
public class CpfValidator {

    public static boolean isCPF(String CPF) {
        if (CPF == null)
            return false;

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
            CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
            || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
            || CPF.equals("99999999999") || (CPF.length() != 11))
            return false;
        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);
            // converte no respectivo caractere numerico
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);
            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}
````

````java
package br.com.luanhroliveira.application;

import br.com.luanhroliveira.validator.CpfValidator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(50000);
            socket = serverSocket.accept();

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String result;
            String value = dataInputStream.readUTF();
            if (CpfValidator.isCPF(value)) {
                result = "CPF Válido!";
            } else
                result = "CPF Inválido!";

            dataOutputStream.writeUTF(result);

            socket.close();
        } catch (IOException ignored) {

        }
    }
}
````

````java
package br.com.luanhroliveira.application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSide {

    private static Socket socket;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 50000);

            inputStream = new DataInputStream(socket.getInputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite um CPF: ");

            String value = br.readLine();

            outputStream.writeUTF(value);

            String result = inputStream.readUTF();

            System.out.println(result);

            socket.close();
        } catch (Exception e) {

        }
    }
}
````