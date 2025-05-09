import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArvoreBinariaBusca {

    private static final int ESPACO_IMPRESSAO = 4;
    No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public List<Contato> listarContatosOrdemAlfabetica() {
        List<Contato> lista = new ArrayList<>();
        adicionarContatosLista(raiz, lista);
        Collections.sort(lista, (c1, c2) -> {
            String nome1 = c1.nome.replaceAll("\\D", ""); // Remove letras e mantém números
            String nome2 = c2.nome.replaceAll("\\D", "");
    
            if (!nome1.isEmpty() && !nome2.isEmpty()) {
                return Integer.compare(Integer.parseInt(nome1), Integer.parseInt(nome2));
            }
    
            return c1.nome.compareToIgnoreCase(c2.nome);
        });
    
        return lista;
    }

    private void adicionarContatosLista(No atual, List<Contato> lista) {
        if (atual != null) {
            adicionarContatosLista(atual.esquerdo, lista); 
            lista.add(atual.dado); 
            adicionarContatosLista(atual.direito, lista); 
        }
    }


    public void inserir(Contato valorNovo) {
        if (estaVazia()) {
            raiz = new No(valorNovo);
            return;
        }

        No atual = raiz;
        No pai = null;

        // Percorre a árvore até encontrar a posição de inserção
        while (atual != null) {
            pai = atual;
            if (valorNovo.codigo < atual.dado.codigo) {
                atual = atual.esquerdo;
            } else if (valorNovo.codigo > atual.dado.codigo) {
                atual = atual.direito;
            } else {
                return; // Valor já existe, ignora
            }
        }

        // Após encontrar a posição (atual == null), insere o novo nó
        No novoNo = new No(valorNovo);
        if (valorNovo.codigo < pai.dado.codigo) {
            pai.esquerdo = novoNo;
        } else {
            pai.direito = novoNo;
        }
    }

    public No buscar(int codigo) {
        No atual = raiz;
        
        while (atual != null) {
            if (codigo == atual.dado.codigo)
                return atual;
            else if (codigo < atual.dado.codigo)
                atual = atual.esquerdo;
            else
                atual = atual.direito;
        }
        return null;
    }

    public boolean existe(int valor) {
        return (buscar(valor) != null);
    }

    public boolean codigoExiste(int codigo) {
        return buscar(codigo) != null;
    }
    
    public void remover(int valorRemover) {

        if (estaVazia()) {
            return;
        }

        No atual = raiz;
        No pai = null;

        // Encontrar o nó a ser removido e seu pai
        while (atual != null && atual.dado.codigo != valorRemover) {
            pai = atual;
            if (valorRemover < atual.dado.codigo) {
                atual = atual.esquerdo;
            } else {
                atual = atual.direito;
            }
        }

        // Se o nó não foi encontrado, retorna
        if (atual == null) {
            return;
        }

        // Caso 1 e 2: Nó sem filhos ou com apenas um filho
        if (atual.esquerdo == null || atual.direito == null) {
            No filho;
            if (atual.esquerdo != null) {
                filho = atual.esquerdo;
            } else {
                filho = atual.direito;
            }
            // Se o nó a ser removido é a raiz
            if (pai == null) {
                raiz = filho;
            } else {
                // Conecta o pai ao filho do nó removido
                if (atual == pai.esquerdo) {
                    pai.esquerdo = filho;
                } else {
                    pai.direito = filho;
                }
            }
        }
        // Caso 3: Nó com dois filhos
        else {
            // Encontrar o sucessor (menor valor da subárvore direita)
            No paiSucessor = atual;
            No sucessor = atual.direito;
            
            while (sucessor.esquerdo != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerdo;
            }

            // Copiar o valor do sucessor para o nó atual
            atual.dado = sucessor.dado;

            // Remover o sucessor (que tem no máximo um filho direito)
            if (paiSucessor == atual) {
                paiSucessor.direito = sucessor.direito;
            } else {
                paiSucessor.esquerdo = sucessor.direito;
            }
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(atual.esquerdo) + contarNosRecursivo(atual.direito);
    }

    public int calcularAlturaArvore() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = calcularAlturaRecursivo(atual.esquerdo);
        int alturaDireita = calcularAlturaRecursivo(atual.direito);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int calcularAlturaNo(int valor) {
        No no = buscar(valor);
        if (no == null) {
            return -1;
        }
        return calcularAlturaRecursivo(no);
    }

    public int calcularProfundidadeArvore() {
        return calcularAlturaArvore();
    }

    public int calcularProfundidadeNo(int valor) {
        return calcularProfundidadeRecursivo(raiz, valor, 0);
    }

    private int calcularProfundidadeRecursivo(No atual, int valor, int profundidade) {
        if (atual == null) {
            return -1;
        }
        if (atual.dado.codigo == valor) {
            return profundidade;
        }
        if (valor < atual.dado.codigo) {
            return calcularProfundidadeRecursivo(atual.esquerdo, valor, profundidade + 1);
        }
        return calcularProfundidadeRecursivo(atual.direito, valor, profundidade + 1);
    }

    private int contarFolhasRecursivo(No node) {
        if (node == null)
            return 0;

        // Se o nó não tem filhos, é uma folha
        if (node.esquerdo == null && node.direito == null)
            return 1;

        // Recursivamente conta folhas na subárvore esquerda e direita
        return contarFolhasRecursivo(node.esquerdo) + contarFolhasRecursivo(node.direito);
    }

    public int contarFolhas() {
        return contarFolhasRecursivo(raiz);
    }

    public String imprimirPreOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPreOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length()); // Remove a última vírgula e espaço
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPreOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            sb.append(atual.dado).append(", ");
            imprimirPreOrdemRecursivo(atual.esquerdo, sb);
            imprimirPreOrdemRecursivo(atual.direito, sb);
        }
    }

    public String imprimirPosOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPosOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPosOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirPosOrdemRecursivo(atual.esquerdo, sb);
            imprimirPosOrdemRecursivo(atual.direito, sb);
            sb.append(atual.dado).append(", ");
        }
    }

    public String imprimirInOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirInOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirInOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirInOrdemRecursivo(atual.esquerdo, sb);
            sb.append(atual.dado).append(", ");
            imprimirInOrdemRecursivo(atual.direito, sb);
        }
    }

    public void imprimirArvoreTexto() {
        if (estaVazia()) {
            System.out.println("Árvore vazia");
        } else {
            imprimirArvoreTextoRecursivo(raiz, 0);
        }
    }

    private void imprimirArvoreTextoRecursivo(No atual, int espaco) {
        if (atual == null) {
            return;
        }
        espaco += ESPACO_IMPRESSAO;
        imprimirArvoreTextoRecursivo(atual.direito, espaco);

        System.out.print("\n");
        for (int i = 4; i < espaco; i++) {
            System.out.print(" ");
        }
        System.out.print(atual.dado + "\n");

        imprimirArvoreTextoRecursivo(atual.esquerdo, espaco);

    }

}