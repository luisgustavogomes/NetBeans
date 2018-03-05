/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author luizfduartejr
 */
public class ContaSalario {
    
    protected final double CPMF = 0.1;
    
    private int numero;
    private int agencia;
    private String senha;
    protected double saldo;
    
    public ContaSalario(int numero, int agencia, String senha){
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = 0;
    }
    
    public boolean sacar(double valor){
        if(valor > this.saldo) return false;
        
        this.saldo -= (valor + (valor * CPMF));
        return true;
    }
    
    public boolean depositar(double valor){
        this.saldo += valor;
        return true;
    }
    
    public String getSenha(){ return this.senha; }
    public int getAgencia(){ return this.agencia; }
    public int getNumero(){ return this.numero; }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " - AG:" + this.agencia + " NC:" + this.numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.numero;
        hash = 71 * hash + this.agencia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaSalario other = (ContaSalario) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.agencia != other.agencia) {
            return false;
        }
        return true;
    }

    public double getSaldo() {
        return this.saldo;
    }
    
    
}
