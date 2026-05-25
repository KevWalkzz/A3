public class Conta {
    private int numeroDaConta;
    private double saldo;
    private String dono;

    public Conta(int numeroDaConta, double saldo, String dono) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.dono = dono;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDono() {
        return dono;
    }

    public void listarDados() {
        System.out.println("Número da conta: " + getNumeroDaConta());
    }

}
