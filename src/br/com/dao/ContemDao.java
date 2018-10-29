package br.com.dao;

import br.com.dto.ContemDto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContemDao implements Serializable {

    public ArrayList<String> listaContem(Connection conexao,String SQL){

        ArrayList<String> resposta = null;

        ResultSet resSet = null;
        ContemDto contemDto = new ContemDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                contemDto.setNumeroPedido(resSet.getInt("numeroPedido"));
                contemDto.setCodigoProduto(resSet.getString("codigoProduto"));
                contemDto.setQuantidade(resSet.getInt("quantidade"));

                resposta.add(contemDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
