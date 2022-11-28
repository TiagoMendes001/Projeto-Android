package com.example.appmercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmercado.Model.Produtos.RepositorioProd;
import com.google.android.material.snackbar.Snackbar;

public class UpActivityProduct extends AppCompatActivity {

    // Instâncias dos Objetos do UI//

    public EditText nome_prod,preco_prod,url_prod, opcao_prod;
    public Button delete_prod,update_prod;
    public String nomes,precos,urls,ids,categorias;
    public RepositorioProd repositorio;
    public boolean edit = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.update_product);

        // iniciando o objeto repositorio //

        repositorio = new RepositorioProd(UpActivityProduct.this);

        // atribuindo os ids //

        nome_prod = findViewById(R.id.nome_update);
        preco_prod = findViewById(R.id.preco_update);
        opcao_prod = findViewById(R.id.categoriaMudar);
        url_prod = findViewById(R.id.url_update);
        delete_prod = findViewById(R.id.deletar_update);
        update_prod = findViewById(R.id.mudar_update);

        // objeto do tipo intent //

        Intent going = getIntent();

        edit = going.getBooleanExtra("EDITED",edit);
        ids = going.getStringExtra("codes");
        nomes = going.getStringExtra("names");
        precos = going.getStringExtra("preco");
        urls = going.getStringExtra("url");

        categorias = going.getStringExtra("category");

        if (edit)
        {
            edit = going.getBooleanExtra("EDITED",edit);
            ids = going.getStringExtra("codes");
            nomes = going.getStringExtra("names");
            precos = going.getStringExtra("preco");
            urls = going.getStringExtra("url");

            categorias = going.getStringExtra("category");

            // inserindo os valores nos campos do UI//

            nome_prod.setText(nomes);
            preco_prod.setText(precos);
            url_prod.setText(urls);
            opcao_prod.setText(categorias);

        }

        // Botões de Excluir e Alterar //

        delete_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(UpActivityProduct.this);

                alert.setTitle("Aviso!");
                alert.setIcon(R.drawable.ic_delete);
                alert.setMessage("Gostaria de Deletar o Registro?");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        repositorio.delete_prod(ids);
                        Toast.makeText(getApplicationContext(), "Deletado com Sucesso!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpActivityProduct.this,ListActivityProduct.class));

                    }
                });
                alert.setNegativeButton("Cancelar!",null);
                alert.create().show();
            }
        });

        // Novo Botão //

        update_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDadoUp(v);

                Intent intent = new Intent(UpActivityProduct.this,ListActivityProduct.class);

                startActivity(intent);

            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    }


    public void getDadoUp(View view)
    {
        nomes = nome_prod.getText().toString().trim();
        precos = preco_prod.getText().toString().trim();
        urls = url_prod.getText().toString().trim();
        categorias = opcao_prod.getText().toString().trim();

        String resulted = repositorio.up_prod(ids,nomes,precos,urls,categorias);

        Snackbar.make(view,resulted,Snackbar.LENGTH_LONG).show();
    }


}