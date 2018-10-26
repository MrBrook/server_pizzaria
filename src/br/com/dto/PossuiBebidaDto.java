package br.com.dto;

import java.io.Serializable;

public class PossuiBebidaDto implements Serializable {

    private String codigoProduto;
    private String codigoItem;

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }
}
