package arvorebinaria;

public class Node {

    public Node esquerda;
    public Node direita;
    public int valor;

    public Node(int valor) {
        this.valor = valor;
    }

    public void inserir(Node novoNo) {
        if (novoNo.valor > this.valor) {
            if (this.direita != null) {
                this.direita.inserir(novoNo);
            } else {
                this.direita = novoNo;
            }
        } else if (this.esquerda != null) {
            this.esquerda.inserir(novoNo);
        } else {
            this.esquerda = novoNo;
        }

    }

    public Node pesquisa(int valor) {
        if (valor == this.valor) {
            return this;
        } else if (valor > this.valor && this.direita != null) {
            return this.direita.pesquisa(valor);
        } else if (this.esquerda != null) {
            return this.esquerda.pesquisa(valor);
        } else {
            return null;
        }
    }

    public Node maior() {
        if (this.direita != null) {
            return this.direita.maior();
        }
        return this;
    }

    public Node menor() {
        if (this.esquerda != null) {
            return this.esquerda.menor();
        }
        return this;
    }

    @Override
    public String toString() {
        return this.valor + "";
    }

    void exercicio() {
        //1) Implemente uma função que retorna o menor elemento de uma árvore passada por parâmetro.
        //--ok
        //2) Implemente uma função que retorne a quantidade de folhas de uma árvore passada por parâmetro.
        //--ok
        //3) Considerando que em uma árvore binária os elementos menores que a raiz são alocados à esquerda
        //   e os maiores ou iguais à direita, escreva um método que conta quantas ocorências de um número
        //   passado por parâmetro foram encontrados na árvore.
        //--ok
        //4) Escreva um método que atravesse a árvore em ordem decrescente.
        //--ok
        //5) Considerando uma árvore binária que armazene inteiros em seus nós, escreva uma função que some 
        //   todos os valores dos nós e retorne o resultado.
        //--ok
        //6) Escreva um método para calcular a altura (profundidade) de uma árvore.
        //--ok
        //7) Considerando que uma árvore binária completa é aquela cujos nós sempre possuem 0 ou 2 filhos,
        //   escreva um método para determinar se uma árvore binária é completa ou não.
        //(verificar 2 ou 0)
        //--ok
        //8) Crie um método que, usando uma árvore binária de inteiros, calcule a média aritmética dos valores.
        //--ok
        //9) Crie um método que atravesse uma árvore binária de inteiros e retorne 
        //   todos os números primos presentes nela.
        //--ok

    }

}
