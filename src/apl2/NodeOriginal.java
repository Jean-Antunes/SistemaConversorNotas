package apl2;

public class NodeOriginal {

    // ID do aluno
    private String id;

    // Nome do aluno
    private String nome;

    // Parte inteira da nota
    private int parteInteira;

    // Parte decimal da nota
    private int parteDecimal;

    // Próximo nó da lista simples
    private NodeOriginal next;

    // Construtor
    public NodeOriginal(
            String id,
            String nome,
            int parteInteira,
            int parteDecimal
    ) {

        this.id = id;
        this.nome = nome;
        this.parteInteira = parteInteira;
        this.parteDecimal = parteDecimal;
    }

    // GETTERS

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getParteInteira() {
        return parteInteira;
    }

    public int getParteDecimal() {
        return parteDecimal;
    }

    public NodeOriginal getNext() {
        return next;
    }

    // Setter do próximo nó
    public void setNext(NodeOriginal next) {
        this.next = next;
    }

    // Mostra nó em formato texto
    @Override
    public String toString() {

        return "("
                + id
                + " # "
                + nome
                + " # "
                + parteInteira
                + " # "
                + parteDecimal
                + ") ->";
    }
}