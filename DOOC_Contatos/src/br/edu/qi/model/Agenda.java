package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {

    private List<Contato> listaContatos;

    public Agenda() {
        listaContatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (!listaContatos.stream().anyMatch(l -> l.equals(contato))) {
            listaContatos.add(contato);
        }
    }

    public boolean removerContato(Contato contato) {
        return listaContatos.removeIf(l -> l.equals(contato));
    }

    public int getQuantidade() {
        return listaContatos.size();
    }

    public List<Contato> pesquisarContato(String nome, String telefone) {
        List<Contato> lista = listaContatos.stream().filter(i -> i.getNome().contains(nome) && i.getTelefone().contains(telefone)).collect(Collectors.toList());
        return lista;
    }

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public boolean alterarContato(Contato contatoAntigo, Contato contatoNovo) {
        for (Contato lc : listaContatos) {
            if (lc.equals(contatoAntigo)) {
                if (!listaContatos.stream().anyMatch((Contato c) -> c.equals(contatoNovo))) {
                    lc.setNome(contatoNovo.getNome());
                    lc.setEmail(contatoNovo.getEmail());
                    lc.setEndereco(contatoNovo.getEndereco());
                    lc.setTelefone(contatoNovo.getTelefone());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Agenda{" + "listaContatos=" + listaContatos + '}';
    }

}
