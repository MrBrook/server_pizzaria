package br.com.dao;

import br.com.dto.ProdutoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDao {

    public ArrayList<String> listaProduto(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        ProdutoDto produtoDto = new ProdutoDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                produtoDto.setCodigoProduto(resSet.getString("codigoProduto"));
                produtoDto.setPrecoVenda(resSet.getDouble("precoVenda"));
                produtoDto.setPreco(resSet.getDouble("preco"));
                produtoDto.setNomeProduto(resSet.getString("nomeProduto"));
                produtoDto.setQuantidade(resSet.getInt("quantidade"));


                resposta.add(produtoDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }

}
