package aula32;

import java.util.Scanner;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class Aula32 {
    
    static int numeroDigitado =0;
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite um número: ");
        numeroDigitado = teclado.nextInt();
        System.out.println(retornaValor());
        
    }
    
    public static boolean retornaValor(){
        if (numeroDigitado % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
