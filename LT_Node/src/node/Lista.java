/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import arquivo.GerenciadorArquivo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.swing.JTextField;

/**
 *
 * @author Luis Gustavo
 */
public class Lista<T extends ItemGenerico> {

    

    public Node<T> inicio = null;
    public Node<T> fim = null;
    public int tamanho = 0;
    public int total = 0;

    public static List<Aluno> alunos = new ArrayList<>();

    public void exercicio() {
//Laboratório - Exercícios
//6. Crie um método que imprima o código e nome de todos os alunos do sistema em ordem alfabética.
//
//7. Crie um sistema com interface gráfica para cadastro de alunos. Crie as telas para listagem e cadastro 
//   dos alunos, bem como permita que alunos possam ser excluídos e editados. Armazene os alunos em memória 
//   usando uma lista
    }

    public Lista(int tamanho) {
        this.inicio = null;
        this.tamanho = tamanho;
        this.fim = null;
        this.total = 0;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == tamanho;
    }

    public boolean addFinal(T valor) {
        if (!verificadorCodigo(valor)) {
            if (isFull()) {
                return false;
            }
            Node novoNo = new Node(valor);
            if (isEmpty()) {
                this.inicio = novoNo = this.fim;
                return false;
            } else {
                Node ultimoNo = this.inicio;
                while (ultimoNo.proximo != null) {
                    ultimoNo = ultimoNo.proximo;
                }
                ultimoNo.proximo = novoNo;
                novoNo.anterior = ultimoNo;
            }
            this.fim = novoNo;
            this.total++;
            return false;
        } else {
            return false;
        }

    }

    public boolean add(T valor) {
        if (!verificadorCodigo(valor)) {
            if (isFull()) {
                return false;
            }
            Node novoNo = new Node(valor);
            if (isEmpty()) {
                this.fim = this.inicio = novoNo;
                this.total++;
                return true;
            }
            novoNo.proximo = this.inicio;
            inicio.anterior = novoNo;
            this.inicio = novoNo;
            this.total++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addIndex(T valor, int index) {
        if (!verificadorCodigo(valor)) {
            if (index < 0 || index > this.tamanho) {
                return false;
            }
            if (isEmpty() || index == 0) {
                add(valor);
                return true;
            }
            Node novoNo = new Node(valor);
            Node aux = this.inicio.proximo;
            int i = 1;
            while (aux != null && i < index) {
                aux = aux.proximo;
                i++;
            }
            novoNo.proximo = aux;
            novoNo.anterior = aux.anterior;
            aux.anterior.proximo = novoNo;
            aux.anterior = novoNo;
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isEdicaoAluno (int codigo, String novoNome, String novoCurso){
//        for (Aluno aluno : alunos) {
//            if (aluno.getCodigo() == codigo) {
//                aluno.setNome(novoNome);
//                aluno.setCurso(novoCurso);
//            }
//        }
        
        alunos.stream().forEach(a ->{
            if (a.getCodigo() == codigo) {
                a.setNome(novoNome);
                a.setCurso(novoCurso);
            }
        });
        List<String> lista = new ArrayList<>();
        alunos.stream().forEach(a -> lista.add(a.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, Aluno.class.getSimpleName());
    }

    public void remove(T valor) {
        if (isEmpty()) {
            return;
        }
        Node ultimoNo = this.inicio;
        while (ultimoNo != null) {
            if (ultimoNo.valor == valor) {
                // início
                if (ultimoNo == inicio) {
                    inicio = inicio.proximo;
                    inicio.anterior = null;
                } // meio
                else if (ultimoNo.proximo != null) {
                    ultimoNo.anterior.proximo = ultimoNo.proximo;
                    ultimoNo.proximo.anterior = ultimoNo.anterior;
                } // fim
                else {
                    ultimoNo.anterior = null;
                    fim = ultimoNo.anterior;
                }
                this.total--;
                break;
            }
            ultimoNo = ultimoNo.proximo;
        }
    }

    public void removeFinal(int index) {
        if (index < 0 || index > (this.tamanho - 1) || this.isEmpty()) {
            return;
        }
        if (index == 0) {
            remove(this.inicio.valor);
        }
        if (index == (tamanho - 1)) {
            remove(this.fim.valor);
        }
        Node aux = this.inicio.proximo;
        Node penultimo = this.inicio;
        int i = 1;
        while (aux != null && i < index) {
            penultimo = aux;
            aux = aux.proximo;
            i++;
        }
        penultimo.proximo = aux.proximo;
        aux = null;
        tamanho--;
        return;
    }

    /**
     *
     * @param opcao '1' Lista Crescente opcao '2' Lista Decrescente opcao '3'
     * Lista em ordem
     * @return
     */
    public List<T> imprimir(int opcao) {
        List<T> lista = new ArrayList<>();
        Node ultimoNo = this.inicio;
        Node ultimoNoFim = this.fim;
        switch (opcao) {
            case 1:
                while (ultimoNo != null) {
                    lista.add((T) ultimoNo.valor);
                    ultimoNo = ultimoNo.proximo;
                }
                break;
            case 2:
                while (ultimoNoFim != null) {
                    lista.add((T) ultimoNoFim.valor);
                    ultimoNoFim = ultimoNoFim.anterior;
                }
                break;
            case 3:
                while (ultimoNoFim != null) {
                    lista.add((T) ultimoNoFim.valor);
                    ultimoNoFim = ultimoNoFim.anterior;
                }
                Collections.sort(lista);
                break;
        }
        return lista;
    }

    public List<T> buscar(String textoProcurado) {
        List<T> lista = imprimir(1);
        lista.forEach(l -> {
            if (Help.semAcento(l.getPesquisa()).contains(Help.semAcento(textoProcurado))) {
                lista.add(l);
            }
        });
        return lista;
    }

    public boolean verificadorCodigo(T valor) {
        List<T> lista = imprimir(1);
        return lista.stream().anyMatch(l -> l.getIdentificador() == valor.getIdentificador());
    }

    public static boolean isCadastrarAluno(String nome, String curso) {
        Aluno aluno = new Aluno(nome, curso);
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            GerenciadorArquivo.escreverArquivoClassAppend(aluno.toString(), aluno.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    public static boolean isCarregarAluno() {
        List<String> arquivo = GerenciadorArquivo.lerArquivoClass(Aluno.class.getSimpleName());
        if (arquivo != null) {
            arquivo.stream().forEach((String a) -> alunos.add(new Aluno(a)));
            return true;
        }
        return false;
    }

    public static boolean isExclusaoAluno(int codigo) {
        alunos.removeIf((Aluno a) -> a.getCodigo()==codigo);
        List<String> lista = new ArrayList<>();
        alunos.stream().forEach(a -> lista.add(a.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, Aluno.class.getSimpleName());
    }

    public static int ultimoCodigo() {
        int maior = 0;
        if (!alunos.isEmpty()) {
            alunos.stream().forEach(a -> System.out.println(a.getCodigo()));
            for (Aluno aluno : alunos) {
                if (aluno.getCodigo() > maior) {
                    maior = aluno.getCodigo();
                }
            }
        }
        return maior;
    }
}
