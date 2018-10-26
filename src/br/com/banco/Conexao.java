package br.com.banco;

import br.com.dao.BebidaDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trabalho" +
                            "?autoReconnect=true&useSSL=false",
                    "root","root");

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args){

        try{
            Connection con = getConnection();
            BebidaDao tes = new BebidaDao();

          for(int i=0;i<tes.listaBebida(con).size();i++)
              System.out.println(tes.listaBebida(con).get(i).toString());



            con.close();
        }catch (Exception e){
            System.out.println(e);
        }finally {

        }

    }
}