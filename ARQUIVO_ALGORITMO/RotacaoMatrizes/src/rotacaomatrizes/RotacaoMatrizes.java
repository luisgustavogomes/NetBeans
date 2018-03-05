/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotacaomatrizes;

/**
 *
 * @author Luis Gustavo
 */
public class RotacaoMatrizes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
