import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }



    public Cliente criarCliente(String nome, int cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarCliente(int cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        return null;
    }

    public Conta criarConta(Cliente cliente, String tipo) {
        int numero = contas.size() + 1;

        Conta conta;

        if (tipo.equalsIgnoreCase("Poupanca") || tipo.equalsIgnoreCase("Poupança")) {
            conta = new ContaPoupanca(numero, 0, cliente.getNome(), 2.0);
        } else {
            conta = new Conta(numero, 0, cliente.getNome());
        }

        contas.add(conta);
        cliente.adicionarConta(conta);

        return conta;
    }

    public Conta encontrarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumeroDaConta() == numero) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void transferir(int origem, int destino, double valor) {
        Conta contaOrigem = encontrarConta(origem);
        Conta contaDestino = encontrarConta(destino);

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta origem ou conta destino não encontrada.");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor de transferência inválido.");
            return;
        }

        if (contaOrigem.getSaldo() < valor) {
            System.out.println("Saldo insuficiente para transferência.");
            return;
        }

        contaOrigem.retirarDinheiro(valor);
        contaDestino.depositarDinheiro(valor);

        System.out.println("Transferência efetuada com sucesso!");
    }
}