package com.example.appmercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmercado.Model.Produtos.RepositorioProd;

public class ProductActivity extends AppCompatActivity {

    public EditText nome_prod,url_prod,preco_prod,categoria_prod;
    public Button cad_produto;
    public String nomes,preco,extensao,cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_produto);

        nome_prod = findViewById(R.id.prod_nome);
        url_prod = findViewById(R.id.prod_url);
        preco_prod = findViewById(R.id.prod_preco);

        cad_produto = findViewById(R.id.cadastrar_prod);
        categoria_prod = findViewById(R.id.prod_categoria);

        cad_produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProductActivity.this,ListActivityProduct.class));

                    nomes = nome_prod.getText().toString().trim();
                    preco = preco_prod.getText().toString().trim();
                    extensao = url_prod.getText().toString().trim();
                    cats = categoria_prod.getText().toString().trim();

                RepositorioProd reposit = new RepositorioProd(ProductActivity.this);

                String resultado_novo;

                resultado_novo  = reposit.insert_prod(nomes,preco,extensao,cats);

                Toast.makeText(ProductActivity.this, resultado_novo ,Toast.LENGTH_SHORT).show();


            }
        });

    }





}