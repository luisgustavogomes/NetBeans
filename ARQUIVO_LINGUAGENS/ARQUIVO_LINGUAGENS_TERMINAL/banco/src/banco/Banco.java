package banco;

public class Banco {

    static Usuario admin = new Usuario();

    static String clienteLogadoAgencia;
    static String clienteLogadoContaCorrete;
    static Conta contaLogada;
    Usuario usuarios[] = new Usuario[100];
    Conta contas[] = new Conta[100];

    //===================================================================================
    
    public boolean verificarLoginUsuario(String login, String senha) {
        for (int i = 0; i < usuarios.length; i++) {
            if (login.equalsIgnoreCase(admin.getLogin()) && senha.equalsIgnoreCase(admin.getSenha())) {
                return true;
            } else if (usuarios[i] != null && login.equalsIgnoreCase(usuarios[i].getLogin()) && senha.equalsIgnoreCase(usuarios[i].getSenha())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarLoginCliente(String agencia, String conta, String senha) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && agencia.equalsIgnoreCase(contas[i].getAgencia())
                    && conta.equalsIgnoreCase(contas[i].getContaCorrente()) && senha.equalsIgnoreCase(contas[i].getSenha())) {
                return true;
            }
        }
        return false;
    }

    //===================================================================================
    
    public final boolean cadastroCliente(int controladorTipoConta, String agencia, String conta, String senha) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null && !verificarExistenciaCliente(agencia, conta)) {
                switch (controladorTipoConta) {
                    case 1:
                        Corrente contaCorrente = new Corrente(agencia, conta, senha);
                        contas[i] = contaCorrente;
                        return true;
                    case 2:
                        Poupanca contaPoupanca = new Poupanca(agencia, conta, senha);
                        contas[i] = contaPoupanca;
                        return true;
                }
            }
        }
        return false;
    }

    public boolean excluirCliente(String agencia, String conta) {
        int indice = verificaIndiceContas(agencia, conta);
        if (indice >= 0) {
            contas[indice] = null;
            return true;
        }
        return false;
    }

    //===================================================================================
    private boolean verificarExistenciaCliente(String agencia, String conta) {
        int indice = verificaIndiceContas(agencia, conta);
        return indice >= 0;
    }

    private int verificaIndiceContas(String agencia, String conta) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && agencia.equalsIgnoreCase(contas[i].getAgencia())
                    && conta.equalsIgnoreCase(contas[i].getContaCorrente())) {
                return i;
            }
        }
        return -1;
    }

    public Conta contaCliente() {
        int indice = verificaIndiceContas(clienteLogadoAgencia, clienteLogadoContaCorrete);
        contaLogada = contas[indice];
        return contaLogada;
    }

    //===================================================================================
    
    public String saldoContaCliente() {
        return contaLogada.saldoConta();
    }

    public boolean depositoContaCliente(double valorDeposito) {
        return contaLogada.depositoConta( valorDeposito);
    }

    public boolean saqueContaCliente(double valorSaque) {
        return contaLogada.saqueConta( valorSaque);
    }

    public boolean transferenciaContacliente(double valorTransferencia, String agenciaDestino, String contaDestino) {
        if (verificarExistenciaCliente(agenciaDestino, contaDestino)) {
            int indice = verificaIndiceContas(agenciaDestino, contaDestino);
            Conta contaCorrenteDestino = contas[indice];
            if (contaLogada.verificadorTransferencia(contaCorrenteDestino)) {
                boolean statusSaqueConta = contaLogada.saqueConta( valorTransferencia);
                boolean statusDepositoConta = contaCorrenteDestino.depositoConta(valorTransferencia);
                return statusDepositoConta && statusSaqueConta;
            }
            return false;
        }
        return false;
    }
}
