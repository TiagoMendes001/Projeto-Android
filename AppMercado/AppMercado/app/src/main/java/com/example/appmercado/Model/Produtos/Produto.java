package com.example.appmercado.Model.Produtos;

import java.io.Serializable;

public class Produto implements Serializable {

    public String codigo;
    public String nome_produto;
    public String preco;

    public String url;
    public String categoria;

    // construtores //


    public Produto(String codigo, String nome_produto, String  preco, String url, String categoria) {
        this.codigo = codigo;
        this.nome_produto = nome_produto;
        this.preco = preco;

        this.url = url;
        this.categoria = categoria;
    }

    public Produto() {
    }

    // getters and setters //


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
