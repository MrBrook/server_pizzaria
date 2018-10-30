package br.com.dao;

import br.com.dto.BebidaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BebidaDao extends TabelasDao{

    public ArrayList<String> listaBebida(Connection conexao,String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        BebidaDto bebida = new BebidaDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                bebida.setCodigo(resSet.getString("codigo"));
                bebida.setNome(resSet.getString("nome"));
                bebida.setTipo(resSet.getString("tipo"));
                bebida.setQuantidade(resSet.getInt("quantidade"));

                resposta.add(bebida.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
