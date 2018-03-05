
package banco;

public class Salario extends Conta{
    private double limite;
    
    public Salario(String agencia, String contaCorrente, String senha) {
        super(agencia, contaCorrente, senha);
        this.limite = 0;
    }

    @Override
    public String saldoConta() {
        return "\nSaldo: " + this.getSaldo();
    }

    @Override
    public String toString() {
        return super.toString() + "Salario{" + "limite=" + limite + '}';
    }
    
}
