package arvorebinaria;

import java.util.ArrayList;
import java.util.List;

public class Arvore {

    public List<Integer> lista = new ArrayList<>();

    public Node inicio;

    public void inserir(int valor) {
        inserir(new Node(valor));
    }

    private void inserir(Node novoNo) {
        List<Integer> nodes = ordemInversa();
        if (!nodes.stream().anyMatch(n -> n == novoNo.valor)) {
            if (this.inicio == null) {
                this.inicio = novoNo;
            } else {
                this.inicio.inserir(novoNo);
            }
        }
    }

    public Node pesquisa(int valor) {
        if (this.inicio == null) {
            return null;
        }
        return this.inicio.pesquisa(valor);
    }

    public int quantidadePesquisa(int valor) {
        if (pesquisa(valor).valor > 0) {
            return 1;
        }
        return 0;
    }

    public Node maior() {
        if (this.inicio == null) {
            return null;
        }
        return this.inicio.maior();
    }

    public Node menor() {
        if (this.inicio == null) {
            return null;
        }
        return this.inicio.menor();
    }

    private void alterarReferencia(Node raiz, Node noAntigo, Node novoNo) {
        if (raiz != null && raiz.direita.valor == noAntigo.valor) {
            raiz.direita = novoNo;
        } else {
            raiz.esquerda = novoNo;
        }
    }

    public Node excluir(int valor) {
        Node temp = this.inicio;
        Node antTemp = null;
        if (this.inicio.valor == valor && quantidade() == 1) {
            return this.inicio = null;
        }
        while (true) {
            if (temp == null) {
                return null;
            }

            if (temp.valor == valor) {
                if (temp.esquerda != null && temp.direita != null) {
                    Node maior = temp.esquerda.maior();
                    maior.inserir(temp.direita);
                    if (this.inicio.valor == valor) {
                        this.inicio = temp.esquerda;
                    } else {
                        alterarReferencia(antTemp, temp, maior);
                    }
                } else if (temp.esquerda != null) {
                    alterarReferencia(antTemp, temp, temp.esquerda);
                } else if (temp.direita != null) {
                    alterarReferencia(antTemp, temp, temp.direita);
                } else {
                    alterarReferencia(antTemp, temp, null);
                }
                return temp;
            } else {
                antTemp = temp;
                if (valor > temp.valor) {
                    temp = temp.direita;
                } else if (valor < temp.valor) {
                    temp = temp.esquerda;
                }
            }
        }
    }

    public List<Integer> atravessarEmOrdem() {
        limpezaLista();
        return atravessarEmOrdem(this.inicio);
    }

    private List<Integer> atravessarEmOrdem(Node inicio) {

        if (inicio == null) {
            return lista;
        }
        atravessarEmOrdem(inicio.esquerda);
        lista.add(inicio.valor);
        atravessarEmOrdem(inicio.direita);
        return lista;
    }

    public List<Integer> atravessarPosOrdem() {
        limpezaLista();
        return atravessarPosOrdem(this.inicio);
    }

    private List<Integer> atravessarPosOrdem(Node inicio) {
        if (inicio == null) {
            return lista;
        }
        atravessarEmOrdem(inicio.esquerda);
        atravessarEmOrdem(inicio.direita);
        lista.add(inicio.valor);
        return lista;
    }

    public List<Integer> atravessarPreOrdem() {
        limpezaLista();
        return atravessarPreOrdem(this.inicio);
    }

    private List<Integer> atravessarPreOrdem(Node inicio) {
        if (inicio == null) {
            return lista;
        }
        lista.add(inicio.valor);
        atravessarEmOrdem(inicio.esquerda);
        atravessarEmOrdem(inicio.direita);
        return lista;
    }

    public List<Integer> folhas() {
        limpezaLista();
        return folhas(this.inicio);
    }

    private List<Integer> folhas(Node inicio) {
        if (inicio == null) {
            return lista;
        }
        if (inicio.esquerda == null && inicio.direita == null) {
            lista.add(inicio.valor);
        }
        folhas(inicio.esquerda);
        folhas(inicio.direita);
        return lista;
    }

    public String verificadorArvore() {
        return verificadorArvore(this.inicio);
    }

    private String verificadorArvore(Node inicio) {
        if (inicio == null) {
            return "Não existe arvore";
        }
        if (this.inicio == inicio && quantidade() == 1) {
            return "Completa";
        }
        if (inicio.esquerda == null || inicio.direita == null) {
            return "Incompleta";
        }
        verificadorArvore(inicio.esquerda);
        verificadorArvore(inicio.direita);
        return "Completa";
    }

    private void limpezaLista() {
        boolean removeAll = lista.removeAll(lista);
    }

    public List<Integer> ordemInversa() {
        List<Integer> ordem = atravessarEmOrdem();
        List<Integer> ordemInversa = new ArrayList<>();
        for (int i = ordem.size(); i > 0; i--) {
            ordemInversa.add(ordem.get(i - 1));
        }
        return ordemInversa;
    }

    public int somaArvore() {
        List<Integer> valores = ordemInversa();
        int total = 0;
        for (Integer v : valores) {
            total += v;
        }
        return total;
    }

    private int quantidade() {
        List<Integer> size = ordemInversa();
        return size.size();
    }

    public double media() {
        if (quantidade() != 0) {
            return somaArvore() / quantidade();
        }
        return 0;
    }

    public List<Integer> primos() {
        List<Integer> numeros = ordemInversa();
        List<Integer> primos = new ArrayList<>();
        teste:
        for (int i = 0; i < numeros.size(); i++) {
            int j = 2;
            do {
                if ((numeros.get(i) % j) == 0 && j != numeros.get(i)) {
                    continue teste;
                } else {
                    j++;
                }
            } while (j < numeros.get(i));
            primos.add(numeros.get(i));
        }
        return primos;
    }
    
    public int altura(){
        return altura(this.inicio);
    }
    
    private int altura(Node inicio) {
        if (inicio  == null) {
            return -1; 
        } else {
            int he = altura(inicio.esquerda);
            int hd = altura(inicio.direita);
            if (he < hd) {
                return hd + 1;
            } else {
                return he + 1;
            }
        }
    }
}
