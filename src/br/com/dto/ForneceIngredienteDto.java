package br.com.dto;

import java.io.Serializable;
import java.util.Date;

public class ForneceIngredienteDto implements Serializable {

    private String cnpj;
    private String codigoItem;
    private Date dataPedido;
    private String pedido;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return cnpj+","+codigoItem+","+dataPedido+","+pedido;
    }
}
