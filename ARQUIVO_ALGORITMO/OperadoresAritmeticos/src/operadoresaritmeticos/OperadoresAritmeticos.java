/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresaritmeticos;

/**
 *
 * @author Luis Gustavo
 */
public class OperadoresAritmeticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n1 = 3;
        int n2 = 5;
        float m = (n1+n2)/2;
        System.out.println("A média é igual a "+ m);
        
        
        int numero = 10;
        int valor = 4 + numero--;
        System.out.println(valor);
        System.out.println(numero);
        
        
        int x = 4;
        x *= 2;
        System.out.println(x);
        System.out.println(Math.PI);
        System.out.println(Math.pow(5, 2));
        System.out.println(Math.sqrt(25));
        System.out.println(Math.cbrt(27));
        System.out.println(Math.abs(-10));
        System.out.println(Math.floor(3.9));
        System.out.println(Math.ceil(4.2));
        System.out.println(Math.round(5.6));
        
        
        float v = 8.4f;
        int ar = (int) Math.round(v);
        System.out.println(ar);
        
        
        double ale = Math.random();
        int n = (int) (15 + ale * ( 50 - 15 ));
        System.out.println(n);
       
    }
    
}