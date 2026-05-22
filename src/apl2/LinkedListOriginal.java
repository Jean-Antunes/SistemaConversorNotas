package apl2;

public class LinkedListOriginal {

    // Primeiro nó da lista
    private NodeOriginal head;

    // Quantidade de elementos
    private int count;

    // Construtor
    public LinkedListOriginal() {

        head = null;
        count = 0;
    }

    // Adiciona nó no final da lista
    public void append(
            String id,
            String nome,
            int parteInteira,
            int parteDecimal
    ) {

        // Cria novo nó
        NodeOriginal newNode =
                new NodeOriginal(
                        id,
                        nome,
                        parteInteira,
                        parteDecimal
                );

        // Se lista estiver vazia
        if (head == null) {

            head = newNode;

        } else {

            // Percorre lista
            NodeOriginal current = head;

            while (current.getNext() != null) {

                current = current.getNext();
            }

            // Adiciona novo nó no final
            current.setNext(newNode);
        }

        count++;
    }

    // Retorna início da lista
    public NodeOriginal getHead() {
        return head;
    }

    // Mostra lista completa
    @Override
    public String toString() {

        String result = "(" + count + ")\n";

        NodeOriginal current = head;

        // Percorre lista
        while (current != null) {

            result += current.toString() + "\n";

            current = current.getNext();
        }

        result += "null.";

        return result;
    }
}