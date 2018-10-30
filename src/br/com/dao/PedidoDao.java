package br.com.dao;

import br.com.dto.FuncionarioDto;
import br.com.dto.PedidoDto;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidoDao {

    public ArrayList<String> listaPedidos(Connection conexao, String SQL){

        ArrayList<String> resposta = new ArrayList<>();

        ResultSet resSet = null;
        PedidoDto pedidoDto = new PedidoDto();

        try{

            PreparedStatement statement = conexao.prepareStatement(SQL);
            statement.executeQuery(SQL);
            resSet = statement.executeQuery();

            while (resSet.next()){

                pedidoDto.setNumero(resSet.getInt("numero"));
                pedidoDto.setValor(resSet.getDouble("valor"));
                pedidoDto.setDataPedido( resSet.getDate("dataPedido"));
                pedidoDto.setNomeCliente(resSet.getString("nomeCliente"));
                pedidoDto.setEstadoDoPedido(resSet.getInt("estadoDoPedido"));
                pedidoDto.setCPFFuncionario(resSet.getString("CPFFuncionario"));



                resposta.add(pedidoDto.toString());

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return resposta;
    }


}
