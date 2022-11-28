package com.example.appmercado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.appmercado.Model.Produtos.Adapter_prod.Adapter_select;
import com.example.appmercado.Model.Produtos.RepositorioProd;

public class ListActivitySelecionar extends AppCompatActivity {

    RecyclerView listaSelecionar;
    RepositorioProd repositorioSelect;
    String categoriaNova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprodselect);

        repositorioSelect = new RepositorioProd(ListActivitySelecionar.this);

        listaSelecionar = findViewById(R.id.reciclagem);

        Intent direcao = getIntent();

        categoriaNova =  direcao.getStringExtra("Identificador");

        getSelecionar(categoriaNova);

    }

    public void getSelecionar(String campoCategoria)
    {
        Adapter_select adaptador = new Adapter_select(repositorioSelect.selectByPreco(campoCategoria),ListActivitySelecionar.this);

        listaSelecionar.setAdapter(adaptador);
    }

}