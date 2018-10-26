package br.com.banco;

import br.com.Configuracao;
import br.com.dao.BebidaDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://"+Configuracao.IP_SERVER+":"+Configuracao.PORT_SERVER_DB+"/trabalho" +
                            "?autoReconnect=true&useSSL=false",
                    Configuracao.USER,Configuracao.PASSWORD);

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}