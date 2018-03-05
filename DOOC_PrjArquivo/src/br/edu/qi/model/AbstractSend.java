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
public abstract class AbstractSend {

    public static int CRIPTOGRAFADO = 1;
    public static int ZIPADO = 2;
    public static int DIVIDIDO = 3;
    
    protected int level;
    protected AbstractSend nextSend;
    
    public void setNextSend(AbstractSend abstractSend){
        this.nextSend = abstractSend;
    }
    
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            executaArquivo(message);
        }
        if (nextSend != null) {
            nextSend.logMessage(level, message);
        }
    }
    
    public abstract void executaArquivo(String message);
}
