package banco;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {

    static Scanner teclado = new Scanner(System.in);
    static Banco banco = new Banco();

    public static void main(String[] args) {
        while (true) {
            int controladorAcesso = menu();
            boolean statusAutenticacao = autenticacao(controladorAcesso);
            if (statusAutenticacao) {
                switch (controladorAcesso) {
                    case 1:
                        menuCliente();
                        break;
                    case 2:
                        menuUsuario();
                        break;
                }
            } else {
                System.out.println("\nErro tentativas! reiniciando!");
            }
        }
    }

    private static int menu() {
        System.out.println("Banco QI\n");
        while (true) {
            System.out.println("Selecione a sua Opção:");
            System.out.println("1 - Cliente "
                    + "\n2 - Usuario"
                    + "\n3 - Sair");
            int controladorAcesso = solicitaInteiro();
            switch (controladorAcesso) {
                case 1:
                case 2:
                    System.out.println("Acessando...");
                    return controladorAcesso;
                case 3:
                    System.out.println("Finalizando...");
                    System.exit(0);
                default:
                    System.out.println("\nErro! Escolha a opção correta!\n");
                    break;
            }

        }

    }

    private static boolean autenticacao(int controladorAcesso) {
        if (controladorAcesso == 1) {
            return autenticacaoCliente();
        } else {
            return autenticacaoUsuario();
        }
    }

    private static boolean autenticacaoCliente() {
        short controlador = 0;
        while (true) {
            System.out.println("\nCliente");
            String agencia = solicitaAgencia();
            String conta = solicitaConta();
            String senha = solicitaSenha();
            boolean status = banco.verificarLoginCliente(agencia, conta, senha);
            if (status) {
                System.out.println("Autenticado!");
                Banco.contaLogada = banco.contaCliente();
                return true;
            } else {
                System.out.println("\nErro! Agencia, Conta e Senha Incorretas \nOu cliente inexistente!");
                controlador++;
            }
            if (controlador == 3) {
                return false;
            }

        }
    }

    private static boolean autenticacaoUsuario() {
        short controlador = 0;
        while (true) {
            System.out.println("\nUsuario");
            boolean status = banco.verificarLoginUsuario(solicitaLogin(), solicitaSenha());
            if (status) {
                System.out.println("Autenticado!");
                return true;
            } else {
                System.out.println("\nErro! Usuario ou Senha incorreta!");
                controlador++;
            }
            if (controlador == 3) {
                return false;
            }
        }
    }

    private static void menuCliente() {
        while (true) {

            System.out.println("\nMenu Cliente"
                    + "\n1 - Consultar saldo"
                    + "\n2 - Efetuar depósito");
            if (Banco.contaLogada.getClass() != Salario.class) {
                System.out.println("3 - Transferências");
            }
            System.out.println("4 - Saque"
                    + "\n5 - Voltar ao menu principal");

            int controlador = solicitaInteiro();

            if (Banco.contaLogada.getClass() == Salario.class && controlador == 3) {
                controlador = 0;
            }

            switch (controlador) {
                case 1:
                    System.out.println("\nConsulta Saldo\n");
                    System.out.println(banco.saldoContaCliente());
                    break;
                case 2:
                    System.out.println("\nEfetuar depósito\n");
                    boolean status = banco.depositoContaCliente(solicitaValor());
                    if (status) {
                        System.out.println("Operação realizada com Sucesso!");
                    } else {
                        System.out.println("Erro ou Valor incorreto!");
                    }
                    break;
                case 3:
                    System.out.println("\nTransferência\n");
                    status = banco.transferenciaContacliente(solicitaValor(), solicitaAgencia(), solicitaConta());
                    if (status) {
                        System.out.println("Operação realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente \nou conta inexistente!");
                    }
                    break;
                case 4:
                    System.out.println("\nSaque");
                    status = banco.saqueContaCliente(solicitaValor());
                    if (status) {
                        System.out.println("Operação realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                case 5:
                    Banco.contaLogada = null;
                    return;
                default:
                    System.out.println("Erro! Escolha a opção correta!");
            }

        }

    }

    private static void menuUsuario() {
        while (true) {
            System.out.println("\nMenu Usuario"
                    + "\n1 - Cadastrar Conta"
                    + "\n2 - Consultar Conta"
                    + "\n3 - Excluir Conta"
                    + "\n4 - Alterar Limite"
                    + "\n5 - Alterar Rendimento"
                    + "\n9 - Voltar ao menu principal");
            int controlador = solicitaInteiro();
            switch (controlador) {
                case 1:
                    int controladorTipoConta;
                    System.out.println("\nCadastro conta:");
                    while (true) {
                        System.out.println("Escolha o tipo da conta"
                                + "\n1 - Corrente"
                                + "\n2 - Poupança"
                                + "\n3 - Salario"
                                + "\n4 - Investimento");
                        controladorTipoConta = solicitaInteiro();
                        if (controladorTipoConta < 1 || controladorTipoConta > 4) {
                            System.out.println("Erro! \nDigite novamente sua escolha!");
                        } else {
                            break;
                        }
                    }
                    boolean statusCasdastroCliente = banco.cadastroCliente(controladorTipoConta, solicitaAgencia(), solicitaConta(), solicitaSenha());
                    if (statusCasdastroCliente) {
                        System.out.println("\nCadastrado com sucesso!");
                    } else {
                        System.out.println("Erro!\nConta já criada!");
                    }
                    break;
                case 2:
                    System.out.println("\nConsulta Cliente:");
                    banco.contas.stream().forEach((conta) -> {
                        System.out.println(conta);
                    });
                    break;
                case 3:
                    System.out.println("\nExluir Cliente\n");
                    boolean status = banco.excluirCliente(solicitaAgencia(), solicitaConta());
                    if (status) {
                        System.out.println("Excluido com sucesso!");
                    } else {
                        System.out.println("Erro cliente não localizado!");
                    }
                    break;
                case 4:
                    System.out.println("\nAlterar Limite\n");
                    status = banco.alterarLimiteCliente(solicitaAgencia(), solicitaConta(), solicitaValor());
                    if (status) {
                        System.out.println("Alterado com sucesso!");
                    } else {
                        System.out.println("Erro cliente não localizado!, ou operação invalida!");
                    }
                    break;
                case 5:
                    System.out.println("\nAlterar Rendimento\n");
                    status = banco.alterarRendimentoCliente(solicitaAgencia(), solicitaConta(), solicitaValor());
                    if (status) {
                        System.out.println("Alterado com sucesso!");
                    } else {
                        System.out.println("Erro cliente não localizado!, ou operação invalida!");
                    }

                    break;
                case 9:
                    return;
                default:
            }
        }

    }

    private static int solicitaInteiro() {
        int numero = 0;
        boolean status = false;
        do {
            try {
                System.out.print("Digite sua escolha: ");
                numero = teclado.nextInt();
                teclado.nextLine();
                status = true;
            } catch (InputMismatchException ime) {
                System.out.println("\nErro no tipo digitado!\n" + ime.toString() + "\n");
                teclado.nextLine();
            } catch (Exception ex) {
                System.out.println("\nFaltal erro!\n" + ex.toString());
                teclado.nextLine();
            }
        } while (!status);
        return numero;
    }

    private static String solicitaAgencia() {
        System.out.print("Agencia: ");
        String agencia = teclado.nextLine();
        return agencia;
    }

    private static String solicitaLogin() {
        System.out.print("Login: ");
        String agencia = teclado.nextLine();
        return agencia;
    }

    private static String solicitaConta() {
        System.out.print("Conta: ");
        String agencia = teclado.nextLine();
        return agencia;
    }

    private static String solicitaSenha() {
        System.out.print("Senha: ");
        String agencia = teclado.nextLine();
        return agencia;
    }

    private static double solicitaValor() {
        short contador = 0;
        double valor = 0;
        boolean status = false;
        while (true) {
            do {
                try {
                    System.out.print("Informe o valor: ");
                    valor = teclado.nextDouble();
                    teclado.nextLine();
                    status = true;
                } catch (InputMismatchException ime) {
                    System.out.println("\nErro no tipo digitado!\n" + ime.toString() + "\n");
                    teclado.nextLine();
                } catch (Exception ex) {
                    System.out.println("\nFaltal erro!\n" + ex.toString());
                    teclado.nextLine();
                }

            } while (!status);

            if (valor > 0) {
                return valor;
            } else {
                contador++;
                System.out.println("Valor Incorreto!");
            }
        }
    }
}
