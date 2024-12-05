package estruturaDeDados;

public class Lista {

    // Classe interna representando um nó da lista
    private class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio; // Referência ao primeiro nó da lista
    private int tamanho; // Tamanho da lista

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Insere um elemento no início da lista
    public void insereInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    // Insere um elemento no final da lista
    public void insereFim(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    // Verifica se um elemento está presente na lista
    public boolean buscaElemento(int valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return true; // Elemento encontrado
            }
            atual = atual.proximo;
        }
        return false; // Elemento não encontrado
    }

    // Retorna o valor no índice especificado
    public Object buscaIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        No atual = inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    // Remove o primeiro elemento da lista
    public void removeInicio() {
        if (inicio == null) {
            throw new IllegalStateException("Lista vazia.");
        }
        inicio = inicio.proximo;
        tamanho--;
    }

    // Remove o último elemento da lista
    public void removeFim() {
        if (inicio == null) {
            throw new IllegalStateException("Lista vazia.");
        }
        if (inicio.proximo == null) {
            inicio = null; // Apenas um elemento
        } else {
            No atual = inicio;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
        tamanho--;
    }

    // Remove o elemento no índice especificado
    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        if (indice == 0) {
            removeInicio();
            return;
        }
        No atual = inicio;
        for (int i = 0; i < indice - 1; i++) {
            atual = atual.proximo;
        }
        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }

    // Insere um elemento em uma posição específica
    public void insereElementoPosicao(int valor, int indice) {
        if (indice < 0 || indice > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        if (indice == 0) {
            insereInicio(valor);
            return;
        }
        No novo = new No(valor);
        No atual = inicio;
        for (int i = 0; i < indice - 1; i++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;
    }

    // Retorna o tamanho da lista
    public int getTamanho() {
        return tamanho;
    }
}
