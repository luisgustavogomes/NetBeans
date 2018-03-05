package br.edu.qi.view;

import br.edu.qi.util.HelpDate;
import br.edu.qi.model.Endereco;
import br.edu.qi.model.EstadoCivil;
import br.edu.qi.model.Funcionario;
import static br.edu.qi.model.Pessoa.MASCULINO;

public class TesteFuncionario1 {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(1, "Luis", MASCULINO, HelpDate.converterStringData("08/01/1989"), "01683328094",
                new Endereco("Austria", 30, "apto 101", "centro", "90000100"), 1280.50, EstadoCivil.CASADO);
        TelaDetalheFuncionario tela = new TelaDetalheFuncionario(funcionario);
        System.out.println(tela.mostrarDados());
    }
}
