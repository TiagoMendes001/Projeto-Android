package com.example.appmercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appmercado.Model.Produtos.Adapter_prod.AdapterProd;
import com.example.appmercado.Model.Produtos.RepositorioProd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListActivityProduct extends AppCompatActivity {

    public RecyclerView reciclar;
    public FloatingActionButton flutuar;
    public RepositorioProd reposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        // atribuindo os ids //

        reciclar = findViewById(R.id.product_reciclar);
        flutuar = findViewById(R.id.addFloatButton);

        // inicializar o repositorio //

        reposit = new RepositorioProd(ListActivityProduct.this);

        // inserindo o método do adapter //

        getSelecionando();

        // direcionado para a tela de cadastro dos produtos //

        flutuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(ListActivityProduct.this);

                alerta.setTitle("Aviso:");

                alerta.setMessage("Selecione uma direção: ");

                alerta.setPositiveButton("Tela de Cadastro de Produtos!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent going = new Intent(ListActivityProduct.this,ProductActivity.class);
                        going.putExtra("EDITED",false);
                        startActivity(going);
                    }
                });

                alerta.setNegativeButton("Tela de Login!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ListActivityProduct.this,MainActivity.class));
                    }
                });

                alerta.create().show();

            }
        });


    }

    // método do adapter //

    public void getSelecionando()
    {
        AdapterProd adapterProd = new AdapterProd(ListActivityProduct.this,reposit.select_prod());

        reciclar.setAdapter(adapterProd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSelecionando();
    }
}