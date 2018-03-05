/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.utl;

/**
 *
 * @author Luis Gustavo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

/**
 *
 * @author Luis Gustavo
 */
public class Helper {

    public static boolean isNumero(String s) {
        try {
            float num = Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDate(String s) {
        try {
// Data de hoje. 
            GregorianCalendar hoje = new GregorianCalendar();
            int diah = hoje.get(Calendar.DAY_OF_MONTH);
            int mesh = hoje.get(Calendar.MONTH) + 1;
            int anoh = hoje.get(Calendar.YEAR);

// Data do nascimento. 
            int dian = Integer.valueOf(s.substring(0, 2));
            int mesn = Integer.valueOf(s.substring(3, 5));
            int anon = Integer.valueOf(s.substring(6, 10));

// Idade. 
            int idade;

            if (mesn < mesh || (mesn == mesh && dian <= diah)) {
                idade = anoh - anon;
            } else {
                idade = (anoh - anon) - 1;
            }
            
            if (dian >31 || dian < 1){
                return false;
            }
            
            if (mesn >12 || mesn < 1){
                return false;
            }

            if (idade >= 18) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isEmail(String s) {
        try {
            return s.matches("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCep(String s) {
        String padrao = "\\d{5}\\d{3}";
        String cep = s;
        if (cep.matches(padrao)) {
            return true;
        }
        return false;
    }

    public static boolean isNomeCompleto(String s) {
        try {
            return s.matches("^([a-zA-Zà-úÀ-Ú0-9]|-|_|\\s)+$");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPrimo(String s) {
        long n = Long.parseLong(s);
        if (n ==1 || n ==2 ) {
            return true;
        }
        
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= (n / 2); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromo(String variavel) {
        String palavra = variavel;
        String resultado = "";
        for (int x = palavra.length() - 1; x >= 0; x--) {
            resultado += palavra.charAt(x);
        }
        if (resultado.equals(palavra)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUrl(String s) {
        try {
            return s.matches("(?i)\\b(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?\\b");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isMultiploDeTres(String s) {
        try {
            int n = Integer.parseInt(s);

            if (n % 3 == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCPF(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static boolean isDominio(String s) {
        try {
            return s.matches("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,3}$");
        } catch (Exception e) {
            return false;
        }        
    }

}
