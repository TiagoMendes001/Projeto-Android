package com.example.appmercado.Model.Produtos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appmercado.Database.CriaBanco;

import java.util.ArrayList;

public class RepositorioProd {

    SQLiteDatabase dados;
    CriaBanco ajuda;

    public RepositorioProd(Context context)
    {

        ajuda = new CriaBanco(context);

    }

    // métodos crud dos produtos //

    // método inserir //

    public String insert_prod(String prod_nome,String prod_preco, String url, String categoria)
    {

        long resultado;
        dados = ajuda.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nomeProd",prod_nome);
        cv.put("precoProd",prod_preco);
        cv.put("urlProd",url);
        cv.put("categorias",categoria);

        resultado = dados.insert("produto",null,cv);

        if (resultado == -1)
        {
            return "Falha ao Inserir";
        }else
        {
            return "Inserido com Sucesso";
        }

    }

    // método para listar os produtos de menor preço //

    public ArrayList<Produto> selectByPreco(String categoria)
    {
        ArrayList<Produto> lista_prod = new ArrayList<>();

        dados = ajuda.getWritableDatabase();

        String sql_preco = "SELECT * FROM produto WHERE categorias = ? ORDER BY precoProd ASC;";

        Cursor c = dados.rawQuery(sql_preco,new String[]{categoria});

        if(c.moveToFirst())
        {
            while(c.moveToNext())
            {
                @SuppressLint("Range") String codigo = c.getString(c.getColumnIndex("codigo"));
                @SuppressLint("Range") String nome_prods = c.getString(c.getColumnIndex("nomeProd"));
                @SuppressLint("Range") String preco_prod = c.getString(c.getColumnIndex("precoProd"));
                @SuppressLint("Range") String url_prods = c.getString(c.getColumnIndex("urlProd"));
                @SuppressLint("Range") String cats_prod = c.getString(c.getColumnIndex("categorias"));

                Produto produtos = new Produto(codigo,nome_prods,preco_prod,url_prods,cats_prod);

                lista_prod.add(produtos);
            }
        }
        dados.close();
        return lista_prod;
    }

    // método listar //

    public ArrayList<Produto> select_prod()
    {
        ArrayList<Produto> listas = new ArrayList<>();

        dados = ajuda.getWritableDatabase();

        String sql = "SELECT * FROM  produto ORDER BY nomeProd ASC;";

        Cursor cursor = dados.rawQuery(sql,null);

        if (cursor.moveToNext())
        {
            while (cursor.moveToNext())
            {
                @SuppressLint("Range") String nomeProduto = cursor.getString(cursor.getColumnIndex("nomeProd"));
                @SuppressLint("Range") String idProduto = cursor.getString(cursor.getColumnIndex("codigo"));
                @SuppressLint("Range") String precoProduto = cursor.getString(cursor.getColumnIndex("precoProd"));
                @SuppressLint("Range") String urlProduto = cursor.getString(cursor.getColumnIndex("urlProd"));
                @SuppressLint("Range") String categoriaProduto = cursor.getString(cursor.getColumnIndex("categorias"));

                Produto produto = new Produto(idProduto,nomeProduto,precoProduto,urlProduto,categoriaProduto );

                listas.add(produto);
            }
        }

        dados.close();
        return listas;
    }

    // metodo modificar //

    public String up_prod(String identificador,String prod_nome,String prod_preco,String url, String categoria)
    {

        long resultado;
        dados = ajuda.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nomeProd",prod_nome);
        cv.put("precoProd",prod_preco);

        cv.put("urlProd",url);
        cv.put("categorias",categoria);

        resultado = dados.update("produto",cv,"codigo = ?",new String[]{identificador});

        if (resultado == -1)
        {
            return "Falha ao Atualizar";
        }else
        {
            return "Atualizado com Sucesso";
        }

    }
    public void delete_prod(String ident)
    {
        dados = ajuda.getWritableDatabase();

        dados.delete("produto","codigo = ? ",new String[]{ident});

        dados.close();
    }



}
