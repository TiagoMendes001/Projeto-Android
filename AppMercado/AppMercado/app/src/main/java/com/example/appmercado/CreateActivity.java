package com.example.appmercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.appmercado.Database.CriaBanco;
import com.google.android.material.snackbar.Snackbar;

public class CreateActivity extends AppCompatActivity {

    EditText nome_add, cpf_add, local_add, senha_add;
    Button add_button;
    RadioButton cliente_add, adm_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // atribuindo os codigos //
        nome_add = findViewById(R.id.editNome);
        cpf_add = findViewById(R.id.editCpf);
        local_add = findViewById(R.id.editLocal);
        senha_add = findViewById(R.id.editPass);
        add_button = findViewById(R.id.botaoSalvar);
        cliente_add = findViewById(R.id.rbCliente);
        adm_add = findViewById(R.id.rbAdm);

        // direcionando para a lista //

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = nome_add.getText().toString().trim();
                String cpf = cpf_add.getText().toString().trim();
                String local = local_add.getText().toString().trim();
                String senha = senha_add.getText().toString().trim();

                if (nome.isEmpty())
                {
                    Snackbar.make(v,"Insira seu nome!",Snackbar.LENGTH_LONG).show();
                }else if (cpf.isEmpty())
                {
                    Snackbar.make(v,"Insira seu cpf!",Snackbar.LENGTH_LONG).show();
                }else if (local.isEmpty())
                {
                    Snackbar.make(v,"Insira seu endereço!",Snackbar.LENGTH_LONG).show();
                }else if (senha.isEmpty())
                {
                    Snackbar.make(v,"Insira sua senha!",Snackbar.LENGTH_LONG).show();
                }else
                {
                    if (adm_add.isChecked())
                    {

                        AlertDialog.Builder alerta = new AlertDialog.Builder(CreateActivity.this);

                        alerta.setTitle("Aviso!");

                        alerta.setMessage("Informe o Caminho Desejado: ");

                        alerta.setPositiveButton("Tela de Listagem de Usuário : ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                CriaBanco hd = new CriaBanco(CreateActivity.this);

                                hd.insert(nome,cpf,local,senha);

                                startActivity(new Intent(CreateActivity.this,ListActivity.class));
                            }
                        });

                        alerta.setNegativeButton("Tela de Cadastro de Produtos: ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                CriaBanco hd = new CriaBanco(CreateActivity.this);

                                hd.insert(nome,cpf,local,senha);

                                startActivity(new Intent(CreateActivity.this,ProductActivity.class));
                            }
                        });

                        alerta.create().show();


                    }else if (cliente_add.isChecked())
                    {

                        CriaBanco hd = new CriaBanco(CreateActivity.this);

                        hd.insert(nome,cpf,local,senha);

                        Intent indo = new Intent(CreateActivity.this,MenuNovoActivity.class);

                        startActivity(indo);
                    }
                }

            }
        });



    }
}