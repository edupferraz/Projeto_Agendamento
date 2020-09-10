package com.example.jamiltondamasceno.listadetarefas.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jamiltondamasceno.listadetarefas.R;
import com.example.jamiltondamasceno.listadetarefas.helper.TarefaDAO;
import com.example.jamiltondamasceno.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editNome;
    private TextInputEditText editTelefone;
    private TextInputEditText editDia;
    private TextInputEditText editHora;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        //Recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        //Configurar tarefa na caixa de texto
        if ( tarefaAtual != null ){
            editNome.setText( tarefaAtual.getNome() );
            editTelefone.setText( tarefaAtual.getTelefone() );
            editDia.setText( tarefaAtual.getDia() );
            editHora.setText( tarefaAtual.getHora() );
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.itemSalvar :
                //Executa açao para o item salvar

                TarefaDAO tarefaDAO = new TarefaDAO( getApplicationContext() );

                if ( tarefaAtual != null ){//edicao

                    String nomeTarefa = editNome.getText().toString();
                    String telefoneTarefa = editTelefone.getText().toString();
                    String diaTarefa = editDia.getText().toString();
                    String horaTarefa = editHora.getText().toString();

                    if ( !nomeTarefa.isEmpty()){

                        Tarefa tarefa = new Tarefa();
                        tarefa.setNome( nomeTarefa );
                        tarefa.setTelefone( telefoneTarefa );
                        tarefa.setDia( diaTarefa );
                        tarefa.setHora( horaTarefa );

                        tarefa.setId( tarefaAtual.getId() );

                        //atualizar no banco de dados
                        if ( tarefaDAO.atualizar( tarefa ) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                }else {//salvar

                    String nomeTarefa = editNome.getText().toString();
                    String telefoneTarefa = editTelefone.getText().toString();
                    String diaTarefa = editDia.getText().toString();
                    String horaTarefa = editHora.getText().toString();

                    if ( !nomeTarefa.isEmpty() &&
                        !telefoneTarefa.isEmpty() &&
                        !diaTarefa.isEmpty() &&
                        !horaTarefa.isEmpty()){

                        Tarefa tarefa = new Tarefa();
                        tarefa.setNome( nomeTarefa );
                        tarefa.setTelefone( telefoneTarefa );
                        tarefa.setNome( diaTarefa );
                        tarefa.setNome( horaTarefa );

                        if ( tarefaDAO.salvar( tarefa ) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }

                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
