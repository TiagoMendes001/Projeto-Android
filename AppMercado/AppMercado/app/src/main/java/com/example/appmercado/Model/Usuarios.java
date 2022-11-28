package com.example.appmercado.Model;

import java.io.Serializable;

public class Usuarios implements Serializable {

    public String codigos;
    public String nomes;
    public String cpfs;
    public String locais;
    public String senha;

    public Usuarios() {
    }

    public Usuarios(String codigos, String nomes, String cpfs, String locais, String senha) {
        this.codigos = codigos;
        this.nomes = nomes;
        this.cpfs = cpfs;
        this.locais = locais;
        this.senha = senha;
    }

    public Usuarios(String nomes, String cpfs, String locais, String senha) {

        this.nomes = nomes;
        this.cpfs = cpfs;
        this.locais = locais;
        this.senha = senha;
    }


    // getters e setters //


    public String getCodigos() {
        return codigos;
    }

    public void setCodigos(String codigos) {
        this.codigos = codigos;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getCpfs() {
        return cpfs;
    }

    public void setCpfs(String cpfs) {
        this.cpfs = cpfs;
    }


    public String getLocais() {
        return locais;
    }

    public void setLocais(String locais) {
        this.locais = locais;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}