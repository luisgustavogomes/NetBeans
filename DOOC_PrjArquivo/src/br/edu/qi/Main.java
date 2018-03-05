/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.AbstractSend;
import br.edu.qi.model.ChainPattern;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractSend send = ChainPattern.getChainOfSend();
//        send.logMessage(AbstractSend.CRIPTOGRAFADO, "Esse é um arquivo Cripografado!");
//        send.logMessage(AbstractSend.DIVIDIDO, "Esse é um arquivo dividido!");
        send.logMessage(AbstractSend.ZIPADO, "Esse é um arquivo zipado!");
    }
    
}
