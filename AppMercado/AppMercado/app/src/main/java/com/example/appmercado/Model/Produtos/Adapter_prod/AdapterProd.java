package com.example.appmercado.Model.Produtos.Adapter_prod;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmercado.Model.Produtos.Produto;
import com.example.appmercado.R;
import com.example.appmercado.UpActivityProduct;

import java.util.ArrayList;

public class AdapterProd extends RecyclerView.Adapter<AdapterProd.MyHolder> {

    public ArrayList<Produto> listagem_new = new ArrayList<>();
    public Context context;

    public AdapterProd(Context novo_contexto, ArrayList<Produto> lista )
    {
        this.listagem_new=lista;
        this.context=novo_contexto;
    }

    @NonNull
    @Override
    public AdapterProd.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.editprod,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProd.MyHolder holder, int position) {

        Produto produto = listagem_new.get(position);

        String id = produto.getCodigo();
        String nome_product = produto.getNome_produto();
        String preco_product = produto.getPreco();

        String url_product = produto.getUrl();
        String category_prod = produto.getCategoria();

        holder.editar_nome.setText(nome_product);

        holder.editar_preco.setText(preco_product);
        holder.editar_url.setText(url_product);
        holder.editar_categoria.setText(category_prod);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, UpActivityProduct.class);
                intent.putExtra("codes",id);
                intent.putExtra("names",nome_product);
                intent.putExtra("preco",preco_product);
                intent.putExtra("url",url_product);
                intent.putExtra("category",category_prod);
                intent.putExtra("EDITED",true);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listagem_new.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {

        TextView editar_nome;
        TextView editar_preco;
        TextView editar_url;
        TextView editar_categoria;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            editar_nome = itemView.findViewById(R.id.nomeEdit);
            editar_preco = itemView.findViewById(R.id.precoEdit);
            editar_url = itemView.findViewById(R.id.urlEdit);
            editar_categoria = itemView.findViewById(R.id.categoriaEdit);
        }
    }

}
