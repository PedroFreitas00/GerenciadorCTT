public class Contato {
    int codigo;
    String nome;
    String numeroTelefone;

    public Contato(int codigo, String nome, String numeroTelefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "Contato [codigo=" + codigo + ", nome=" + nome + ", numeroTelefone=" + numeroTelefone + "]";
    }
       
}
