package com.example.appmercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoMainActivity extends AppCompatActivity {

    public TextView preco_info,nome_info, categoria_info,url_info;
    public String info_preco,info_nome,info_cats,info_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.infos_layout);

        preco_info = findViewById(R.id.id_preco);
        nome_info = findViewById(R.id.id_produto);
        categoria_info = findViewById(R.id.id_categoria);
        url_info = findViewById(R.id.id_url);

        // recebimento dos valores do Intent //

        Intent receberValores = getIntent();

        receberValores.getStringExtra("idSelect");
        info_nome = receberValores.getStringExtra("nomeSelect");
        info_preco = receberValores.getStringExtra("precoSelect");
        info_url = receberValores.getStringExtra("extensaoSelect");
        info_cats = receberValores.getStringExtra("opcaoSelect");
        receberValores.getBooleanExtra("ALTER",false);

        preco_info.setText(info_preco);
        nome_info.setText(info_nome);
        categoria_info.setText(info_cats);
        url_info.setText(info_url);

        url_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                envioUri(info_url);
            }
        });

    }
    private void envioUri(String info_url) {

        Uri uri = Uri.parse(info_url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}