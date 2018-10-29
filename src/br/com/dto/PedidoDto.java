package br.com.dto;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class PedidoDto implements Serializable {
    private int numero;
    private double valor;
    private Date dataPedido;
    private String nomeCliente;
    private int estadoDoPedido;
    private String CPFFuncionario;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getEstadoDoPedido() {
        return estadoDoPedido;
    }

    public void setEstadoDoPedido(int estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }

    public String getCPFFuncionario() {
        return CPFFuncionario;
    }

    public void setCPFFuncionario(String CPFFuncionario) {
        this.CPFFuncionario = CPFFuncionario;
    }

    @Override
    public String toString() {
        return numero+","+valor+","+dataPedido+","+nomeCliente+","+estadoDoPedido+","+CPFFuncionario;
    }
}
