/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2;

/**
 *
 * @author luizfduartejr
 */
public interface OperacoesBanco {
    
    boolean sacar(double valor);
    boolean depositar(double valor);
    
}
