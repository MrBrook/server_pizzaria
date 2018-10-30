package br.com.server;

import br.com.banco.Tabelas;
import br.com.dao.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static br.com.banco.Conexao.getConnection;

public class Servidor implements Runnable {

    private Socket cliente;
    static private Tabelas tabelas;

    private boolean flag = true;

    private Servidor(Socket cliente) {

        this.cliente = cliente;
        tabelas = new Tabelas();

    }

    private ArrayList<String> processaComandoSelect(Connection conexao, String comando) throws SQLException {

        String nomeTabela = (comando.split(" "))[3];

        Object tabela = tabelas.getTabela(1,nomeTabela );

        switch (nomeTabela) {
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

        return null;
    }

    private String processaComando(Connection conexao,String comando) throws SQLException {

        TabelasDao tabelas = new TabelasDao();

        if (tabelas.executaOperacao(conexao,comando)) return "OK";
        else return "ERRO";


    }

    @Override
    public void run() {

        try {

            ObjectOutputStream fSaida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream fEntrada = new ObjectInputStream(cliente.getInputStream());

            if (flag) { //senhas
                String user = (String) fEntrada.readObject();
                String password = (String) fEntrada.readObject();

                flag = false;

                if (user.equals(Configuracao.USER) && password.equals(Configuracao.PASSWORD)) {
                    fSaida.writeUTF("bom dia denis");
                    fSaida.flush();
                } else {
                    fSaida.writeUTF("conexão recusada");
                    fSaida.flush();
                    cliente.close();
                }
            }
            while (true){

                try {

                    ArrayList<String> resposta = new ArrayList<>();
                    String res;

                    String comando = (String) fEntrada.readObject();

                    Connection conexao  = getConnection();

                    if(comando.equals(null)) {
                        conexao .close();
                        break;
                    }
                    else {


                        if((comando.split(" "))[0].equals("select")){
                            resposta = processaComandoSelect(conexao , comando);
                            if(resposta.equals(null)){
                                System.out.println("ERRO");
                            }else {
                                fSaida.writeObject(resposta);
                                System.out.println(comando+" -> OK");

                                resposta.clear();
                            }

                        } else{

                            res = processaComando(conexao ,comando);
                            fSaida.writeUTF(res);
                            System.out.println("RESPOSTA -> "+res);

                        }
                        fSaida.flush();
                        conexao.close();
                    }

                } catch (Exception e) {
                    getConnection().close();
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) throws IOException {

        ServerSocket servidor = new ServerSocket(Configuracao.PORT_SERVER);

        while (true){

            Socket cliente = servidor.accept();
            System.out.println("Conectado");
            new Thread(new Servidor(cliente)).start();

        }
    }
}