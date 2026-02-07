package br.com.fiap.tech.model;



import java.time.LocalDate;

public class Economia {
    private int idEconomia;
    private int idUsuario;
    private String nomeObjetivo;
    private double valorObjetivo;
    private double valorAtual;
    private LocalDate dataInicio;

    // Getters e Setters
    public int getIdEconomia() {
        return idEconomia;
    }
    public void setIdEconomia(int idEconomia) {
        this.idEconomia = idEconomia;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNomeObjetivo() {
        return nomeObjetivo;
    }

    public void setNomeObjetivo(String nomeObjetivo) {
        this.nomeObjetivo = nomeObjetivo;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

}

