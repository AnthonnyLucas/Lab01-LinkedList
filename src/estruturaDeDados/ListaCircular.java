package estruturaDeDados;

public class ListaCircular {

    // Classe interna para representar um nó da lista
    private class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No ultimo; // Referência para o último nó da lista
    private int tamanho; // Quantidade de elementos na lista

    public ListaCircular() {
        this.ultimo = null;
        this.tamanho = 0;
    }

    // Insere um elemento no início da lista
    public void insereInicio(int i) {
        No novo = new No(i);
        if (ultimo == null) {
            // Lista está vazia, o nó aponta para si mesmo
            novo.proximo = novo;
            ultimo = novo;
        } else {
            novo.proximo = ultimo.proximo;
            ultimo.proximo = novo;
        }
        tamanho++;
    }

    // Insere um elemento no final da lista
    public void insereFim(int i) {
        No novo = new No(i);
        if (ultimo == null) {
            // Lista está vazia, o nó aponta para si mesmo
            novo.proximo = novo;
            ultimo = novo;
        } else {
            novo.proximo = ultimo.proximo;
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    // Busca se um elemento está na lista
    public boolean buscaElemento(int i) {
        if (ultimo == null) {
            return false; // Lista vazia
        }
        No atual = ultimo.proximo;
        do {
            if (atual.valor == i) {
                return true; // Elemento encontrado
            }
            atual = atual.proximo;
        } while (atual != ultimo.proximo);
        return false; // Elemento não encontrado
    }

    // Busca o elemento pelo índice
    public Object buscaIndice(int i) {
        if (i < 0 || i >= tamanho) {
            return null; // Índice inválido
        }
        No atual = ultimo.proximo;
        for (int pos = 0; pos < i; pos++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    // Remove o primeiro elemento da lista
    public void removeInicio() {
        if (ultimo == null) {
            return; // Lista vazia
        }
        if (ultimo == ultimo.proximo) {
            // Apenas um elemento na lista
            ultimo = null;
        } else {
            ultimo.proximo = ultimo.proximo.proximo;
        }
        tamanho--;
    }

    // Remove o último elemento da lista
    public void removeFim() {
        if (ultimo == null) {
            return; // Lista vazia
        }
        if (ultimo == ultimo.proximo) {
            // Apenas um elemento na lista
            ultimo = null;
        } else {
            No atual = ultimo.proximo;
            while (atual.proximo != ultimo) {
                atual = atual.proximo;
            }
            atual.proximo = ultimo.proximo;
            ultimo = atual;
        }
        tamanho--;
    }

    // Remove um elemento em um índice específico
    public void removeIndice(int i) {
        if (i < 0 || i >= tamanho) {
            return; // Índice inválido
        }
        if (i == 0) {
            removeInicio();
            return;
        }
        No atual = ultimo.proximo;
        for (int pos = 0; pos < i - 1; pos++) {
            atual = atual.proximo;
        }
        atual.proximo = atual.proximo.proximo;
        if (atual.proximo == ultimo.proximo) {
            // Atualizou o último elemento
            ultimo = atual;
        }
        tamanho--;
    }

    // Insere um elemento em uma posição específica
    public void insereElementoPosicao(int i, int j) {
        if (j < 0 || j > tamanho) {
            return; // Índice inválido
        }
        if (j == 0) {
            insereInicio(i);
            return;
        }
        No novo = new No(i);
        No atual = ultimo.proximo;
        for (int pos = 0; pos < j - 1; pos++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        if (novo.proximo == ultimo.proximo) {
            // Atualizou o último elemento
            ultimo = novo;
        }
        tamanho++;
    }
}
