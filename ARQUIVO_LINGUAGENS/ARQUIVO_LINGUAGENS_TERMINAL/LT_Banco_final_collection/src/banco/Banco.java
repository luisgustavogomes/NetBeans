package banco;

import java.util.ArrayList;

public class Banco {

    static Usuario admin = new Usuario();
    static Conta contaLogada;
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayList<Conta> contas = new ArrayList<>();

    public boolean verificarLoginUsuario(String login, String senha) {
        if (login.equalsIgnoreCase(admin.getLogin()) && senha.equalsIgnoreCase(admin.getSenha())) {
            return true;
        } else {            
            for (int i = 0; i < usuarios.size(); i++) {
                if (login.equalsIgnoreCase(usuarios.get(i).getLogin()) && senha.equalsIgnoreCase(usuarios.get(i).getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarLoginCliente(String agencia, String conta, String senha) {
        for (int i = 0; i < contas.size(); i++) {
            if (agencia.equalsIgnoreCase(contas.get(i).getAgencia())
                    && conta.equalsIgnoreCase(contas.get(i).getContaCorrente()) && senha.equalsIgnoreCase(contas.get(i).getSenha())) {
                return true;
            }
        }
        return false;
    }

    public final boolean cadastroCliente(int controladorTipoConta, String agencia, String conta, String senha) {
        if (!verificarExistenciaCliente(agencia, conta)) {
            switch (controladorTipoConta) {
                case 1:
                    Corrente contaCorrente = new Corrente(agencia, conta, senha);
                    contas.add(contaCorrente);
                    return true;
                case 2:
                    Poupanca contaPoupanca = new Poupanca(agencia, conta, senha);
                    contas.add(contaPoupanca);
                    return true;
                case 3:
                    Salario contaSalario = new Salario(agencia, conta, senha);
                    contas.add(contaSalario);
                    return true;
                case 4:
                    Investimento contaInvestimento = new Investimento(agencia, conta, senha);
                    contas.add(contaInvestimento);
                    return true;
            }
        }
        return false;
        }

    public boolean excluirCliente(String agencia, String conta) {
        return contas.removeIf(c -> c.getAgencia().equals(agencia) && c.getContaCorrente().equals(conta));
    }

    private boolean verificarExistenciaCliente(String agencia, String conta) {
        int indice = verificaIndiceContas(agencia, conta);
        return indice >= 0;
    }

    private int verificaIndiceContas(String agencia, String conta) {
        for (int i = 0; i < contas.size(); i++) {
            if (agencia.equalsIgnoreCase(contas.get(i).getAgencia())
                    && conta.equalsIgnoreCase(contas.get(i).getContaCorrente())) {
                return i;
            }
        }
        return -1;
    }

    public Conta contaCliente() {
        int indice = verificaIndiceContas(contaLogada.getAgencia(), contaLogada.getContaCorrente());
        contaLogada = contas.get(indice);
        return contaLogada;
    }

    public String saldoContaCliente() {
        return contaLogada.saldoConta();
    }

    public boolean depositoContaCliente(double valorDeposito) {
        return contaLogada.depositoConta(valorDeposito);
    }

    public boolean saqueContaCliente(double valorSaque) {
        return contaLogada.saqueConta(valorSaque);
    }

    public boolean transferenciaContacliente(double valorTransferencia, String agenciaDestino, String contaDestino) {
        if (contaLogada.getClass() != Salario.class) {
            if (verificarExistenciaCliente(agenciaDestino, contaDestino)) {
                int indice = verificaIndiceContas(agenciaDestino, contaDestino);
                Conta contaCorrenteDestino = contas.get(indice);
                if (contaLogada.verificadorTransferencia(contaCorrenteDestino)) {
                    boolean statusSaqueConta = contaLogada.saqueConta(valorTransferencia);
                    boolean statusDepositoConta = contaCorrenteDestino.depositoConta(valorTransferencia);
                    return statusDepositoConta && statusSaqueConta;
                }
                return false;
            }
        }
        return false;
    }

    boolean alterarLimiteCliente(String agencia, String conta, double valor) {
        int indice = verificaIndiceContas(agencia, conta);
        if (contas.get(indice).getClass() == Corrente.class && indice >= 0) {
            Corrente contaLimite = (Corrente) contas.get(indice);
            return contaLimite.alterarLimite(valor);
        }
        return false;

    }

    boolean alterarRendimentoCliente(String agencia, String conta, double valor) {
        int indice = verificaIndiceContas(agencia, conta);
        if (contas.get(indice).getClass() == Investimento.class && indice >= 0) {
            Investimento contaInvestimento = (Investimento) contas.get(indice);
            return contaInvestimento.alteraInvestimento(valor);
        }
        return false;

    }

}
