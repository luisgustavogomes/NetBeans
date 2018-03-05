package banco;

import java.util.Objects;

public abstract class Conta {

    private String agencia;
    private String contaCorrente;
    private String senha;
    private double saldo;
    protected static final double LIMITEINICIALCONTASALARIO  = 0;
    protected static final double LIMITEINICIALCRRENTISTA  = 250;
    protected static final double SALDOINICIAL=0;
    protected static final double RENDIMENTOINICIALPOUPANCA=0.7;
    protected static final double RENDIMENTOINICIALINVESTIMENTO=0;
    protected static final double CPMF = 0.1;

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
        this.saldo = SALDOINICIAL;
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
            this.setSaldo(this.getSaldo() - valorSaque - cpmf(valorSaque));
            return true;
        }
        return false;
    }

    public boolean verificadorTransferencia(Conta contaDestino) {
        return this.contaCorrente != contaDestino.contaCorrente;
    }

    private double cpmf(double valorSaque) {
        return valorSaque * CPMF;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.agencia);
        hash = 79 * hash + Objects.hashCode(this.contaCorrente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        return Objects.equals(this.contaCorrente, other.contaCorrente);
    }
    
}
