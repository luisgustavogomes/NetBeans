package br.edu.qi.view;

import br.edu.qi.model.Endereco;

public class TelaDetalheEndereco {

    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TelaDetalheEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String mostrarDados() {
        try {
            return ("----------------------\n"
                    + "Dados do Endereço\n"
                    + "----------------------\n"
                    + "Rua    : " + endereco.getRua() + "\n"
                    + "Número : " + endereco.getNumero() + "\n"
                    + "Compl. : " + endereco.getComplemento() + "\n"
                    + "Bairro : " + endereco.getBairro() + "\n"
                    + "CEP    : " + endereco.getCep().substring(0, 5) + "-"
                    + endereco.getCep().substring(5, 8) + "\n"
                    + "----------------------\n");
        } catch (Exception on) {
            on.printStackTrace();
            return "Erro";
        } 
    }
}
