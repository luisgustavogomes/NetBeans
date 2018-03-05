/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

/**
 *
 * @author Luis Gustavo
 */
public class HelperNumbers {

    public static boolean isNumericDouble(String s) throws Exception {
        try {
            double num = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPositiv(int s) throws Exception {
        return isPositiv(String.valueOf(s));
    }

    public static boolean isPositiv(String s) throws Exception {
        try {
            double num = Double.parseDouble(s);
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
