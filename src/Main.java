import apl2.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner para leitura do teclado
        Scanner scanner = new Scanner(System.in);

        // Lista original
        LinkedListOriginal originalList =
                new LinkedListOriginal();

        // Leitura do arquivo
        try {

            String conteudo =
                    Data.loadTextFileToString("/workspaces/SistemaConversorNotas/dados.txt");

            // Divide linhas
            String linhas[] =
                    conteudo.split("\\r?\\n|\\r");

            // Percorre linhas
            for (int i = 0; i < linhas.length; i++) {

                // Divide campos pelo #
                String partes[] = linhas[i].split("#");

                String id = partes[0];
                String nome = partes[1];

                int parteInteira =
                        Integer.parseInt(partes[2]);

                int parteDecimal =
                        Integer.parseInt(partes[3]);

                // Adiciona na lista
                originalList.append(
                        id,
                        nome,
                        parteInteira,
                        parteDecimal
                );
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        int option = 0;

        // Loop do menu
        while (option != 8) {

            System.out.println("\n===== MENU =====");

            System.out.println("1 - Mostrar dados originais");
            System.out.println("2 - Converter dados");
            System.out.println("3 - Mostrar notas válidas");
            System.out.println("4 - Mostrar notas inválidas");
            System.out.println("5 - Mostrar média");
            System.out.println("6 - Mostrar acima da média");
            System.out.println("7 - Gerar string final");
            System.out.println("8 - Sair");

            option = scanner.nextInt();
            scanner.nextLine();

            // Converte lista
            DLinkedList converted =
                    Operation.map(originalList);

            switch (option) {

                case 1:

                    System.out.println(originalList);

                    break;

                case 2:

                    System.out.println(converted);

                    // Gera CSV
                    String csv =
                            Operation.mapToString(converted);

                    try {

                        Data.saveStringToTextFile(
                                "dados.csv",
                                csv
                        );

                        System.out.println(
                                "Arquivo CSV gerado."
                        );

                    } catch (IOException e) {

                        System.out.println(
                                "Erro ao salvar arquivo."
                        );
                    }

                    break;

                case 3:

                    DLinkedList valid =
                            Operation.filterRemoveNonGraded(
                                    converted
                            );

                    System.out.println(valid);

                    break;

                case 4:

                    DLinkedList invalid =
                            Operation.filterRemoveGraded(
                                    converted
                            );

                    System.out.println(invalid);

                    break;

                case 5:

                    DLinkedList validMedia =
                            Operation.filterRemoveNonGraded(
                                    converted
                            );

                    float media =
                            Operation.reduce(validMedia);

                    System.out.println(
                            "Media: " + media
                    );

                    break;

                case 6:

                    DLinkedList validAbove =
                            Operation.filterRemoveNonGraded(
                                    converted
                            );

                    float mediaAbove =
                            Operation.reduce(validAbove);

                    DLinkedList above =
                            Operation.filterRemoveBelowAverage(
                                    validAbove,
                                    mediaAbove
                            );

                    System.out.println(above);

                    break;

                case 7:

                    String result =
                            Operation.mapToString(converted);

                    System.out.println(result);

                    break;

                case 8:

                    System.out.println(
                            "Sistema encerrado."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcao invalida."
                    );
            }
        }

        scanner.close();
    }
}