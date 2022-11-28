package com.example.appmercado.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.appmercado.Model.Produtos.RepositorioProd;
import com.example.appmercado.Model.Usuarios;

import java.util.ArrayList;

public class CriaBanco extends SQLiteOpenHelper {

    private static final  String TABELA = "cliente";
    private static final  String ID = "id";
    private static final  String NAME = "nome_cliente";
    private static final  String CPF = "cpf_cliente";
    private static final  String ADDRESS = "local_cliente";
    private static final  String PASS = "senha_cliente";

    public Context context;

    public Usuarios user = new Usuarios();

    public CriaBanco(@Nullable Context context) {

        super(context,  "Compare.db", null, 1);
    }

    @Override
    public void onCreate( SQLiteDatabase Lite) {

        String comando = "CREATE TABLE "+TABELA+"("+ID+" INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "+NAME+" TEXT NOT NULL UNIQUE, "+CPF+" TEXT NOT NULL, "+ADDRESS+" TEXT NOT NULL, "+PASS+" TEXT NOT NULL UNIQUE)";

        Lite.execSQL("CREATE TABLE  produto ( codigo  INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, nomeProd TEXT(100) NOT NULL, precoProd TEXT(100) NOT NULL , urlProd TEXT(300) NOT NULL, categorias TEXT(100) NOT NULL )");

        Lite.execSQL(comando);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // métodos do crud //

    // método inserir //

    public void insert(String nome, String cpf, String endereco, String senha)
    {

        SQLiteDatabase dado = CriaBanco.this.getWritableDatabase();
        Usuarios user = new Usuarios();
        ContentValues cv = new ContentValues();

        cv.put(NAME,nome);
        cv.put(CPF,cpf);
        cv.put(ADDRESS,endereco);
        cv.put(PASS,senha);

        long number = dado.insert(TABELA,null,cv);

    }

    // método selecionar //

    public ArrayList<Usuarios> select()
    {

        ArrayList<Usuarios> listagem = new ArrayList<>();

        SQLiteDatabase db = CriaBanco.this.getWritableDatabase();

        String sql = "SELECT * FROM "+TABELA+" ORDER BY nome_cliente ASC;";

        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToNext())
        {
            while (cursor.moveToNext())
            {
                @SuppressLint("Range") String codigo = cursor.getString(cursor.getColumnIndex(ID));
                @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex(NAME));
                @SuppressLint("Range") String cpf = cursor.getString(cursor.getColumnIndex(CPF));
                @SuppressLint("Range") String local = cursor.getString(cursor.getColumnIndex(ADDRESS));
                @SuppressLint("Range") String senha = cursor.getString(cursor.getColumnIndex(PASS));

                Usuarios user = new Usuarios(codigo,nome,cpf,local,senha);

                listagem.add(user);

            }
        }


        db.close();
        return listagem;
    }


    // método modificar //

    public void update(String codigo, String nome, String cpf, String endereco, String senha)
    {

        SQLiteDatabase dado = CriaBanco.this.getWritableDatabase();
        Usuarios user = new Usuarios();
        ContentValues cv = new ContentValues();

        cv.put(NAME,nome);
        cv.put(CPF,cpf);
        cv.put(ADDRESS,endereco);
        cv.put(PASS,senha);

        dado.update(TABELA,cv,ID+" = ? ",new String[]{codigo});
        dado.close();

    }

    // método deletar //

    public void delete(String id)
    {

        SQLiteDatabase dado = getWritableDatabase();

        dado.delete(TABELA,ID+" = ? ",new String[]{id});

        dado.close();

    }

    // método para validar o login //

    @SuppressLint("Range")
    public long selectByName(String nome, String senha)
    {
        SQLiteDatabase dd = getReadableDatabase();

        String sql = "SELECT * FROM cliente WHERE nome_cliente = ? AND senha_cliente = ?;";

        Cursor c = dd.rawQuery(sql,new String[]{nome,senha});

        c.moveToFirst();

        if (c.getCount() == 1)
        {
            return c.getInt(c.getColumnIndex("id"));
        }else
        {
            return 0;
        }

    }



}
