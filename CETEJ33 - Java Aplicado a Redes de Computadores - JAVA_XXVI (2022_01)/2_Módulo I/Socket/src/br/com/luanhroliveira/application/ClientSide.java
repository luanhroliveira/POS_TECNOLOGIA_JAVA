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
