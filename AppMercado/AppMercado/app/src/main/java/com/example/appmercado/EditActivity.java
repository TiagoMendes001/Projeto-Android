package com.example.appmercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmercado.Database.CriaBanco;
import com.google.android.material.snackbar.Snackbar;

public class EditActivity extends AppCompatActivity {

    // declaracao dos atributos //

    public EditText nome_mod, cpf_mod, local_mod, senha_mod;
    public Button delete_mod, modificar_mod;
    private boolean editar = false;
    public CriaBanco database;
    private String code, nome_um, cpf_um,local_um,senha_um;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // atribuindo os ids //

        nome_mod = findViewById(R.id.modNome);
        cpf_mod = findViewById(R.id.modCpf);
        local_mod = findViewById(R.id.modLocal);
        senha_mod = findViewById(R.id.modPass);
        // botões de deletar e modificar //

        delete_mod = findViewById(R.id.deletar);
        modificar_mod = findViewById(R.id.mudar);

        // iniciando o intent //

        Intent indo = getIntent();

        editar = indo.getBooleanExtra("EDIT",editar);
        code = indo.getStringExtra("CODE");
        nome_um = indo.getStringExtra("NAME");
        cpf_um = indo.getStringExtra("CPF");
        local_um = indo.getStringExtra("ADD");
        senha_um = indo.getStringExtra("PASS");

        // inicializando o database helper //

        database = new CriaBanco(EditActivity.this);

        // condicional para os valores //

        if (editar)
        {
            code = indo.getStringExtra("CODE");
            nome_um = indo.getStringExtra("NAME");
            cpf_um = indo.getStringExtra("CPF");
            local_um = indo.getStringExtra("ADD");
            senha_um = indo.getStringExtra("PASS");

            nome_mod.setText(nome_um);
            cpf_mod.setText(cpf_um);
            local_mod.setText(local_um);
            senha_mod.setText(senha_um);

        }

        // atualizando o registro //

        modificar_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDado();

                Intent go = new Intent(EditActivity.this,ListActivity.class);

                startActivity(go);

                Snackbar.make(v,"Modificado com sucesso!",Snackbar.LENGTH_LONG).show();

            }
        });

        delete_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(EditActivity.this);
                alerta.setIcon(R.drawable.ic_delete);
                alerta.setTitle("Aviso");
                alerta.setMessage("Deseja Deletar o Registro?");
                alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        database.delete(code);
                        Snackbar.make(v,"Deletado com sucesso!",Snackbar.LENGTH_LONG).show();

                        startActivity(new Intent(EditActivity.this,ListActivity.class));

                    }
                });
                alerta.setNegativeButton("Cancelar",null);
                alerta.create().show();

            }


        });

        }


        public void getDado()
        {

            nome_um = nome_mod.getText().toString().trim();
            cpf_um = cpf_mod.getText().toString().trim();
            local_um = local_mod.getText().toString().trim();
            senha_um = senha_mod.getText().toString().trim();

            if (editar)
            {
                database.update(code,nome_um,cpf_um,local_um,senha_um);

            }


        }

}