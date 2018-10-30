package br.com.dao;

import br.com.dto.ForneceIngredienteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ForneceIngredienteDao {

    public ArrayList<String> listaForneceIngrediente(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        ForneceIngredienteDto forneceIngredienteDto = new ForneceIngredienteDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                forneceIngredienteDto.setCnpj(resSet.getString("cnpj"));
                forneceIngredienteDto.setCodigoItem(resSet.getString("codigoItem"));
                forneceIngredienteDto.setDataPedido(resSet.getDate("dataPedido"));
                forneceIngredienteDto.setPedido(resSet.getString("pedido"));

                resposta.add(forneceIngredienteDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
