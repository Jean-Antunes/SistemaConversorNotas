package apl2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data {

    // Método para ler arquivo texto
    public static String loadTextFileToString(String path)
            throws IOException {

        // Abre arquivo para leitura
        BufferedReader reader =
                new BufferedReader(
                        new FileReader(path)
                );

        String line;

        // Variável que guarda o conteúdo do arquivo
        String content = "";

        // Lê linha por linha
        while ((line = reader.readLine()) != null) {

            // Adiciona linha ao conteúdo
            content += line + "\n";
        }

        // Fecha arquivo
        reader.close();

        // Retorna conteúdo completo
        return content;
    }

    // Método para salvar texto em arquivo
    public static void saveStringToTextFile(
            String path,
            String content
    ) throws IOException {

        // Cria escritor do arquivo
        FileWriter writer = new FileWriter(path);

        // Escreve conteúdo
        writer.write(content);

        // Fecha arquivo
        writer.close();
    }
}