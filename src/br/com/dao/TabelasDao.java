package br.com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelasDao {

    public boolean executaOperacao(Connection conexao, String SQL) throws SQLException {

        try {

            Statement st = conexao.createStatement();
            st.executeUpdate(SQL);

            conexao.close();

        }catch (Exception e){
            System.out.println(e);
            return false;
        }finally {
            conexao.close();
        }

        return true;
    }



}
