package br.com.dao;

import br.com.dto.IngredienteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IngredienteDao {

    public ArrayList<String> listaIngredientes(Connection conexao, String SQL){

        ArrayList<String> resposta = null;

        ResultSet resSet = null;
        IngredienteDto ingredienteDto = new IngredienteDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                ingredienteDto.setCodigo(resSet.getString("codigo"));
                ingredienteDto.setNome(resSet.getString("nome"));
                ingredienteDto.setQuantidade(resSet.getInt("quantidade"));

                resposta.add(ingredienteDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }
}



