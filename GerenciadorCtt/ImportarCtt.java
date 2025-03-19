import java.io.BufferedReader;
import java.io.FileReader;


public class ImportarCtt {
    public static void importarContatos(ArvoreBinariaBusca arvore){
        String nomeArquivo = "contatos.csv";
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
            

            if(dados.length == 3){
                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String telefone = dados[2];

                Contato contato = new Contato(codigo, nome, telefone);
                arvore.inserir(contato);
            }
        }
        System.out.println("Importação concluida com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao importar o arquivo CVS.");
            e.printStackTrace();
        }
    }
}
