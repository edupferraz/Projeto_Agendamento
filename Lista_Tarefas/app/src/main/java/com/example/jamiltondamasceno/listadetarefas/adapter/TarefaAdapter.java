package com.example.jamiltondamasceno.listadetarefas.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jamiltondamasceno.listadetarefas.R;
import com.example.jamiltondamasceno.listadetarefas.model.Tarefa;

import java.util.List;

/**
 * Created by jamiltondamasceno
 */

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    private List<Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> lista ) {
        this.listaTarefas = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Tarefa tarefa = listaTarefas.get(position);
        holder.nome.setText( tarefa.getNome() );
        holder.telefone.setText( tarefa.getTelefone() );
        holder.dia.setText( tarefa.getDia() );
        holder.hora.setText( tarefa.getHora() );

    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView telefone;
        TextView dia;
        TextView hora;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            telefone = itemView.findViewById(R.id.textTelefone);
            dia = itemView.findViewById(R.id.textDia);
            hora = itemView.findViewById(R.id.textHora);

        }
    }

}
