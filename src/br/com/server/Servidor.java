package br.com.server;

import br.com.banco.Tabelas;
import br.com.dao.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static br.com.banco.Conexao.getConnection;

public class Servidor implements Configuracao{

    private ServerSocket socketServidor;
    static public Tabelas tabelas;

    private boolean flag = true;


    public Servidor() {
        tabelas = new Tabelas();
        inicializaConexao();
    }

    public void inicializaConexao() {
        try {
            socketServidor = new ServerSocket(PORT_SERVER);
            while(true) {
                Socket socket = socketServidor.accept();
                System.out.println("aceito: "+socketServidor.getInetAddress());
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            ObjectInputStream fEntrada = new ObjectInputStream(socket.getInputStream());
                            ObjectOutputStream fSaida = new ObjectOutputStream(socket.getOutputStream());

                            if(flag){ //senhas
                                System.out.println(fEntrada.readObject());
                                System.out.println(fEntrada.readObject());
                                flag = false;
                            }

                            while (fEntrada.available()==0){

                                ArrayList<String> resposta = null;

                                Connection con = null;
                                try {

                                    con = getConnection();

                                    resposta = processaComando(con,(String) fEntrada.readObject());

                                    fSaida.writeObject(resposta);
                                    fSaida.flush();

                                    con.close();

                                } catch (Exception e) {
                                    System.out.println(e);
                                } finally {
                                    con.close();
                                }
                            }

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


    public  ArrayList<String> processaComando(Connection conexao,String comando) throws SQLException {

        Object tabela = null;
        String[] comandos = comando.split(" ");

        if (comando.contains("select")) {

            tabela = tabelas.getTabela(1, comandos[3]);

            switch (comandos[3]) {
                case "bebida":
                    return ((BebidaDao)tabela).listaBebida(conexao,comando);
                case "contem":
                    return ((ContemDao)tabela).listaContem(conexao,comando);
                case "fornecebebida":
                    return ((ForneceBebidaDao)tabela).listaForneceBebida(conexao,comando);
                case "fornecedor":
                    return ((FornecedorDao)tabela).listaFornecedor(conexao,comando);
                case "forneceingrediente":
                    return ((ForneceIngredienteDao)tabela).listaForneceIngrediente(conexao,comando);
                case "funcionario":
                    return ((FuncionarioDao)tabela).listaFuncionario(conexao,comando);
                case "ingrediente":
                    return ((IngredienteDao)tabela).listaIngredientes(conexao,comando);
                case "pedido":
                    return ((PedidoDao)tabela).listaPedidos(conexao,comando);
                case "possuibebida":
                    return ((PossuiBebidaDao)tabela).listaPossuiBebida(conexao,comando);
                case "possuiingrediente":
                    return ((PossuiIngredienteDao)tabela).listaPossuiIngrediente(conexao,comando);
                case "produto":
                    return ((ProdutoDao)tabela).listaProduto(conexao,comando);
            }

        }else{
            TabelasDao tabelas = new TabelasDao();

            if (tabelas.executaOperacao(conexao,comando)) return null ;

//            if (comando.contains("delete")) {
//
//
//            } else if (comando.contains("update")) {
//
//            } else if (comando.contains("insert")) {
//
//            }
        }

        return null;
    }

    public static void main(String args[]) {

       new Servidor();

    }
}