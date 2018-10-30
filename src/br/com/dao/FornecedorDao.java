package br.com.dao;

import br.com.dto.FornecedorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FornecedorDao {

    public ArrayList<String> listaFornecedor(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        FornecedorDto fornecedorDto = new FornecedorDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                fornecedorDto.setCnpj(resSet.getString("cnpj"));
                fornecedorDto.setContato(resSet.getString("contato"));
                fornecedorDto.setNome(resSet.getString("nome"));
                fornecedorDto.setEndereco(resSet.getString("endereco"));


                resposta.add(fornecedorDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }
}
