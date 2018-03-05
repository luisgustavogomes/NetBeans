package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        Random r = new Random();
        long j = 10000;
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        List<Integer> lista3 = new ArrayList<>();

        for (long i = 0; i < j; i++) {
            lista1.add(r.nextInt((int) j));
        }

        lista2.addAll(lista1);
        lista3.addAll(lista1);
        int [] ll = new int [lista3.size()];
        
        for (int i = 0; i < lista3.size(); i++) {
            ll[i] = lista3.get(i);
        }

        System.out.println("Insertion Sort (ArrayList) : " + insertionSort(lista1));


        System.out.println("Bubble Sort (ArrayList) : " + bubbleSort(lista2));

        long t = System.currentTimeMillis();
        mergeSort(ll, 0, 4);
        System.out.println("Merge Sort (ArrayList) : " + (System.currentTimeMillis() - t));

    }

    public static long insertionSort(List<Integer> l) {
        int aux = 0;
        long t = System.currentTimeMillis();
        for (int i = 0; i < l.size(); i++) {
            for (int j = 1; j >= 1 && l.get(j) < l.get(j - 1); j--) {
                aux = l.get(j);
                l.set(j, l.get(j - 1));
                l.set(j - 1, aux);
            }
        }
        return System.currentTimeMillis() - t;
    }

    public static long bubbleSort(List<Integer> l) {
        int aux = 0;
        long t = System.currentTimeMillis();
        for (int i = l.size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (l.get(j) > l.get(j + 1)) {
                    aux = l.get(j);
                    l.set(j, l.get(j + 1));
                    l.set(j + 1, aux);
                }
            }
        }
        return System.currentTimeMillis() - t;
    }

    public static void mergeSort(int[] ll, int primeiro, int n) {
        
        int n1, n2;
        if (n > 1) {
            n1 = (int) (n / 2);
            n2 = (int) (n - n1);
            mergeSort(ll, primeiro, n1);
            mergeSort(ll, primeiro + n, n2);

            merge(ll, primeiro, n1, n2);
        }
        
    }

    private static void merge(int[] ll, int primeiro, int n1, int n2) {
        

        int[] temp = new int[n1 + n2];
        int copiado = 0;
        int copiado1 = 0;
        int copiado2 = 0;
        int i;

        while ((copiado1 < n1) && (copiado2 < n2)) {
            if (ll[primeiro + copiado1] < ll[primeiro + n1 + copiado2]) {
                temp[copiado++] = ll[primeiro + (copiado)];
            } else {
                temp[copiado++] = ll[primeiro + n1 + (copiado2++)];
            }
        }

        while (copiado1 < n1) {
            temp[copiado++] = ll[primeiro + (copiado1++)];
        }

        while (copiado2 < n2) {
            temp[copiado++] = ll[primeiro + n1 + (copiado2++)];
        }
        
        for(i=0;i <n1+n2;i++){
            ll[primeiro + 1] = temp[i];
        }
        
    }
}
