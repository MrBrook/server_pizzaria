package br.com.dao;

import br.com.dto.PossuiIngredienteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PossuiIngredienteDao {

    public ArrayList<String> listaPossuiIngrediente(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        PossuiIngredienteDto possuiIngredienteDto = new PossuiIngredienteDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                possuiIngredienteDto.setCodigoProduto(resSet.getString("codigoProduto"));
                possuiIngredienteDto.setCodigoItem(resSet.getString("codigoItem"));


                resposta.add(possuiIngredienteDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }
}
