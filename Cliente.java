import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int cpf;
    private ArrayList<Conta> contas;

    public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void adicionarConta(Conta contaParaAdicionar) {
        contas.add(contaParaAdicionar);
    }

}