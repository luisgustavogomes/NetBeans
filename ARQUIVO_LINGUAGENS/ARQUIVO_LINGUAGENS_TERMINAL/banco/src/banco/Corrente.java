package banco;

public class Corrente extends Conta {

    private final double limite;

    public Corrente(String agencia, String contaCorrente, String senha) {
        super(agencia, contaCorrente, senha);
        this.limite = 250;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Corrente{" + "limite=" + limite + '}';
    }

    @Override
    public String saldoConta() {
        return "\nSaldo: " + this.getSaldo() + "\nLimite:  " + limite;
    }
    
    @Override
    public boolean saqueConta(double valorSaque) {
        if ((this.getSaldo() + this.getLimite()) >= valorSaque) {
            this.setSaldo(this.getSaldo() - valorSaque);
            return true;
        }
        return false;
    }
}
