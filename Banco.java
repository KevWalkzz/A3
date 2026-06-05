import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;
    private int proximoNumero = 1;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public Cliente criarCliente(String nome, int cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        return cliente;
    }

    public Conta criarConta(Cliente cliente, String tipo) {
        int numero = proximoNumero++;

        Conta conta;

        if (tipo.equalsIgnoreCase("Poupanca") || tipo.equalsIgnoreCase("Poupança")) {
            conta = new ContaPoupanca(numero, 0, cliente, 2.0);
        } else {
            conta = new Conta(numero, 0, cliente);
        }

        contas.add(conta);
        cliente.adicionarConta(conta);

        return conta;
    }

    public Cliente buscarCliente(int cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        return null;
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

        System.out.println("----------------------");
        System.out.println("Conta Originária");
        contaOrigem.retirarDinheiro(valor);
        System.out.println("----------------------");
        System.out.println("Conta Destinatária");
        contaDestino.depositarDinheiro(valor);
        System.out.println("----------------------");

        System.out.println("Transferência efetuada com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println("----------------------");
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());

            if (c.getContas().isEmpty()) {
                System.out.println("Contas: Nenhuma.");
            } else {
                System.out.println("Contas:");
                for (Conta conta : c.getContas()) {
                    System.out.println(" - Conta Nº: " + conta.getNumeroDaConta());
                }
            }

            System.out.println("----------------------");
        }
    }
}