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
