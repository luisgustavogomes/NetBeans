
package vetor01;

import java.util.Arrays;
import java.util.Scanner;

public class Vetor01 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int vet[] = new int[4];
        
        for (int c = 0; c <= vet.length - 1; c++) {
            System.out.print("Digite o valor do indice " + (c+1) + " : ");
            vet[c] = teclado.nextInt();
        }
        Arrays.sort(vet);
        
        for (int cc:vet){
            System.out.println(cc +" ");
        }
    }

}
