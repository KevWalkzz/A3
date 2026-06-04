public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Keven", 1323123120);

        Conta conta1 = new Conta(1, 1000, "Keven");
        Conta conta2 = new Conta(2, 2000, "Keven");

        cliente.adicionarConta(conta1);
        cliente.adicionarConta(conta2);

        for (Conta c : cliente.getContas()) {
            System.out.println("Conta: " + c.getNumeroDaConta());
            System.out.println("Saldo: " + c.getSaldo());
        }
    }
}
