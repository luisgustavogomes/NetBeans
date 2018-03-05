package banco;

public class Poupanca extends Conta {

    protected double rendimento;

    public Poupanca(String agencia, String contaCorrente, String senha) {
        super(agencia, contaCorrente, senha);
        this.rendimento = RENDIMENTOINICIALPOUPANCA;
    }

    public double getRendimento() {
        return rendimento;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Poupanca{" + "rendimento=" + rendimento + '}';
    }
    
    @Override
    public String saldoConta(){
        return "\nSaldo: " + this.getSaldo() + "\nRendimento: " + rendimento;
    }
    
    @Override
    public boolean depositoConta( double valorDeposito) {
        if (valorDeposito > 0) {
            this.setSaldo(this.getSaldo() + valorDeposito);
            if  (this.getRendimento() > 0) {
                this.setSaldo(this.getSaldo() + this.getSaldo() * this.getRendimento());
            }
            return true;
        }
        return false;
    }
}
