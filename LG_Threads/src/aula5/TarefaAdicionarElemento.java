/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

import java.util.List;

/**
 *
 * @author lg
 */
public class TarefaAdicionarElemento implements Runnable {

    private List<String> lista;
    private int numeroDoTread;

    public TarefaAdicionarElemento(List<String> lista, int numeroDoTread) {
        this.lista = lista;
        this.numeroDoTread = numeroDoTread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lista.add("Thread " + numeroDoTread + " - " + i);
        }
    }

}
