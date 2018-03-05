package banco;

public abstract class Conta {

    private String agencia;
    private String contaCorrente;
    private String senha;
    private double saldo;

    public String getAgencia() {
        return agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(String agencia, String contaCorrente, String senha) {
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.senha = senha;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return "Conta{" + "agencia=" + agencia + ", contaCorrente=" + contaCorrente + ", senha=" + senha + ", saldo=" + saldo + '}';
    }

    public abstract String saldoConta();

    public boolean depositoConta(double valorDeposito) {
        if (valorDeposito > 0) {
            this.setSaldo(this.getSaldo() + valorDeposito);
            return true;
        }
        return false;
    }

    public boolean saqueConta(double valorSaque) {
        if (this.getSaldo() >= valorSaque) {
            this.setSaldo(this.getSaldo() - valorSaque);
            return true;
        }
        return false;
    }

    public boolean verificadorTransferencia(Conta contaDestino) {
        return this.contaCorrente != contaDestino.contaCorrente;
    }
    
    

}
