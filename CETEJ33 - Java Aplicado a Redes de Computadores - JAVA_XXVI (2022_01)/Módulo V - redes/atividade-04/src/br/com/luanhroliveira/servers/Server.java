package br.com.luanhroliveira.servers;

import br.com.luanhroliveira.entities.Pessoa;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream input
                = new ObjectInputStream(this.getSocket().getInputStream());
            Pessoa received = (Pessoa) input.readObject();
            DataOutputStream output
                = new DataOutputStream(this.getSocket().getOutputStream());
            output.writeUTF("Dados recebidos corretamente!");
            this.getSocket().close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            System.out.println("Servidor iniciado. Aguardando conexão...");
            while (true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                System.out.println("Client connected!");
                server.start();
            }
        } catch (IOException e) {
        }
    }

    public Socket getSocket() {
        return this.socket;
    }
}
