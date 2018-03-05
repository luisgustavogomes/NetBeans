/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fis.view;

import br.com.fis.model.Departamento;
import br.com.fis.model.DepartamentoBO;
import br.com.fis.model.EmpregadoBO;
import br.com.fis.model.Gerente;
import br.com.fis.model.GerenteBO;
import br.com.fis.utl.Teclado;

/**
 *
 * @author Luis Gustavo
 */
public class TelaCadastroEmpregado {

    private static DepartamentoBO departamento = new DepartamentoBO();
    private static EmpregadoBO empregado = new EmpregadoBO();
    private static GerenteBO gerente = new GerenteBO();

    public static void main(String[] args) {
        while (true) {
            int controladorMenu = menu();
            switch (controladorMenu) {
                case 1:
                    cadastrarDepartamento();
                    break;
                case 2:
                    cadastrarEmpregado();
                    break;
                case 3:
                    cadastrarGerente();
                    break;
                case 4:
                    System.out.println("\nDepartamentos\n");
                    System.out.println(departamento.getAll());
                    break;
                case 5:
                    System.out.println("\nEmpregados\n");
                    System.out.println(empregado.getAll());
                    break;
                case 6:
                    System.out.println("\nGerentes\n");
                    System.out.println(gerente.getAll());
                    break;
                case 99:
                    System.exit(0);
            }
        }
    }

    private static int menu() {
        int controladorMenuPrincipal;

        do {
            System.out.println("----RH----\n"
                    + "1 - Cadastrar Departamentos\n"
                    + "2 - Cadastrar Empregados\n"
                    + "3 - Cadastrar Gerentes\n"
                    + "4 - Listar Departamentos\n"
                    + "5 - Listar Empregado\n"
                    + "6 - Listar Gerentes\n"
                    + "99 - Sair");
            System.out.print("Digite sua opção: ");
            controladorMenuPrincipal = Teclado.lerInteiro();
            if ((controladorMenuPrincipal < 1 || controladorMenuPrincipal > 6) && controladorMenuPrincipal != 99) {
                System.out.println("\nErro...Opação inválida!");
            }
        } while ((controladorMenuPrincipal < 1 || controladorMenuPrincipal > 6) && controladorMenuPrincipal != 99);

        return controladorMenuPrincipal;
    }

    private static void cadastrarDepartamento() {
        System.out.println("\nCadastro Departamento\n");
        numero();
        int numero = solicitarInt();
        nome();
        String nome = solicitarString();
        boolean status = departamento.save(new Departamento(numero, nome));
        if (status) {
            System.out.println("Sucesso!");
        } else {
            System.out.println("False!");
        }
    }

    private static void cadastrarEmpregado() {
        System.out.println("\nCadastro Empregado\n");
        cpf();
        long cpf = solicitarLong();
        nome();
        String nome = solicitarString();
        boolean status = empregado.save(new Gerente(cpf, nome));
        if (status) {
            System.out.println("Sucesso!");
        } else {
            System.out.println("False!");
        }
    }

    private static void cadastrarGerente() {
        System.out.println("\nCadastro Gerente\n");
        cpf();
        long cpf = solicitarLong();
        nome();
        String nome = solicitarString();
        boolean status = gerente.save(new Gerente(cpf, nome));
        if (status) {
            System.out.println("Sucesso!");
        } else {
            System.out.println("False!");
        }
    }

    private static String solicitarString() {
        String str = Teclado.lerString();
        return str;
    }

    private static long solicitarLong() {
        long l = Teclado.lerlong();
        return l;
    }

    private static int solicitarInt() {
        int i = Teclado.lerInteiro();
        return i;
    }

    private static void nome() {
        System.out.print("Nome: ");
    }

    private static void numero() {
        System.out.print("Numero: ");
    }

    private static void cpf() {
        System.out.print("CPF: ");
    }
}
