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
public class ContaComTransferencia extends ContaSalario {

    public ContaComTransferencia(int numero, int agencia, String senha) {
        super(numero, agencia, senha);
    }
    
    public boolean transferir(ContaCorrente contaDestino, double valor){
        this.sacar(valor);
        contaDestino.depositar(valor);
        return true;
    }
    
}
