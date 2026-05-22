package apl2;

public class Operation {

    // Converte lista antiga para nova lista
    public static DLinkedList map(LinkedListOriginal originalList) {

        DLinkedList newList = new DLinkedList();

        NodeOriginal current = originalList.getHead();

        // Percorre lista original
        while (current != null) {

            // Adiciona prefixo no ID
            String novoId = "26.S1-" + current.getId();

            double nota;

            // Verifica ausência de nota
            if (current.getParteInteira() == -1
                    || current.getParteDecimal() == -1) {

                nota = 99.9;

            } else {

                // Junta parte inteira e decimal
                String notaTexto =
                        current.getParteInteira()
                                + "."
                                + current.getParteDecimal();

                nota = Double.parseDouble(notaTexto);
            }

            // Adiciona na nova lista
            newList.append(
                    novoId,
                    current.getNome(),
                    nota
            );

            current = current.getNext();
        }

        return newList;
    }

    // Remove alunos sem nota válida
    public static DLinkedList filterRemoveNonGraded(DLinkedList list) {

        DLinkedList validList = new DLinkedList();

        Node current = list.getHead();

        while (current != null) {

            // Mantém apenas notas válidas
            if (current.getNota() != 99.9) {

                validList.append(
                        current.getId(),
                        current.getNome(),
                        current.getNota()
                );
            }

            current = current.getNext();
        }

        return validList;
    }

    // Mantém apenas notas inválidas
    public static DLinkedList filterRemoveGraded(DLinkedList list) {

        DLinkedList invalidList = new DLinkedList();

        Node current = list.getHead();

        while (current != null) {

            if (current.getNota() == 99.9) {

                invalidList.append(
                        current.getId(),
                        current.getNome(),
                        current.getNota()
                );
            }

            current = current.getNext();
        }

        return invalidList;
    }

    // Filtra notas acima da média
    public static DLinkedList filterRemoveBelowAverage(
            DLinkedList list,
            float media
    ) {

        DLinkedList aboveAverage = new DLinkedList();

        Node current = list.getHead();

        while (current != null) {

            // Verifica se nota é maior que média
            if (current.getNota() > media) {

                aboveAverage.append(
                        current.getId(),
                        current.getNome(),
                        current.getNota()
                );
            }

            current = current.getNext();
        }

        return aboveAverage;
    }

    // Calcula média das notas
    public static float reduce(DLinkedList list) {

        Node current = list.getHead();

        float soma = 0;
        int quantidade = 0;

        // Percorre lista somando notas
        while (current != null) {

            soma += current.getNota();

            quantidade++;

            current = current.getNext();
        }

        // Evita divisão por zero
        if (quantidade == 0) {
            return 0;
        }

        // Retorna média
        return soma / quantidade;
    }

    // Converte lista para String CSV
    public static String mapToString(DLinkedList list) {

        String result = "";

        Node current = list.getHead();

        while (current != null) {

            result += current.getId()
                    + ";"
                    + current.getNome()
                    + ";"
                    + current.getNota();

            // Adiciona quebra de linha
            if (current.getNext() != null) {
                result += "\n";
            }

            current = current.getNext();
        }

        return result;
    }
}