public class Cliente extends Conta {
    private String nome;
    private int cpf;
    private String[] contas;

    public Cliente(String nome, int cpf, String[] contas, int numeroDaConta, double saldo, String dono) {
        super(numeroDaConta, saldo, dono);
        this.nome = nome;
        this.cpf = cpf;
        this.contas = contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setContas(String[] contas) {
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String[] getContas() {
        return contas;
    }

    public void adicionarConta(String conta) {
    }

}