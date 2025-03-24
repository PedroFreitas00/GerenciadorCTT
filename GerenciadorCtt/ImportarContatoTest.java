import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ImportarContatoTest {
    
    @Test
    public void testImportarContatos() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca(); // Criando a árvore binária

        ImportarContato.importarContatos(arvore); // Importa contatos do arquivo CSV para a árvore

        assertNotNull(arvore.buscar(1)); // Supondo que exista um método buscar()
    }

    @Test
    public void testGerarArquivoCSV() {
        String nomeArquivo = "contatos_teste.csv";

        // Chama o método para gerar o arquivo CSV
        GerarCSV.gerarArquivoCSV(nomeArquivo);

        // Cria um objeto File para verificar se o arquivo existe
        File arquivo = new File(nomeArquivo);

        // Verifica se o arquivo foi criado e não está vazio
        assertTrue(arquivo.exists(), "O arquivo CSV não foi criado.");
        assertTrue(arquivo.length() > 0, "O arquivo CSV está vazio.");

        // Opcional: Excluir o arquivo após o teste
        if (arquivo.delete()) {
            System.out.println("Arquivo de teste removido.");
        }
    }

    @Test
    public void testArquivoContemContatosEsperados() {
        String nomeArquivo = "contatos_teste.csv";

        // Chama o método para gerar o arquivo CSV
        GerarCSV.gerarArquivoCSV(nomeArquivo);

        // Cria um objeto File para verificar se o arquivo existe
        File arquivo = new File(nomeArquivo);
        assertTrue(arquivo.exists(), "O arquivo CSV não foi criado.");

        // Conta o número de linhas do arquivo
        int linhas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            while (br.readLine() != null) {
                linhas++;
            }
        } catch (IOException e) {
            fail("Erro ao ler o arquivo CSV.");
        }

        // Esperamos 51 linhas (1 cabeçalho + 50 contatos)
        assertEquals(50001, linhas, "O arquivo CSV não contém todas as linhas esperadas.");

        // Opcional: Excluir o arquivo após o teste
        if (arquivo.delete()) {
            System.out.println("Arquivo de teste removido.");
        }
    }
}

