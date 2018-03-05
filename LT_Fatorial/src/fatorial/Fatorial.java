package fatorial;

import java.math.BigInteger;

public class Fatorial {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            BigInteger fat = new BigInteger("1");
            for (int j = 2; j <= i; j++) {
                fat = fat.multiply(new BigInteger("" + j));
            }
            System.out.println(i + "! = " + fat);
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
