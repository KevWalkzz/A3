public class Cliente {
    private String nome;
    private String cpf;
    private String senha;

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public void definirSenha(String senha) {
        this.senha = senha;
    }

    public void definirCpf(String cpf) {
        this.cpf = cpf;
    }

    public void mostrarDados() {
        
    }
}