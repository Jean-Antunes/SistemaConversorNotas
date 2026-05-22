package apl2;

public class DLinkedList {

    // Primeiro nó da lista
    private Node head;

    // Último nó da lista
    private Node tail;

    // Quantidade de nós
    private int count;

    // Construtor
    public DLinkedList() {

        head = null;
        tail = null;
        count = 0;
    }

    // Insere no começo da lista
    public void insert(String id, String nome, double nota) {

        Node newNode = new Node(id, nome, nota);

        // Se a lista estiver vazia
        if (isEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            // Novo nó aponta para o antigo head
            newNode.setNext(head);

            // Antigo head aponta para o novo nó
            head.setPrev(newNode);

            // Atualiza o head
            head = newNode;
        }

        count++;
    }

    // Insere no final da lista
    public void append(String id, String nome, double nota) {

        Node newNode = new Node(id, nome, nota);

        // Lista vazia
        if (isEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            // Tail aponta para o novo nó
            tail.setNext(newNode);

            // Novo nó aponta para o antigo tail
            newNode.setPrev(tail);

            // Atualiza o tail
            tail = newNode;
        }

        count++;
    }

    // Remove primeiro nó
    public Node removeHead() {

        if (isEmpty()) {
            return null;
        }

        Node removed = head;

        // Se houver apenas um nó
        if (head == tail) {

            head = null;
            tail = null;

        } else {

            // Avança o head
            head = head.getNext();

            // Remove referência anterior
            head.setPrev(null);
        }

        count--;

        return removed;
    }

    // Remove último nó
    public Node removeTail() {

        if (isEmpty()) {
            return null;
        }

        Node removed = tail;

        // Apenas um nó
        if (head == tail) {

            head = null;
            tail = null;

        } else {

            // Move tail para trás
            tail = tail.getPrev();

            // Remove ligação
            tail.setNext(null);
        }

        count--;

        return removed;
    }

    // Remove um nó específico pelo ID
    public Node removeNode(String id) {

        Node current = head;

        while (current != null) {

            // Verifica se encontrou o nó
            if (current.getId().equals(id)) {

                // Se for o primeiro nó
                if (current == head) {
                    return removeHead();
                }

                // Se for o último nó
                if (current == tail) {
                    return removeTail();
                }

                // Liga o nó anterior ao próximo
                current.getPrev().setNext(current.getNext());

                // Liga o próximo ao anterior
                current.getNext().setPrev(current.getPrev());

                count--;

                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    // Procura um nó pelo ID
    public Node getNode(String id) {

        Node current = head;

        while (current != null) {

            if (current.getId().equals(id)) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    // Retorna quantidade de nós
    public int count() {
        return count;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return head == null;
    }

    // Limpa a lista
    public void clear() {

        head = null;
        tail = null;
        count = 0;
    }

    // Mostra lista completa
    @Override
    public String toString() {

        String result = "(" + count + ")\n";

        Node current = head;

        while (current != null) {

            result += current.toString() + "\n";

            current = current.getNext();
        }

        return result;
    }
}