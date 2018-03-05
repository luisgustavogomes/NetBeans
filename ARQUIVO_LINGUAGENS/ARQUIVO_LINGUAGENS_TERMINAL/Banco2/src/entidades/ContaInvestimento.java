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
public class ContaInvestimento extends ContaPoupanca {
    
    public ContaInvestimento(int numero, int agencia, String senha, double rendimento) {
        super(numero, agencia, senha);
        super.rendimento = rendimento;
    }
    
    @Override
    public boolean depositar(double valor){
        super.depositar(valor);
        this.saldo += (valor * this.rendimento);
        return true;
    }
}
