public class Conta {
    private int numeroDaConta;
    private double saldo;
    private Cliente dono;

    public Conta(int numeroDaConta, double saldo, Cliente dono) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.dono = dono;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Saldo negativo não é permitido.");
            return;
        }

        this.saldo = saldo;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void depositarDinheiro(double quantia) {
        if (quantia <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        double saldoAnterior = saldo;
        saldo += quantia;

        System.out.println("Saldo Anterior: " + saldoAnterior);
        System.out.println("Novo Saldo: " + saldo);
    }

    public void retirarDinheiro(double quantia) {
        if (quantia <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        if (quantia > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        double saldoAnterior = saldo;
        saldo -= quantia;

        System.out.println("Saldo Anterior: " + saldoAnterior);
        System.out.println("Novo Saldo: " + saldo);
    }

    public void listarDados() {
        System.out.println("Número da conta: " + numeroDaConta);
        System.out.println("Saldo: " + saldo);
        System.out.println("Dono: " + dono.getNome());
    }
}
