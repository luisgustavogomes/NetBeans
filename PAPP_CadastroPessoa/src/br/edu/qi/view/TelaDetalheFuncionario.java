package br.edu.qi.view;

import br.edu.qi.model.Funcionario;
import java.text.NumberFormat;

public class TelaDetalheFuncionario extends TelaDetalheEndereco {

    private Funcionario funcionario;

    public TelaDetalheFuncionario(Funcionario funcionario) {
        super(funcionario.getEndereco());
        this.funcionario = funcionario;
    }

    @Override
    public String mostrarDados() {
        NumberFormat nfa = NumberFormat.getCurrencyInstance();
        try{
        return ("----------------------\n"
                + "Dados do Funcionário\n"
                + "----------------------\n"
                + "Código       : " + funcionario.getCodigo() + "\n"
                + "Nome         : " + funcionario.getNome() + "\n"
                + "CPF          : " + funcionario.getCpf().substring(0, 3) + "."
                + funcionario.getCpf().substring(3, 6) + "."
                + funcionario.getCpf().substring(6, 9) + "/"
                + funcionario.getCpf().substring(9, 11) + "\n"
                + "Sálario      : " + nfa.format(funcionario.getSalario()) + "\n"
                + "Estado Civil : " + funcionario.getEstadoCivil() + "\n"
                + super.mostrarDados());
        } catch (Exception on){
            on.printStackTrace();
            return "Erro";
        }
    }

}
