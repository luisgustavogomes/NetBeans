package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Teste {

//    interface Num {
//
//        double getValue();
//    }
//
//    interface ValorNumero {
//
//        boolean teste(int n);
//    }
//
//    interface ValorNumero2 {
//
//        boolean teste(int n, int n2);
//    }
    public static void main(String[] args) {

//        Num n;
//        n = () -> 555.11;
//        System.out.println(n.getValue());
//
//        Num n2 = () -> Math.random() * 100;
//        System.out.println(n2.getValue());
//
//        ValorNumero isPar = (int i) -> (i % 2) == 0;
//        System.out.println(isPar.teste(89));
//        System.out.println(isPar.teste(90));
//
//        ValorNumero2 isDiv = (x, y) -> (x % y) == 0;
//        System.out.println(isDiv.teste(10, 2));
//        System.out.println(isDiv.teste(10, 3));
//        ValorNumero ex1 = (i) -> (i % 2) == 0;
//        ValorNumero2 ex2 = (x, y) -> {
//            int w = x + y;
//            return w > 1000;
//        };
//        List<String> lista1 = Arrays.asList("SP","RS","RJ","SC","PR");
//        List<String> lista2 = new ArrayList<>();
////        
////        for (String s : lista1) {
////            System.out.println(s);
////        }
////        
//        //lista1.forEach(x -> System.out.println(x));
//        //lista1.forEach(System.out::println);
//        //List<String> lista2;
//        System.out.println(lista1.stream().anyMatch(x -> x.contains("Z")));
        //==========================================================================================================
        System.out.println("Utilizando o filter ");

        List<Pessoa> listaPessoas = Arrays.asList(new Pessoa("Joao", 32),
                new Pessoa("Antonio", 20),
                new Pessoa("Maria", 18),
                new Pessoa("Angela", 30));
        Stream<Pessoa> streamPessoas = listaPessoas.stream();

        Integer somaIdade = streamPessoas.filter    (p -> p.getNome().startsWith("A"))
                .mapToInt(p -> p.getIdade()).sum();
//        Integer maiorIdade = (Integer) listaPessoas.stream().mapToInt(e -> e.getIdade()).max().getAsInt();
//        Integer menorIdade = (Integer) listaPessoas.stream().mapToInt(q -> q.getIdade()).min().getAsInt();
//        Integer somaIdade = (Integer) listaPessoas.stream().mapToInt(p -> p.getIdade()).sum();
//        System.out.println("Soma= " + somaIdade
//                + "\nMaior= " + maiorIdade
//                + "\nMenor= " + menorIdade);
        IntSummaryStatistics intSummStat = streamPessoas.filter(p -> p.getNome().startsWith("A"))
                .mapToInt(p -> p.getIdade()).summaryStatistics();

        System.out.println(intSummStat.getSum());
        System.out.println(intSummStat.getMax());
        System.out.println(intSummStat.getMin());

    }

}
