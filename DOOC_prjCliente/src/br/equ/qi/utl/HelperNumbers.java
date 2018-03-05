/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.utl;


/**
 *
 * @author Luis Gustavo
 */
public class HelperNumbers {

    public static boolean isNumeric(String str) {
        try {
            double val = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
