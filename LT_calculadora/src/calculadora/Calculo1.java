/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Luis Gustavo
 */
public class Calculo1 {

    public String calcular(int valor1, char operador, int valor2) {
        int retorno = 0;
        switch (operador) {
            case '+':
                retorno = valor1 + valor2;
                break;
            case '-':
                retorno = valor1 - valor2;
                break;
            case '/':
                retorno = valor1 / valor2;
                break;
            case '*':
                retorno = valor1 * valor2;
                break;
        }
        return String.valueOf(retorno);
    }

}
