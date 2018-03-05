/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciorepita;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis Gustavo
 */
public class ExercicioRepita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n, s=0;
        int cont= 0;
        int contp = 0;
        int conti = 0;
        int acima = 0;
        do {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "<html>Informe um número: <br><em>(Valor 0 interrompe)</em> </html>"));
            s += n;
            cont++;
            if ( n % 2 == 0 ) {
                contp++;
            } else {
                conti++;
            }
            if ( n > 100){
                acima++;
            }
        } while (n != 0 );
        JOptionPane.showMessageDialog(null,
                "<html>Resultado final <hr>" + 
                "<br>Soma dos valores:  " + s + 
                "<br>Total de valores:  " + cont +
                "<br>Total de pares:    " + contp + 
                "<br>Total de impares:  " + conti +
                "<br>Acima de 100:      " + acima +
                "</html>");
    }
}
