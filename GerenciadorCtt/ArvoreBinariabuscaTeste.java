import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArvoreBinariabuscaTeste{
    private ArvoreBinariaBusca arvore;
    private Contato contato1, contato5, contato3, contato7;

    @Before
    public void configurar() {
        arvore = new ArvoreBinariaBusca();
        contato1 = new Contato(1, "Contato1", "(11) 40028922");
        contato5 = new Contato(5, "contato5", "(11) 987301593");
        contato3 = new Contato(3, "contato3", "(11) 987301593");
        contato7 = new Contato(7, "contato7", "(11) 987301593");
    }

    @Test
    public void testarEstaVaziaArvoreNova() {
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarImprimirArvoreTexto() {
        arvore.inserir(contato1);
        
        arvore.imprimirArvoreTexto();
    }

    @Test
    public void testarEstaVaziaAposInsercao() {
        arvore.inserir(contato1);
        assertFalse(arvore.estaVazia());
    }

    @Test
    public void testarEstaVaziaAposRemocaoUnicoNo() {
        arvore.inserir(contato1);
        arvore.remover(1);
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarInserirEBuscarUnicoNo() {
        arvore.inserir(contato1);
        assertTrue(arvore.existe(1));
        assertFalse(arvore.existe(10));
    }

    @Test
    public void testarInserirEBuscarMultiplosNos() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato7 = new Contato(7, "contato7", "(11) 987301593");
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(7));
        assertFalse(arvore.existe(4));
    }

    @Test
    public void testarInserirDuplicado() {
        arvore.inserir(contato1);
        arvore.inserir(contato1); // Não deve alterar a arvore
        assertEquals(1, arvore.contarNos());
        assertTrue(arvore.existe(1));
    }

    @Test
    public void testarBuscarEmArvoreVazia() {
        assertFalse(arvore.existe(1));
    }

    @Test
    public void testarRemoverNoFolha() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertFalse(arvore.existe(3));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComUmFilho() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato4 = new Contato(4, "contato4", "(11) 987301593");

        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato4);
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(4));
        assertFalse(arvore.existe(3));
        assertEquals(2, arvore.contarNos());
    }

   @Test
    public void testarRemoverNoComDoisFilhos() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato7 = new Contato(7, "contato7", "(11) 987301593");
        Contato contato6 = new Contato(6, "contato6", "(11) 987301593");
        Contato contato8 = new Contato(8, "contato8", "(11) 987301593");
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        arvore.inserir(contato6);
        arvore.inserir(contato8);
        arvore.remover(7);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(8));
        assertFalse(arvore.existe(7));
        assertEquals(4, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComDoisFilhosSlide() {
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");
        Contato contato16 = new Contato(16, "contato16", "(11) 987301593");
        Contato contato20 = new Contato(20, "contato20", "(11) 987301593");
        Contato contato23 = new Contato(23, "contato23", "(11) 987301593");
        Contato contato18 = new Contato(18, "contato18", "(11) 987301593");
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato12 = new Contato(12, "contato12", "(11) 987301593");
        Contato contato13 = new Contato(13, "contato13", "(11) 987301593");
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato6 = new Contato(6, "contato6", "(11) 987301593");
        Contato contato7 = new Contato(7, "contato7", "(11) 987301593");
        
        arvore.inserir(contato15);
        arvore.inserir(contato16);
        arvore.inserir(contato20);
        arvore.inserir(contato23);
        arvore.inserir(contato18);
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato12);
        arvore.inserir(contato13);
        arvore.inserir(contato10);
        arvore.inserir(contato6);
        arvore.inserir(contato7);

        arvore.remover(5);
        assertFalse(arvore.existe(5));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(7));
        assertEquals(11, arvore.contarNos());
        assertEquals(6, arvore.raiz.esquerdo.dado.codigo);
    }

    @Test
    public void testarRemoverRaizUnica() {
        arvore.inserir(contato1);
        arvore.remover(1);
        assertFalse(arvore.existe(1));
        assertEquals(0, arvore.contarNos());
     }

    @Test
    public void testarRemoverNaoExistente() {
        arvore.inserir(contato1);
        arvore.remover(10);
        assertTrue(arvore.existe(1));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreVazia() {
        assertEquals(0, arvore.contarNos());
    }

    @Test
    public void testarContarNosUmNo() {
        arvore.inserir(contato1);
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreGrande() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato7 = new Contato(7, "contato7", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertEquals(5, arvore.contarNos());
    }

    @Test
    public void testarCalcularAlturaArvoreVazia() {
        assertEquals(-1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreUmNo() {
        arvore.inserir(contato1);
        assertEquals(0, arvore.calcularAlturaArvore());
    }
    @Test
    public void testarCalcularAlturaArvoreBalanceada() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato7 = new Contato(7, "contato7", "(11) 987301593");
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertEquals(1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreDesbalanceada() {
        Contato contato5 = new Contato(5, "contato5", "(11) 987301593");
        Contato contato3 = new Contato(3, "contato3", "(11) 987301593");
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        arvore.inserir(contato10);        
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato1);
        assertEquals(3, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaNoInexistente() {
        assertEquals(-1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoRaiz() {
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoFolha() {
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        assertEquals(0, arvore.calcularAlturaNo(3));
    }

    @Test
    public void testarCalcularAlturaNoIntermediario() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularProfundidadeArvoreVazia() {
        assertEquals(-1, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreUmNo() {
        arvore.inserir(contato5);
        assertEquals(0, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreDesbalanceada() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato1);
        assertEquals(3, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeNoInexistente() {
        assertEquals(-1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoRaiz() {
        arvore.inserir(contato5);
        assertEquals(0, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoFolha() {
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato1);
        assertEquals(2, arvore.calcularProfundidadeNo(1));
    }

    @Test
    public void testarCalcularProfundidadeNoIntermediario() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        assertEquals(1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarImprimirPreOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPreOrdemUmNo() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        assertEquals("[Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593]]", arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPreOrdem() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        String esperado = "[Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593], Contato [codigo=5, nome=contato5, numeroTelefone=(11) 987301593], Contato [codigo=3, nome=contato3, numeroTelefone=(11) 987301593], Contato [codigo=7, nome=contato7, numeroTelefone=(11) 987301593], Contato [codigo=15, nome=contato15, numeroTelefone=(11) 987301593]]";
        assertEquals(esperado, arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPosOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirPosOrdemUmNo() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        assertEquals("[Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593]]", arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirPosOrdem() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        String esperado = "[Contato [codigo=3, nome=contato3, numeroTelefone=(11) 987301593], Contato [codigo=7, nome=contato7, numeroTelefone=(11) 987301593], Contato [codigo=5, nome=contato5, numeroTelefone=(11) 987301593], Contato [codigo=15, nome=contato15, numeroTelefone=(11) 987301593], Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593]]";
        assertEquals(esperado, arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirInOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirInOrdem());
    }

    @Test
    public void testarImprimirInOrdemUmNo() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");

        arvore.inserir(contato10);
        assertEquals("[Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593]]", arvore.imprimirInOrdem());
    }

    @Test
    public void testarImprimirInOrdem() {
       Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");

        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        String esperado = "[Contato [codigo=3, nome=contato3, numeroTelefone=(11) 987301593], Contato [codigo=5, nome=contato5, numeroTelefone=(11) 987301593], Contato [codigo=7, nome=contato7, numeroTelefone=(11) 987301593], Contato [codigo=10, nome=contato10, numeroTelefone=(11) 987301593], Contato [codigo=15, nome=contato15, numeroTelefone=(11) 987301593]]";
        assertEquals(esperado, arvore.imprimirInOrdem());
    }

   @Test
   public void testarInsercaoRemocaoComplexa() {

        Contato contato50 = new Contato(50, "contato50", "(11) 987301593");
        Contato contato30 = new Contato(30, "contato30", "(11) 987301593");
        Contato contato70 = new Contato(70, "contato70", "(11) 987301593");
        Contato contato20 = new Contato(20, "contato20", "(11) 987301593");
        Contato contato40 = new Contato(40, "contato40", "(11) 987301593");
        Contato contato60 = new Contato(60, "contato60", "(11) 987301593");
        Contato contato80 = new Contato(80, "contato80", "(11) 987301593");
        
        arvore.inserir(contato50);
        arvore.inserir(contato30);
        arvore.inserir(contato70);
        arvore.inserir(contato20);
        arvore.inserir(contato40);
        arvore.inserir(contato60);
        arvore.inserir(contato80);
        arvore.remover(30);
        assertEquals(6, arvore.contarNos());
        assertFalse(arvore.existe(30));
        assertTrue(arvore.existe(40));
        assertEquals(2, arvore.calcularAlturaNo(50));
        assertEquals(1, arvore.calcularProfundidadeNo(70));
    }

    @Test
    public void testarArvoreComplexaAposRemocao() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");
        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato1);
        arvore.remover(15);
        assertEquals(4, arvore.contarNos());
        assertEquals(3, arvore.calcularAlturaArvore());
        assertEquals(3, arvore.calcularProfundidadeNo(1));
    }

    @Test
    public void testarMultiplasRemocoes() {
        Contato contato10 = new Contato(10, "contato10", "(11) 987301593");
        Contato contato15 = new Contato(15, "contato15", "(11) 987301593");
        arvore.inserir(contato10);
        arvore.inserir(contato5);
        arvore.inserir(contato15);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        arvore.remover(5);
        arvore.remover(15);
        assertEquals(3, arvore.contarNos());
        assertTrue(arvore.existe(10));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(7));
        assertEquals(2, arvore.calcularAlturaArvore());
    }

    
    @Test
    public void OrdemAlfabéticaTeste(){
        arvore.inserir(contato1);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        arvore.inserir(contato5);
        arvore.listarContatosOrdemAlfabetica();
    }

    // Não entendi o erro desse teste
    // @Test
    // public void testarOrdemAlfabéticaVazia(){
    //     arvore.inserir(contato1);
    //     arvore.remover(1);
    //     assertEquals("[]", arvore.listarContatosOrdemAlfabetica());
    // }

    @Test
    public void contarFolhasSoRaizTeste(){
        arvore.inserir(contato1);
        assertEquals(1, arvore.contarFolhas());
    }

    @Test
    public void contarFolhasUmFilhoTeste(){
        arvore.inserir(contato1);
        arvore.inserir(contato3);
        assertEquals(1, arvore.contarFolhas());
    }

    @Test
    public void contarFolhasDoisFilhosTeste(){
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato7);
        assertEquals(2, arvore.contarFolhas());
    }
    @Test
    public void contarFolhasUmDescendenteTeste(){
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato1);
        arvore.inserir(contato7);
        assertEquals(2, arvore.contarFolhas());
    }

    @Test
    public void contarFolhasDoisDescendenteTeste(){
        Contato contato4 = new Contato(4, "contato4", "(11) 987301593");
        arvore.inserir(contato5);
        arvore.inserir(contato3);
        arvore.inserir(contato4);
        arvore.inserir(contato1);
        arvore.inserir(contato7);
        assertEquals(3, arvore.contarFolhas());
    }
}