public class ContaPoupanca extends Conta {
    private double taxaDeInteresse;

    public ContaPoupanca(int numeroDaConta, double saldo, Cliente dono, double taxaDeInteresse) {
        super(numeroDaConta, saldo, dono);
        this.taxaDeInteresse = taxaDeInteresse;
    }

    public void setTaxaDeInteresse(double taxa) {
        this.taxaDeInteresse = taxa;
    }

    public double getTaxaDeInteresse() {
        return this.taxaDeInteresse;
    }

    public void aplicarInteresse() {
        double saldoAtual = getSaldo();

        if (saldoAtual <= 0) {
            System.out.println("Não há saldo para aplicar juros.");
        }

        double taxa = getTaxaDeInteresse();
        double novoSaldo = saldoAtual * (1 + taxa / 100);

        setSaldo(novoSaldo);
        System.out.println("Saldo antes da taxa: " + saldoAtual);
        System.out.println("Saldo após a taxa: " + novoSaldo);
    }

    @Override
    public void listarDados() {
        super.listarDados();
        System.out.println("Taxa de interesse: " + taxaDeInteresse + "%");
    }
}
