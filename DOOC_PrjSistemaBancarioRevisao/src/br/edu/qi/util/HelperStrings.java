/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;


/**
 *
 * @author lg
 */
public class HelperStrings {
    
       
    public static boolean isText (String str){
        try {
            return str.matches("^[a-zA-Z\\s]+");
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isTextOrNumber (String str){
        try {
            return str.matches("^[a-zA-Z0-9\\s]+");
        } catch (Exception e) {
            return false;
        }
    }
}
