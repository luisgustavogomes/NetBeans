package br.edu.qi.view;

import br.edu.qi.util.HelpDate;
import br.edu.qi.model.Pessoa;
import static br.edu.qi.model.Pessoa.MASCULINO;

public class TestePessoa1 {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1,"Luis", MASCULINO, HelpDate.converterStringData("08/01/1989"), "01683328094");
        System.out.println(pessoa);
    }

}
