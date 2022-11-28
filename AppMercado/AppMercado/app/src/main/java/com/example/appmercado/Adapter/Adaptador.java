package com.example.appmercado.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmercado.EditActivity;
import com.example.appmercado.Model.Usuarios;
import com.example.appmercado.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Holder> {


    public Context context;
    public ArrayList<Usuarios> user = new ArrayList<>();

    public Adaptador(Context atividade, ArrayList<Usuarios> pessoa)
    {
        this.context = atividade;
        this.user = pessoa;
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.editar,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {

        Usuarios usuario = user.get(position);
        String codes = usuario.getCodigos();
        String name = usuario.getNomes();
        String fisicaPessoa = usuario.getCpfs();
        String locais = usuario.getLocais();
        String passwords = usuario.getSenha();

        holder.nomes.setText(name);
        holder.cpfs.setText(fisicaPessoa);
        holder.enderecos.setText(locais);
        holder.senhas.setText(passwords);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,EditActivity.class);

                intent.putExtra("CODE",codes);
                intent.putExtra("NAME",name);
                intent.putExtra("CPF",fisicaPessoa);
                intent.putExtra("ADD",locais);
                intent.putExtra("PASS",passwords);
                intent.putExtra("EDIT",true);

                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return user.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {

        TextView nomes;
        TextView cpfs;
        TextView enderecos;
        TextView senhas;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);

            nomes = itemView.findViewById(R.id.nomeUsuario);
            cpfs = itemView.findViewById(R.id.cpfUsuario);
            enderecos = itemView.findViewById(R.id.enderecoUsuario);
            senhas = itemView.findViewById(R.id.senhaUsuario);

        }
    }
}
