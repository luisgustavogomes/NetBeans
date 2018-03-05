package aula05;


public final class Conta {

    public int numconta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public Conta() {
        this.setStatus(false);
        this.setSaldo(0);
    }

    public void estadoAtual() {
        System.out.println("-------------------------------------------------");
        System.out.println("Conta:" + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public int getNumConta() {
        return this.numconta;
    }

    public void setNumConta(int numconta) {
        this.numconta = numconta;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String tipoconta) {
        this.setTipo(tipoconta);
        this.setStatus(true);
        if (tipoconta == "CC") {
            this.setSaldo(50);
        } else if (tipoconta == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso");

    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta com saldo");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta com saldo negativo");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }
    }

    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado de " + this.getDono());
        } else {
            System.out.println("Erro");
        }

    }

    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo Insuficiente");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada");
        }

    }

    public void pagarmMensal() {
        double valor = 0;
        if (this.getTipo() == "CC") {
            valor = 12;
        } else if (this.getTipo() == "CP") {
            valor = 20;
        }
        if (this.getStatus()) {
            if (this.getSaldo() > valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Mensalidade paga com sucesso por " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Impossível Pagar");
        }
    }
}
