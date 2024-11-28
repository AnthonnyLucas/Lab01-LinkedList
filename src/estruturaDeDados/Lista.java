package estruturaDeDados;

public class Lista {

    // Definição da variável 'head' que será o início da lista ligada
    private Node head;

    // Classe interna Node que representa cada nó da lista ligada
    private static class Node {
        int data;  // A variável que armazenará o valor do nó
        Node next; // A referência para o próximo nó da lista

        // Construtor da classe Node, que inicializa o dado e a referência do próximo nó
        Node(int data) {
            this.data = data;
            this.next = null; // No início, o nó não aponta para nenhum outro nó
        }
    }

    // Construtor da lista ligada (inicializa a lista como vazia)
    public Lista() {
        this.head = null;  // Se a lista estiver vazia, a cabeça é nula
    }

    // Método para inserir um elemento no início da lista
    public void insereInicio(int i) {
        Node newNode = new Node(i);  // Cria um novo nó com o dado 'i'
        newNode.next = head;  // Faz o novo nó apontar para o atual 'head' (início da lista)
        head = newNode;  // Agora, o 'head' é o novo nó (ele se torna o início da lista)
    }

    // Método para buscar um elemento na lista
    public boolean buscaElemento(int i) {
        Node current = head;  // Começa a busca a partir do início da lista
        while (current != null) {
            if (current.data == i) {
                return true;  // Se o elemento for encontrado, retorna 'true'
            }
            current = current.next;  // Avança para o próximo nó da lista
        }
        return false;  // Se o elemento não for encontrado, retorna 'false'
    }

    // Método para buscar um elemento pelo índice
    public Object buscaIndice(int i) {
        Node current = head;  // Começa a busca a partir do início da lista
        int index = 0;  // Inicializa o índice
        while (current != null) {
            if (index == i) {
                return current.data;  // Se o índice corresponder, retorna o dado do nó
            }
            current = current.next;  // Avança para o próximo nó da lista
            index++;  // Incrementa o índice
        }
        return null;  // Se o índice estiver fora do alcance, retorna 'null'
    }

    // Método para inserir um elemento no final da lista
    public void insereFim(int i) {
        Node newNode = new Node(i);  // Cria um novo nó com o dado 'i'
        
        // Caso especial: Se a lista estiver vazia, o novo nó será o único nó da lista
        if (head == null) {
            head = newNode;  // Faz o novo nó ser a cabeça da lista
            return;  // Retorna para encerrar a operação
        }
        
        // Caso em que a lista não está vazia: percorre até o último nó
        Node current = head;
        while (current.next != null) {
            current = current.next;  // Avança para o próximo nó até encontrar o último
        }
        current.next = newNode;  // Faz o último nó apontar para o novo nó, adicionando-o ao final
    }

    // Método para remover o primeiro elemento da lista
    public void removeInicio() {
        if (head != null) {
            head = head.next;  // Faz a cabeça da lista apontar para o próximo nó, removendo o atual
        }
    }

    // Método para remover o último elemento da lista
    public void removeFim() {
        if (head == null) return;  // Se a lista estiver vazia, não há o que remover

        // Caso a lista tenha apenas um elemento:
        if (head.next == null) {
            head = null;  // Remove o único nó da lista
            return;
        }

        // Caso a lista tenha mais de um elemento:
        Node current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;  // Avança até o penúltimo nó
        }
        current.next = null;  // Faz o penúltimo nó não apontar mais para o último nó
    }

    // Método para remover um elemento de uma posição específica (índice)
    public void removeIndice(int i) {
        if (head == null) return;  // Se a lista estiver vazia, não há o que remover

        // Caso o índice seja 0 (remover a cabeça):
        if (i == 0) {
            head = head.next;  // A cabeça agora aponta para o segundo nó, removendo o primeiro
            return;
        }

        // Percorre até o nó anterior ao que será removido
        Node current = head;
        int index = 0;
        while (current != null && index < i - 1) {
            current = current.next;  // Avança para o próximo nó
            index++;
        }

        // Se o nó anterior ao removido existir e ele tiver um próximo nó:
        if (current != null && current.next != null) {
            current.next = current.next.next;  // Remove o nó atual, fazendo o nó anterior apontar para o próximo do removido
        }
    }

    // Método para inserir um elemento em uma posição específica
    public void insereElementoPosicao(int i, int j) {
        if (i < 0) return;  // Se o índice for negativo, não faz nada

        Node newNode = new Node(j);  // Cria um novo nó com o dado 'j'
        
        // Caso especial: Se o índice for 0, insere no início
        if (i == 0) {
            newNode.next = head;  // O novo nó aponta para a cabeça atual
            head = newNode;  // O novo nó se torna a cabeça da lista
            return;
        }

        // Percorre até o nó anterior ao índice desejado
        Node current = head;
        int index = 0;
        while (current != null && index < i - 1) {
            current = current.next;  // Avança para o próximo nó
            index++;
        }

        // Se o nó anterior ao desejado existir, insere o novo nó na posição
        if (current != null) {
            newNode.next = current.next;  // O novo nó aponta para o nó seguinte
            current.next = newNode;  // O nó anterior agora aponta para o novo nó
        }
    }

    // Método para exibir todos os elementos da lista
    public void exibirLista() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");  // Imprime o valor do nó
            current = current.next;  // Avança para o próximo nó
        }
        System.out.println("null");  // Marca o fim da lista
    }
}
