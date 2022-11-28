package com.example.appmercado.Model.Produtos.Adapter_prod;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmercado.InfoMainActivity;
import com.example.appmercado.Model.Produtos.Produto;
import com.example.appmercado.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter_select extends RecyclerView.Adapter<Adapter_select .MeuHold> {

    ArrayList<Produto> listagem_nova = new ArrayList<>();
    Context  context_new;

    public Adapter_select(ArrayList<Produto> listas, Context lista_layout) {
        this.listagem_nova = listas;
        this.context_new = lista_layout;
    }

    @NonNull
    @Override
    public Adapter_select.MeuHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context_new).inflate(R.layout.editprod,parent,false);
        return new MeuHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuHold holder, int position) {

        Produto produtoSelectById = listagem_nova.get(position);

        String codigo_select = produtoSelectById.getCodigo();
        String produto_select = produtoSelectById.getNome_produto();
        String preco_select = produtoSelectById.getPreco();
        String extensao_select = produtoSelectById.getUrl();
        String categoria_select = produtoSelectById.getCategoria();

        holder.produto_selecionar.setText(produto_select);
        holder.preco_selecionar.setText(preco_select);
        holder.url_select.setText(extensao_select);
        holder.categoria_select.setText(categoria_select);

        // parte destinada ao Intent //

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent direcionar = new Intent(context_new, InfoMainActivity.class);

                direcionar.putExtra("idSelect",codigo_select);
                direcionar.putExtra("nomeSelect",produto_select);
                direcionar.putExtra("precoSelect",preco_select);
                direcionar.putExtra("extensaoSelect",extensao_select);
                direcionar.putExtra("opcaoSelect",categoria_select);
                direcionar.putExtra("ALTER",true);

                context_new.startActivity(direcionar);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listagem_nova.size();
    }

    public class MeuHold extends RecyclerView.ViewHolder{

        TextView produto_selecionar;
        TextView preco_selecionar;

        TextView url_select;
        TextView categoria_select;

        public MeuHold(@NonNull View itemView) {
            super(itemView);

            produto_selecionar = itemView.findViewById(R.id.nomeEdit);
            preco_selecionar = itemView.findViewById(R.id.precoEdit);

            url_select = itemView.findViewById(R.id.urlEdit);
            categoria_select = itemView.findViewById(R.id.categoriaEdit);

        }
    }

}
