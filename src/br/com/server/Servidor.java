package br.com.server;

import br.com.Configuracao;
import br.com.banco.Tabelas;
import br.com.dao.BebidaDao;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

import static br.com.banco.Conexao.getConnection;

public class Servidor {

    private ServerSocket socketServidor;
    static public Tabelas tabelas;

    public Servidor() {
        tabelas = new Tabelas();
        inicializaConexao();
    }

    public void inicializaConexao() {
        try {
            socketServidor = new ServerSocket(Configuracao.PORT_SERVER);
            while(true) {
                Socket socket = socketServidor.accept();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            ObjectInputStream fEntrada = new ObjectInputStream(socket.getInputStream());
                            //  ObjectOutputStream fSaida = new ObjectOutputStream(socket.getOutputStream());


                            System.out.println(fEntrada.readLine());
                            // System.out.println(fEntrada.readObject());

                            Connection con = null;
                            try {

                                con = getConnection();
                                BebidaDao tes = (BebidaDao) tabelas.getTabela(1, "bebida");


                                for (int i = 0; i < tes.listaBebida(con).size(); i++)
                                    System.out.println(tes.listaBebida(con).get(i));


                                con.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            } finally {
                                con.close();
                            }


                            //  fSaida.writeUTF("Resposta do servodor");
                            //  fSaida.flush();


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