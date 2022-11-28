package com.example.appmercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appmercado.Adapter.Adaptador;
import com.example.appmercado.Database.CriaBanco;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListActivity extends AppCompatActivity {

    public RecyclerView indo;
    public FloatingActionButton acao;
    public CriaBanco hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        acao = findViewById(R.id.adicionar);
        indo = findViewById(R.id.reciclarView);

        // inicializando o sqlHelper //

        hd = new CriaBanco(ListActivity.this);

        getSelecionar();

        acao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(ListActivity.this);

                alerta.setTitle("Aviso:");

                alerta.setMessage("Selecione uma direção: ");

                alerta.setPositiveButton("Tela de Cadastro!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent go = new Intent(ListActivity.this,CreateActivity.class);
                        go.putExtra("EDIT",false);
                        startActivity(go);
                    }
                });

                alerta.setNegativeButton("Tela de Login!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ListActivity.this,MainActivity.class));
                    }
                });

                alerta.create().show();


            }
        });

    }

    public void getSelecionar()
    {
        Adaptador adapter = new Adaptador(ListActivity.this,hd.select());

        indo.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        getSelecionar();
    }
}