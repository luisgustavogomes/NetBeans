/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingua;

import java.util.Locale;

/**
 *
 * @author Luis Gustavo
 */

 public class Lingua {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayLanguage());        
    }

}