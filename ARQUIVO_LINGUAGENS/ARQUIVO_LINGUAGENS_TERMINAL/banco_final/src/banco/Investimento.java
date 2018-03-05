package banco;

public class Investimento extends Poupanca {

    public Investimento(String agencia, String contaCorrente, String senha) {
        super(agencia, contaCorrente, senha);
        this.rendimento = 0;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public boolean alteraInvestimento(double valor) {
        if (valor > 0) {
            this.rendimento = valor;
            return true;
        }
        return false;
    }

    @Override
    public String saldoConta() {
        return "\nSaldo: " + this.getSaldo() + "\nRendimento: " + rendimento;
    }

    @Override
    public String toString() {
        return super.toString() + "Investimento{" + "rendimento=" + rendimento + '}';
    }

}
