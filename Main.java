import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao;

        do {
            System.out.println("\n======= MENU =======");
            System.out.println("1 - Criar cliente");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Listar Contas");
            System.out.println("0 - Sair");

            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    criarCliente(scanner, banco);
                }
                case 2 -> {
                    criarConta(scanner, banco);
                }
                case 3 -> {
                    depositar(scanner, banco);
                }
                case 4 -> {
                    sacar(scanner, banco);
                }
                case 5 -> {
                    transferir(scanner, banco);
                }
                case 6 -> {
                    listarContas(banco);
                }
            }
        } while (opcao != 0);

        scanner.close(); // Evitar inputs depois do programa sair
        
    }

    public static void criarCliente(Scanner scanner, Banco banco) {
        scanner.nextLine(); // Limpar buffer

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("CPF: ");
        int cpf = scanner.nextInt();

        banco.criarCliente(nome, cpf);

        System.out.println("Cliente criado!");
    }

    public static void criarConta(Scanner scanner, Banco banco) {
        System.out.println("CPF do cliente: ");
        int cpf = scanner.nextInt();

        Cliente cliente = banco.buscarCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        scanner.nextLine(); // Limpar buffer de novo, vai que né...
        System.out.print("Tipo (corrente/poupança): ");
        String tipo = scanner.nextLine();

        banco.criarConta(cliente, tipo);

        System.out.println("Conta criada!");
    }

    public static void depositar(Scanner scanner, Banco banco) {
        System.out.println("Número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = banco.encontrarConta(numero);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();

        conta.depositarDinheiro(valor);
    }

    public static void sacar(Scanner scanner, Banco banco) {
        System.out.println("Número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = banco.encontrarConta(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();

        conta.retirarDinheiro(valor);
    }

    public static void transferir(Scanner scanner, Banco banco) {
        System.out.println("Conta origem: ");
        int origem = scanner.nextInt();

        System.out.println("Conta destino: ");
        int destino = scanner.nextInt();

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();

        banco.transferir(origem, destino, valor);
    }

    public static void listarContas(Banco banco) {
        for (Conta c : banco.getContas()) {
            c.listarDados();
            System.out.println("----------------------");
        }
    }
}
