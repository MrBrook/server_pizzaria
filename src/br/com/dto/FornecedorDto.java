package br.com.dto;

import java.io.Serializable;

public class FornecedorDto implements Serializable {

    private String cnpj;
    private String contato;
    private String nome;
    private String endereco;

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return cnpj+","+contato+","+nome+","+endereco;
    }
}
