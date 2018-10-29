package br.com.banco;

import br.com.server.Configuracao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao implements Configuracao {

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://"+IP_SERVER+":"+PORT_SERVER_DB+"/trabalho" +
                            "?autoReconnect=true&useSSL=false",
                    USER,PASSWORD);

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}