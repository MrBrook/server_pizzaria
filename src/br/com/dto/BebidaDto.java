package br.com.dto;


import java.io.Serializable;


public class BebidaDto implements Serializable {

    private String codigo;
    private String nome;
    private String tipo;
    private int quantidade;



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return codigo+ ","+ nome+","+ tipo+ ","+quantidade;
    }
}
