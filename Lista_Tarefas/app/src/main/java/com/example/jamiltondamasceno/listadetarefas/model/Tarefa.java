package com.example.jamiltondamasceno.listadetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private Long id;
    private String nome;
    private String telefone;
    private String dia;
    private String hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getDia() {
        return dia;
    }
    public String getHora() {
        return hora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
}
