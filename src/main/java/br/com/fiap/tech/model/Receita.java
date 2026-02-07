package br.com.fiap.tech.model;

import java.sql.Date;

public class Receita {
    private int id;
    private String descricao;
    private double valor;
    private Date dataReceita;

    public Receita() {}

    public Receita(int id, String descricao, double valor, Date dataReceita) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataReceita = dataReceita;
    }

    public Receita(String descricao, double valor, Date dataReceita) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataReceita = dataReceita;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getDataReceita() { return dataReceita; }
    public void setDataReceita(Date dataReceita) { this.dataReceita = dataReceita; }
}

