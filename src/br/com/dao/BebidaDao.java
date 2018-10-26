package br.com.dao;

import br.com.dto.BebidaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BebidaDao {

    public ArrayList<BebidaDto> listaBebida(Connection conexao){

        ResultSet resSet = null;
        ArrayList<BebidaDto> bebidas = new ArrayList<>();
        BebidaDto bebida = new BebidaDto();

        String SQL = "SELECT * from bebida";

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                bebida.setCodigo(resSet.getString("codigo"));
                bebida.setNome(resSet.getString("nome"));
                bebida.setTipo(resSet.getString("tipo"));
                bebida.setQuantidade(resSet.getInt("quantidade"));

                bebidas.add(bebida);

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return bebidas;
    }

}
