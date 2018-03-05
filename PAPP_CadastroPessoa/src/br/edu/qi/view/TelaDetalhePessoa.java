package br.edu.qi.view;

import br.edu.qi.util.HelpDate;
import br.edu.qi.model.Pessoa;

public class TelaDetalhePessoa extends TelaDetalheEndereco {

    private Pessoa pessoa;

    public TelaDetalhePessoa(Pessoa pessoa) {
        super(pessoa.getEndereco());
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String mostrarDados() {
        return ("----------------------\n"
                + "Dados do Pessoa\n"
                + "----------------------\n"
                + "Código    : " + pessoa.getCodigo() + "\n"
                + "Nome      : " + pessoa.getNome() + "\n"
                + "Sexo      : " + pessoa.getSexo() + "\n"
                + "Data Nasc.: " + HelpDate.retornarDataString(pessoa.getDataNascimento()) + "\n"
                + super.mostrarDados());
    }

}
