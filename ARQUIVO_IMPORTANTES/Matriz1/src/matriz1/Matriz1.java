/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz1;

import java.util.Scanner;

/**
 *
 * @author Luis Gustavo
 */
public class Matriz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
    int i, j, m[][] = new int[3][3];

    for (i=0; i<3; i++) {
      System.out.printf("Informe os elementos %da. linha:\n", (i+1));
      for (j=0; j<3; j++) {
        System.out.printf("m[%d][%d] = ", i, j);
        m[i][j] = ler.nextInt();
      }
      System.out.printf("\n");
    }

    System.out.printf("\n");
    for (i=0; i<3; i++) {
      System.out.printf("%da. linha: ", (i+1));
      for (j=0; j<3; j++) {
        System.out.printf("%d ", m[i][j]);
      }
      System.out.printf("\n");
    }
  } 
    
    public static int[][] rotacionarMatrizHorario(int[][] matriz)
    {
        int largura = matriz.length;
        int altura = matriz[0].length;
        int[][] ret = new int[3][3];
        for (int i=0; i<altura; i++) {
            for (int j=0; j<largura; j++) {
                ret[i][j] = matriz[largura - j - 1][i];
            }
        }
        return ret;
    }
    
    public static int[][] rotacionarMatrizAntiHorario(int[][] matriz)
    {
        int largura = matriz.length;
        int altura = matriz[0].length;   
        int[][] ret = new int[altura][largura];
        for (int i=0; i<altura; i++) {
            for (int j=0; j<largura; j++) {
                ret[i][j] = matriz[j][altura - i - 1];
            }
        }
        return ret;
    }
}
    
    

