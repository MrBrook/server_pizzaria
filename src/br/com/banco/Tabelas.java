package br.com.banco;

import br.com.dto.*;
import br.com.dao.*;


import java.util.HashMap;
import java.util.Map;

public class Tabelas {

    public static Map<String,Object> tabelasDto = new HashMap<String,Object>();
    public static Map<String,Object> tabelasDao = new HashMap<String,Object>();


    public Tabelas(){

        setTabelasDto();
        setTabelasDao();

    }

    public void setTabelasDto(){

        tabelasDto.put("bebida",new BebidaDto());
        tabelasDto.put("comtem",new ContemDto());
        tabelasDto.put("fornecebebida",new ForneceBebidaDto());
        tabelasDto.put("fornecedor",new FornecedorDto());
        tabelasDto.put("funcionario",new FuncionarioDto());
        tabelasDto.put("ingrediente",new IngredienteDto());
        tabelasDto.put("pedido",new PedidoDto());
        tabelasDto.put("possuibebida",new PossuiBebidaDto());
        tabelasDto.put("possuiingrediente",new PossuiIngredienteDto());
        tabelasDto.put("produto",new ProdutoDto());

    }
    public void setTabelasDao(){

        tabelasDao.put("bebida",new BebidaDao());
        tabelasDao.put("comtem",new ContemDao());
//        tabelasDao.put("fornecebebida",new ForneceBebidaDto());
//        tabelasDao.put("fornecedor",new FornecedorDto());
//        tabelasDao.put("funcionario",new FuncionarioDto());
//        tabelasDao.put("ingrediente",new IngredienteDto());
//        tabelasDao.put("pedido",new PedidoDto());
//        tabelasDao.put("possuibebida",new PossuiBebidaDto());
//        tabelasDao.put("possuiingrediente",new PossuiIngredienteDto());
//        tabelasDao.put("produto",new ProdutoDto());

    }

    public Object getTabela(int i,String nomeTabela){ // 0 é igual a tabelas DTO
        if(i == 0)
            return tabelasDto.get(nomeTabela);
        else return tabelasDao.get(nomeTabela);
    }


}
