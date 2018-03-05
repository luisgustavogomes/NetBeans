
package br.edu.qi.model;


public class Multa {

    private String nroPlaca;
    private String data;
    private String horario;
    private String local;
    private int velocidadePermitida;
    private int velocidadeVeiculo;
    private double valorApagar;

    public Multa(String nroPlaca, String data, String horario, String local, int velocidadePermitida, int velocidadeVeiculo, double valorApagar) {
        this.nroPlaca = nroPlaca;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.velocidadePermitida = velocidadePermitida;
        this.velocidadeVeiculo = velocidadeVeiculo;
        this.valorApagar = valorApagar;
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getLocal() {
        return local;
    }

    public int getVelocidadePermitida() {
        return velocidadePermitida;
    }

    public int getVelocidadeVeiculo() {
        return velocidadeVeiculo;
    }

    public double getValorApagar() {
        return valorApagar;
    }
    
    
}
