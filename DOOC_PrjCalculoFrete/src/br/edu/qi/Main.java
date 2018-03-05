/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.Frete;
import br.edu.qi.model.Pedido;
import br.edu.qi.model.TipoFrete;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author lg
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            Pedido pedido = new Pedido(1, LocalDate.now(), "Zé", "Luis", 100);
            System.out.println(pedido);

            System.out.print("Tipo de frete (1) Padrão (2) Expresso: ");
            int opcaoFrete = entrada.nextInt();
            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1];
            Frete frete = tipoFrete.ObterFrete();
            double valorComFrete = frete.calcularFrete(pedido.getTotal());
            System.out.println("Valor do frete " + valorComFrete);
            pedido.setTotal(valorComFrete + pedido.getTotal());
            System.out.println(pedido);
        }
    }
}
