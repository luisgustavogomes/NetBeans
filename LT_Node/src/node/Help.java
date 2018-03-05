/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author Luis Gustavo
 */
public class Help {
    
    public static String semAcento(String txt) {
        String s = "";
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            switch (c) {
                case 'Á':
                case 'À':
                case 'Ã':
                    c = 'A';
                    break;
                case 'É':
                case 'Ê':
                    c = 'E';
                    break;
                case 'Í':
                    c = 'I'; 
                    break;
                case 'Ó':
                case 'Õ':
                case 'Ô':
                    c = 'O';
                    break;
                case 'Ú':
                    c = 'U';
                    break;
                case 'Ç':
                    c = 'C';
                case 'á':
                case 'à':
                case 'ã':
                    c = 'a';
                    break;
                case 'é':
                case 'ê':
                    c = 'e';
                    break;
                case 'í':
                    c = 'i';
                    break;
                case 'ó':
                case 'õ':
                case 'ô':
                    c = 'o';
                    break;
                case 'ú':
                    c = 'u';
                    break;
                case 'ç':
                    c = 'c';
                    break;
            }
            s += c;
        }
        return s.toLowerCase();
    }
    
}
