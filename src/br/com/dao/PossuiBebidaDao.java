package br.com.dao;



import br.com.dto.PossuiBebidaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PossuiBebidaDao {
    public ArrayList<String> listaPossuiBebida(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        PossuiBebidaDto possuiBebidaDto = new PossuiBebidaDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                possuiBebidaDto.setCodigoProduto(resSet.getString("codigoProduto"));
                possuiBebidaDto.setCodigoItem(resSet.getString("codigoItem"));

                resposta.add(possuiBebidaDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
