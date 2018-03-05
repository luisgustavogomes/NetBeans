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
public class ContaCorrente extends ContaComTransferencia {
    
    private double limite;
    
    public ContaCorrente(int numero, int agencia, String senha, double limite){
        super(numero, agencia, senha);
        this.limite = limite;
    }
    
    @Override
    public boolean sacar(double valor){
        if(valor > (this.saldo + this.limite)) return false;
        
        this.saldo -= (valor + (valor * CPMF));
        return true;
    }
}
