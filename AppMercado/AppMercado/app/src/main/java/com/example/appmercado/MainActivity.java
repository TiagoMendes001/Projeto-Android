package com.example.appmercado;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.appmercado.Database.CriaBanco;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText user,password;
    Button logar;
    TextView fazer_login;
    public CriaBanco cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user  = findViewById(R.id.editarUsuario);
        password = findViewById(R.id.code_senha);
        logar = findViewById(R.id.logar_botao);
        fazer_login = findViewById(R.id.fazerLogin);

        cb = new CriaBanco(MainActivity.this);

        // realizando a confirmação do login //

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user.getText().toString().trim();
                String senhas = password.getText().toString().trim();

                if (userName.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Insira o nome de usuário!", Toast.LENGTH_SHORT).show();
                }else if (senhas.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Insira sua senha!", Toast.LENGTH_SHORT).show();
                }else {

                    long identificar = cb.selectByName(userName,senhas);

                    if (identificar > 0)
                    {
                        Toast.makeText(MainActivity.this, "Login Realizado com Sucesso!", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(MainActivity.this,MenuNovoActivity.class));
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Login Falhou!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


        fazer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent going = new Intent(MainActivity.this,CreateActivity.class);

                startActivity(going);
            }
        });

    }
}