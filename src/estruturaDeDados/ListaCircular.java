package estruturaDeDados;

public class ListaCircular {

    private Node head; // Cabeça da lista circular
    private Node tail; // Cauda da lista circular

    // Classe interna Node que representa cada nó da lista
    private static class Node {
        int data;  // Dados armazenados no nó
        Node next; // Referência para o próximo nó
        
        // Construtor para criar um nó com um dado
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Construtor da lista circular (inicializa a lista como vazia)
    public ListaCircular() {
        this.head = null;  // Inicializa a cabeça como nula
        this.tail = null;  // Inicializa a cauda como nula
    }

    // Insere um elemento no início da lista circular
    public void insereInicio(int i) {
        Node newNode = new Node(i);  // Cria um novo nó

        if (head == null) {  // Se a lista estiver vazia
            head = newNode;
            tail = newNode;  // O novo nó é tanto a cabeça quanto a cauda
            tail.next = head;  // A cauda aponta para a cabeça, completando o ciclo
        } else {
            newNode.next = head;  // O novo nó aponta para a cabeça
            head = newNode;  // A cabeça agora é o novo nó
            tail.next = head;  // A cauda continua apontando para a cabeça (circularidade)
        }
    }

    // Busca um elemento na lista circular
    public boolean buscaElemento(int i) {
        if (head == null) return false;  // Se a lista estiver vazia, retorna falso

        Node current = head;
        do {
            if (current.data == i) {
                return true;  // Se encontrar o elemento, retorna verdadeiro
            }
            current = current.next;  // Avança para o próximo nó
        } while (current != head);  // Se retornar à cabeça, terminou a busca

        return false;  // Elemento não encontrado
    }

    // Busca um elemento pelo índice na lista circular
    public Object buscaIndice(int i) {
        if (head == null) return null;  // Se a lista estiver vazia, retorna null

        Node current = head;
        int index = 0;
        do {
            if (index == i) {
                return current.data;  // Retorna o dado no índice especificado
            }
            current = current.next;  // Avança para o próximo nó
            index++;
        } while (current != head);  // Se retornar à cabeça, terminou a busca

        return null;  // Índice fora do alcance
    }

    // Insere um elemento no final da lista circular
    public void insereFim(int i) {
        Node newNode = new Node(i);  // Cria um novo nó

        if (head == null) {  // Se a lista estiver vazia
            head = newNode;
            tail = newNode;  // O novo nó é tanto a cabeça quanto a cauda
            tail.next = head;  // A cauda aponta para a cabeça, completando o ciclo
        } else {
            tail.next = newNode;  // O atual último nó aponta para o novo nó
            tail = newNode;  // A cauda agora é o novo nó
            tail.next = head;  // A cauda aponta para a cabeça (circularidade)
        }
    }

    // Remove o primeiro elemento da lista circular
    public void removeInicio() {
        if (head == null) return;  // Se a lista estiver vazia, não há o que remover

        if (head == tail) {  // Se a lista tem apenas um nó
            head = null;
            tail = null;  // A lista agora está vazia
        } else {
            head = head.next;  // A cabeça agora é o próximo nó
            tail.next = head;  // A cauda continua apontando para a nova cabeça
        }
    }

    // Remove o último elemento da lista circular
    public void removeFim() {
        if (head == null) return;  // Se a lista estiver vazia, não há o que remover

        if (head == tail) {  // Se a lista tem apenas um nó
            head = null;
            tail = null;  // A lista agora está vazia
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;  // Avança até o penúltimo nó
            }
            current.next = head;  // O penúltimo nó agora aponta para a cabeça
            tail = current;  // A cauda passa a ser o penúltimo nó
        }
    }

    // Remove um elemento de uma posição específica (índice)
    public void removeIndice(int i) {
        if (head == null) return;  // Se a lista estiver vazia, não há o que remover

        if (i == 0) {  // Se o índice for 0, remove o primeiro nó
            removeInicio();
            return;
        }

        Node current = head;
        int index = 0;
        while (current != tail && index < i - 1) {
            current = current.next;  // Avança até o nó anterior ao que será removido
            index++;
        }

        if (current != tail) {  // Se encontrou o nó anterior ao removido
            current.next = current.next.next;  // O nó anterior aponta para o nó seguinte
            if (current.next == head) {
                tail = current;  // Se a cauda for removida, a nova cauda é o nó atual
            }
        }
    }

    // Insere um elemento em uma posição específica na lista circular
    public void insereElementoPosicao(int i, int j) {
        if (i < 0) return;  // Se o índice for negativo, não faz nada

        if (i == 0) {  // Se for para inserir no início
            insereInicio(j);
            return;
        }

        Node newNode = new Node(j);  // Cria um novo nó
        Node current = head;
        int index = 0;

        // Percorre até o nó anterior à posição onde o novo nó será inserido
        while (current != tail && index < i - 1) {
            current = current.next;
            index++;
        }

        if (current == tail) {  // Se for para inserir no final
            insereFim(j);
        } else {  // Caso contrário, insere no meio
            newNode.next = current.next;  // O novo nó aponta para o próximo nó
            current.next = newNode;  // O nó anterior aponta para o novo nó
        }
    }

    // Método para exibir os elementos da lista circular
    public void exibirLista() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");  // Exibe o valor do nó
            current = current.next;  // Avança para o próximo nó
        } while (current != head);  // Se retornar à cabeça, termina a exibição
        System.out.println("(retorno à cabeça)");  // Indica que a lista é circular
    }
}
