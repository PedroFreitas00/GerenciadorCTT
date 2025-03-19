import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GerarCSV {
    public static void gerarArquivoCSV(String nomeArquivo) {
        List<Integer> codigos = new ArrayList<>();
        Random random = new Random();

        // Preenche a lista com números de 1 a 50000
        for (int i = 1; i <= 50000; i++) {
            codigos.add(i);
        }

        // Embaralha os códigos para que fiquem aleatórios
        Collections.shuffle(codigos, random);

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.append("Codigo,Nome,Telefone\n"); // Escreve o cabeçalho

            for (int i = 0; i < 50000; i++) {
                int codigo = codigos.get(i); // Pega um código único da lista embaralhada
                String nome = "Contato" + (i + 1); // Nome fictício
                String telefone = "(11) 9" + (10000000 + random.nextInt(90000000)); // Telefone fictício

                writer.append(codigo + "," + nome + "," + telefone + "\n"); // Escreve no arquivo CSV
            }

            System.out.println("Arquivo CSV gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV.");
            e.printStackTrace();
        }
    }
}
