/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import br.edu.qi.model.AbstractLogger;
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
        AbstractLogger logger = ChainPattern.getChainOfLogger();
        
//        logger.logMessage(AbstractLogger.INFO, "Este é uma informação!");
//        logger.logMessage(AbstractLogger.DEBUG, "Este é um debug!");
        logger.logMessage(AbstractLogger.ERROR, "Este é um erro!");
    }

}
