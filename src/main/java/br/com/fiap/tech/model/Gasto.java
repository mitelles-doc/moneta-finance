package br.com.fiap.tech.model;

import java.time.LocalDate;

public class Gasto {
    private int idGasto;
    private int idUsuario;
    private String nomeGasto;
    private double valorGasto;
    private LocalDate dataGasto;

    // Getters e Setters
    public int getIdGasto() { return idGasto; }
    public void setIdGasto(int idGasto) { this.idGasto = idGasto; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNomeGasto() { return nomeGasto; }
    public void setNomeGasto(String nomeGasto) { this.nomeGasto = nomeGasto; }

    public double getValorGasto() { return valorGasto; }
    public void setValorGasto(double valorGasto) { this.valorGasto = valorGasto; }

    public LocalDate getDataGasto() { return dataGasto; }
    public void setDataGasto(LocalDate dataGasto) { this.dataGasto = dataGasto; }

    public void setNomeConta(String nomeConta) {
        this.nomeGasto = nomeConta;
    }

    public void setTipoConta(String tipoConta) {
        this.valorGasto = Double.parseDouble(tipoConta);
    }

    public void setSaldo(double valor) {
        this.dataGasto = LocalDate.now();
    }

    public void setDataCriacao(LocalDate now) {
        this.dataGasto = now;
    }
}

