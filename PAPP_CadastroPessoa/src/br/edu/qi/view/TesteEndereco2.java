package br.edu.qi.view;

import br.edu.qi.model.Endereco;

public class TesteEndereco2 {

    public static void main(String[] args) {
        TelaDetalheEndereco tela = new TelaDetalheEndereco(new Endereco("abc", 350, "apto 101", "centro", "90000100"));
        System.out.println(tela.mostrarDados());
    }
}
