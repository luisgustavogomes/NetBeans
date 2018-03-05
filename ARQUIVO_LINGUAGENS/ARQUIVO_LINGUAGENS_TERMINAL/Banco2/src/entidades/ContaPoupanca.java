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
public class ContaPoupanca extends ContaComTransferencia {
    
    private final double RENDIMENTO_PADRAO = 0.007;
    protected double rendimento;
    
    public ContaPoupanca(int numero, int agencia, String senha){
        super(numero, agencia, senha);
        this.rendimento = RENDIMENTO_PADRAO;
    }
    
    @Override
    public boolean depositar(double valor){
        super.depositar(valor);
        this.saldo += (valor * RENDIMENTO_PADRAO);
        return true;
    }
}
