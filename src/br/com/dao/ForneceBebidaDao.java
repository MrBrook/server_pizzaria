package br.com.dao;

import br.com.dto.ForneceBebidaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ForneceBebidaDao {

    public ArrayList<String> listaForneceBebida(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        ForneceBebidaDto forneceBebidaDto = new ForneceBebidaDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                forneceBebidaDto.setCnpj(resSet.getString("cnpj"));
                forneceBebidaDto.setCodigoItem(resSet.getString("codigoItem"));
                forneceBebidaDto.setDataPedido(resSet.getDate("dataPedido"));
                forneceBebidaDto.setPedido(resSet.getString("pedido"));


                resposta.add(forneceBebidaDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
