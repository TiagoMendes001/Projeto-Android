package com.example.appmercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MenuNovoActivity extends AppCompatActivity {

    Button confirma;
    RadioButton livro,laptop,celular,roupa,calcado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuadd);

        confirma = findViewById(R.id.idIndo);
        livro = findViewById(R.id.radioBook);
        laptop = findViewById(R.id.radioLaps);
        celular = findViewById(R.id.radioCell);
        roupa = findViewById(R.id.radioRoupa);
        calcado = findViewById(R.id.radioCalcado);

        confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Livro = "Livro";
                String LapTop =  "notebook";
                String Celular =  "Celular";
                String Roupa =  "Roupa";
                String Calcado =  "Calcado";

                    if(livro.isChecked())
                    {

                        Intent going = new Intent(MenuNovoActivity.this,ListActivitySelecionar.class);

                        going.putExtra("Identificador",Livro );

                        startActivity(going);

                    } else if(laptop.isChecked())
                    {

                        Intent going = new Intent(MenuNovoActivity.this,ListActivitySelecionar.class);

                        going.putExtra("Identificador",LapTop );

                        startActivity(going);

                    }else if(celular.isChecked())
                    {

                        Intent going = new Intent(MenuNovoActivity.this,ListActivitySelecionar.class);

                        going.putExtra("Identificador",Celular );

                        startActivity(going);

                    }else if(roupa.isChecked())
                    {

                        Intent going = new Intent(MenuNovoActivity.this,ListActivitySelecionar.class);

                        going.putExtra("Identificador",Roupa );

                        startActivity(going);

                    }else if(calcado.isChecked())
                    {
                        Intent going = new Intent(MenuNovoActivity.this,ListActivitySelecionar.class);

                        going.putExtra("Identificador",Calcado );

                        startActivity(going);

                    }
                }


        });


    }
}