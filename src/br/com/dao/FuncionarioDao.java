package br.com.dao;


import br.com.dto.FuncionarioDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDao {

    public ArrayList<String> listaFuncionario(Connection conexao, String SQL){

        ArrayList<String> resposta = null;

        ResultSet resSet = null;
        FuncionarioDto funcionarioDto = new FuncionarioDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                funcionarioDto.setCpf(resSet.getString("cpf"));
                funcionarioDto.setNome(resSet.getNString("nome"));
                funcionarioDto.setSalario(resSet.getDouble("salario"));



                resposta.add(funcionarioDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
