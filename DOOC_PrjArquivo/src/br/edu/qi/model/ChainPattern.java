/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public class ChainPattern {
    
    public static AbstractSend getChainOfSend(){
        
        AbstractSend zipadoSend = new ZipadoSend(AbstractSend.ZIPADO);
        AbstractSend divididoSend = new DivididoSend(AbstractSend.DIVIDIDO);
        AbstractSend criptografadoSend = new CriptografadoSend(AbstractSend.CRIPTOGRAFADO);
        
        criptografadoSend.setNextSend(zipadoSend);
        zipadoSend.setNextSend(divididoSend);
        return criptografadoSend;
    }
}
