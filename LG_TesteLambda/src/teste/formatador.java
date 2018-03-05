/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Gustavo
 */
public class formatador {
    public static void main(String[] args) {
        // \\d - todos os digitos 
        // \\D - todos que não digitos
        // \\s - espaços em branco \t \n \f \r
        // \\S - caractere que não é branco
        // \\w - caracteres palavras a-z, A-Z, digitos e _
        // \\W - tudo o que não for uma palavra
        
        String regex ="\\W";
        String texto ="u@u$u78 n ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:     " + texto);
        System.out.println("indice:    0123456789" );
        System.out.println("Expressão: " + matcher.pattern());
        System.out.println("Posições encontradas");
        while(matcher.find()){
            System.out.print(matcher.start() + " ");
        }
        System.out.println("");
        
    }
}
