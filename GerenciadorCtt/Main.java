import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n-----------Menu-----------");
            System.out.println("1- Adicionar um novo contato");
            System.out.println("2- Pesquisar por um contato pelo código");
            System.out.println("3- Listar todos os contatos em ordem alfabética");
            System.out.println("4- Remover um contato por código");
            System.out.println("5- Importar CSV");
            System.out.println("6- Exibir Estatisticas");
            System.out.println("7- Sair do programa\n");
            System.out.print("Digite uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("\nDigite o código do numero: ");
                    int codigo = scanner.nextInt();
                    
                    if(arvore.existe(codigo)){
                        System.out.print("Erro código já registrado, escolha outro");
                    }else{
                        scanner.nextLine();
    
                        System.out.print("Qual o nome do contato: ");
                        String nome = scanner.nextLine();
        
                        System.out.print("Digite o telefone: ");
                        String telefone = scanner.nextLine();
        
                        Contato contato = new Contato(codigo, nome, telefone);
        
                        arvore.inserir(contato);
                        
                        System.out.println("\nContato adicionado com sucesso!");
                    }
                    
    
                break;
    
                case 2:
                    System.out.print("\nDigite o código a ser buscado: ");
                    int codigoBuscado = scanner.nextInt();
                    System.out.println("");
                    No noRetornado = arvore.buscar(codigoBuscado);
                    System.out.println(noRetornado.dado.codigo + " - " + noRetornado.dado.nome);
                    System.out.println("");
                break;
    
                case 3: 
                    System.out.println("adicione um contato, composto por código (inteiro único), nome e número de telefone");
                break;
    
                case 4:
                    System.out.println("adicione um contato, composto por código (inteiro único), nome e número de telefone");
                break;
    
                case 5:
                    System.out.println("Gerando arquivo CSV...");
                    GerarCSV.gerarArquivoCSV("contatos.csv");
                    System.out.println("Importando contatos...");
                    ImportarCtt.importarContatos(arvore);
                break;
    
                case 6:
                    System.out.println("adicione um contato, composto por código (inteiro único), nome e número de telefone");
                break;
    
                case 7: 
                    System.out.println("Saindo do progama...");
                    scanner.close();
                break;

                default:
                    System.out.println("Opcao inválida!");
                break;
           }
        } while (opcao != 7); 
    }   
}