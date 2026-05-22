package apl2;

public class Node {

    // ID do aluno
    private String id;

    // Nome do aluno
    private String nome;

    // Nota do aluno
    private double nota;

    // Referência para o próximo nó
    private Node next;

    // Referência para o nó anterior
    private Node prev;

    // Construtor vazio
    public Node() {
    }

    // Construtor com parâmetros
    public Node(String id, String nome, double nota) {

        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    // GETTERS E SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Método para mostrar o nó em formato texto
    @Override
    public String toString() {

        String prevId = "null";
        String nextId = "null";

        // Verifica se existe nó anterior
        if (prev != null) {
            prevId = prev.getId();
        }

        // Verifica se existe próximo nó
        if (next != null) {
            nextId = next.getId();
        }

        return prevId + " <- ("
                + id
                + "; "
                + nome
                + "; "
                + nota
                + ") -> "
                + nextId;
    }
}