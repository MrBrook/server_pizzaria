package br.com.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private ServerSocket socketServidor;


    public Servidor() {
        inicializaConexao();
    }

    public void inicializaConexao() {
        try {
            socketServidor = new ServerSocket(9999);
            while(true) {
                Socket socket = socketServidor.accept();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            ObjectInputStream fEntrada = new ObjectInputStream(socket.getInputStream());
                            ObjectOutputStream fSaida = new ObjectOutputStream(socket.getOutputStream());



                            System.out.println(fEntrada.readObject());
                            System.out.println(fEntrada.readObject());

                           // Random r = new Random();

                           fSaida.writeUTF("Resposta do servodor");
                           fSaida.flush();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Servidor tcp = new Servidor();
    }
}