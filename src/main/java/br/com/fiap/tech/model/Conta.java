package br.com.fiap.tech.model;

import java.time.LocalDate;

public class Conta {
    private int idConta;
    private int idUsuario;
    private String nomeConta;
    private String tipoConta;
    private double saldo;
    private LocalDate dataCriacao;

    public int getIdConta() {
        return idConta;
    }
public void setIdConta(int idCconta) {
        this.idConta = idCconta;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNomeConta() {
        return nomeConta;
    }
    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }
    public String getTipoConta() {
        return tipoConta;
    }
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

