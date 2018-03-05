/*
* Grupo 03
* Bruno Dutra
* Luis Gustavo Gomes
* Thomas Capitão
*/
package projetogrupo03;

import java.util.Scanner;

public class ProjetoGrupo03 {

    static Scanner teclado = new Scanner(System.in);
    static String[][] matrizFinal = new String[2][2];

    public static void main(String[] args) {
        int controladorMenuPrograma = 0;
        int controladorMenuCadastros = 0;
        int controladorMenuConsultas = 0;

        String matrizEventos[][] = new String[2][4];
        String matrizSalas[][] = new String[2][2];
        String matrizPalestrantes[][] = new String[2][3];
        String matrizPalestras[][] = new String[2][8];
        String matrizAlunos[][] = new String[2][5];
        String matrizEquipes[][] = new String[2][5];
        String matrizPresencaPalestra[][] = new String[2][3];

        System.out.println("Nome PROGRAMA #");

        do {
            controladorMenuPrograma = 0;
            do {
                menuPrincipalPrograma();
                controladorMenuPrograma = teclado.nextInt();

                if (controladorMenuPrograma <= 0 || controladorMenuPrograma > 4) {
                    System.out.println("\nErro...Digite corretamente a opção do Menu !");
                }
            } while (controladorMenuPrograma <= 0 || controladorMenuPrograma > 4);

            switch (controladorMenuPrograma) {
                case 1:
                    controladorMenuCadastros = 1;//cadastrosPrograma();
                    switch (controladorMenuCadastros) {
                        case 1:
                            linhaDuplaPrograma();
                            matrizEventos = cadastroEventos();
                            //break;
                            //case 2:
                            linhaDuplaPrograma();
                            matrizSalas = cadastroSalas();
                            //break;
                            //case 3:
                            linhaDuplaPrograma();
                            matrizPalestrantes = cadastroPalestrantes();
                            //break;
                            //case 4:
                            linhaDuplaPrograma();
                            matrizPalestras = cadastroPalestras(matrizEventos, matrizPalestrantes, matrizSalas);
                            //break;
                            //case 5:
                            linhaDuplaPrograma();
                            matrizAlunos = cadastroAlunos();
                            //break;
                            //case 6:
                            linhaDuplaPrograma();
                            matrizEquipes = cadastroEquipes();
                            //break;
                            //case 7:
                            linhaDuplaPrograma();
                            matrizPresencaPalestra = cadastroPresencaPalestra(matrizEventos, matrizAlunos, matrizPalestras, matrizSalas);
                        //break;
                        //case 8:
                        //break;
                    }
                    break;
                case 2:
                    controladorMenuConsultas = consultasPrograma();
                    switch (controladorMenuConsultas) {
                        case 1:
                            consultaEvento(matrizEventos);
                            break;
                        case 2:
                            consultaSala(matrizSalas);
                            break;
                        case 3:
                            consultaPalestrantes(matrizPalestrantes);
                            break;
                        case 4:
                            consultaPalestras(matrizPalestras);
                            break;
                        case 5:
                            consultaAluno(matrizAlunos);
                            break;
                        case 6:
                            consultaEquipe(matrizEquipes);
                            break;
                        case 7:
                            break;
                    }
                    break; 
                case 3:

                    System.out.println("\nQuantidade de alunos inscritos em uma palestra");
                    System.out.print("\nTítulo\t\t\tQuantidade\n");
                    for (int i = 0; i < matrizFinal.length; i++) {
                        for (int j = 0; j < matrizFinal[0].length; j++) {
                            System.out.print(matrizFinal[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:

                    System.out.println("Saindo");
                    break;
            }
        } while (controladorMenuPrograma != 4);

    }

//=================================================================================================================================================
    public static void menuPrincipalPrograma() {
        System.out.println("\nMenu Principal\n"
                + "\n1 - Cadastro"
                + "\n2 - Consultas"
                + "\n3 - Relatório Quantidade Aluno"
                + "\n4 - Fechar");
        System.out.print("Digite sua escolha: ");
    }

//    public static int cadastrosPrograma() {
//        int controladorMenuCadastros = 0;
//        do {
//            System.out.println("\nMenu cadastros\n"
//                    + "\n1 - Cadastro Evento"
//                    + "\n2 - Cadastro Sala da Instituição"
//                    + "\n3 - Cadastro Palestrantes"
//                    + "\n4 - Cadastro Palestra"
//                    + "\n5 - Cadastro Alunos"
//                    + "\n6 - Cadastro Equipe"
//                    + "\n7 - Cadastro Presença na Palestra"
//                    + "\n8 - Voltar ao menu principal");
//            System.out.print("Digite sua escolha: ");
//            controladorMenuCadastros = 1;//teclado.nextInt();
//            if (controladorMenuCadastros <= 0 || controladorMenuCadastros > 8) {
//                System.out.println("Erro...Digite novamente a opção de cadastro !");
//            }
//        } while (controladorMenuCadastros <= 0 || controladorMenuCadastros > 8);
//        return (controladorMenuCadastros);
//    }
    public static int consultasPrograma() {
        int controladorMenuConsultas = 0;
        do {
            System.out.println("\nMenu Consultas"
                    + "\n1 - Consulta Evento"
                    + "\n2 - Consulta Sala da Instituição"
                    + "\n3 - Consulta Palestrantes"
                    + "\n4 - Consulta Palestra"
                    + "\n5 - Consulta Alunos"
                    + "\n6 - Consulta Equipe"
                    + "\n7- Voltar ao menu principal");
            System.out.print("Digite sua escolha: ");
            controladorMenuConsultas = teclado.nextInt();
            if (controladorMenuConsultas <= 0 || controladorMenuConsultas > 8) {
                System.out.println("Erro...Repita a operação. "
                        + "\nDigite novamente a opção de consulta !");
            }
        } while (controladorMenuConsultas <= 0 || controladorMenuConsultas > 8);
        return (controladorMenuConsultas);
    }

    public static String[][] cadastroEventos() {
        String[][] matrizEventos = new String[2][4];

        System.out.println("Cadastro de eventos\n");

        for (int i = 0; i < matrizEventos.length; i++) {

            if (i == 0) {
                teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("Código do evento: ");
                matrizEventos[i][0] = teclado.nextLine();
                if (!verificadorInteiro(matrizEventos[i][0])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nCódigo contém caracteres, somente números são aceitos.\n");
                }
            } while (!verificadorInteiro(matrizEventos[i][0]));

            do {
                System.out.print("Nome do evento: ");
                matrizEventos[i][1] = teclado.nextLine();
                if (verificadorTamanhoString(matrizEventos[i][1]) > 80) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNome excedeu o límite máximo de 80 caracteres.\n");
                }
            } while (verificadorTamanhoString(matrizEventos[i][1]) > 80);

            do {
                System.out.print("Período de inscrição [ DD MM AAAA ]: ");
                matrizEventos[i][2] = teclado.nextLine();
                if (!verificardorData(matrizEventos[i][2])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nData digitada invalida, somente números."
                            + "\nEx.: 01012016\n");
                }
            } while (!verificardorData(matrizEventos[i][2]));

            do {
                System.out.print("Período de execução [ DD MM AAAA ]: ");
                matrizEventos[i][3] = teclado.nextLine();
                if (!verificardorData(matrizEventos[i][3])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nData digitada invalida, somente números."
                            + "\nEx.: 01012016\n");
                }
            } while (!verificardorData(matrizEventos[i][3]));

        }
        return (matrizEventos);
    }

    public static String[][] cadastroSalas() {
        String matrizSalas[][] = new String[2][2];

        System.out.println("Cadastro de salas\n");

        for (int i = 0; i < matrizSalas.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("Nome da sala [ Ex.: Sala 47 ]: ");
                matrizSalas[i][0] = teclado.nextLine();
                if (!verificadorSala(matrizSalas[i][0])) {
                    System.out.println("Erro...Repita a operação"
                            + "\nCampo sala digitado incorretamente.\n");
                }

            } while (!verificadorSala(matrizSalas[i][0]));

            do {
                System.out.print("Capacidade: ");
                matrizSalas[i][1] = teclado.nextLine();
                if (!verificadorInteiro(matrizSalas[i][1])) {
                    System.out.println("Erro...Repita a operação"
                            + "\nCapacitada incorreta somente números inteiros.\n");
                }
            } while (!verificadorInteiro(matrizSalas[i][1]));

        }
        return (matrizSalas);
    }

    public static String[][] cadastroPalestrantes() {
        String matrizPalestrantes[][] = new String[2][3];

        System.out.println("Cadastro de palestrantes\n");

        for (int i = 0; i < matrizPalestrantes.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("Código do Palestrante: ");
                matrizPalestrantes[i][0] = teclado.nextLine();
                if (!verificadorInteiro(matrizPalestrantes[i][0])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nCódigo contém caracteres, somente números são aceitos.\n");
                }
            } while (!verificadorInteiro(matrizPalestrantes[i][0]));

            do {
                System.out.print("Nome do Palestrante: ");
                matrizPalestrantes[i][1] = teclado.nextLine();
                if (verificadorTamanhoString(matrizPalestrantes[i][1]) > 50) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNome excedeu o límite máximo de 50 caracteres.\n");
                }
            } while (verificadorTamanhoString(matrizPalestrantes[i][1]) > 50);

            do {
                System.out.print("Link currículo: ");
                matrizPalestrantes[i][2] = teclado.nextLine();
                if ((verificadorTamanhoString(matrizPalestrantes[i][2]) > 100) || (!verificadorCaracteresSite(matrizPalestrantes[i][2]))) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nLink currículo excedeu o límite máximo de 100 caracteres ou endereço incorreto.\n");
                }
            } while ((verificadorTamanhoString(matrizPalestrantes[i][2]) > 100) || (!verificadorCaracteresSite(matrizPalestrantes[i][2])));

        }
        return (matrizPalestrantes);
    }

    public static String[][] cadastroPalestras(String[][] matrizEvento, String[][] matrizPalestrantes, String[][] matrizSalas) {
        String matrizPalestras[][] = new String[2][8];

        System.out.println("Cadastro de palestras\n");

        for (int i = 0; i < matrizPalestras.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("Escolha o evento disponível \n");
                for (int j = 0; j < matrizEvento.length; j++) {
                    System.out.println("\tEventos: " + matrizEvento[j][0]);
                }
                System.out.print("Digite sua escolha: ");
                matrizPalestras[i][0] = teclado.nextLine();
                if (!verificadorCodigoEvento(matrizPalestras[i][0], matrizEvento)) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nEvento não disponivel.\n");
                }
            } while (!verificadorCodigoEvento(matrizPalestras[i][0], matrizEvento));

            do {
                System.out.print("Título da palestra: ");
                matrizPalestras[i][1] = teclado.nextLine();
                if (verificadorTamanhoString(matrizPalestras[i][1]) > 50) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nTítulo da palestra excedeu o límite máximo de 50 caracteres.\n");
                }
            } while (verificadorTamanhoString(matrizPalestras[i][1]) > 50);

            do {
                System.out.print("Data [ DD MM AAAA ]: ");
                matrizPalestras[i][2] = teclado.nextLine();
                if (!verificardorData(matrizPalestras[i][2])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nData digitada invalida, somente números."
                            + "\nEx.: 01012016\n");
                }
            } while (!verificardorData(matrizPalestras[i][2]));

            do {
                System.out.print("Hora [ HH MM ]: ");
                matrizPalestras[i][3] = teclado.nextLine();
                if (!verificardorHora(matrizPalestras[i][3])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nHora digitada invalida, somente números."
                            + "\nEx.: 1430\n");
                }
            } while (!verificardorHora(matrizPalestras[i][3]));

            do {
                System.out.print("\nEscolha o palestrante disponível \n");
                for (int j = 0; j < matrizPalestrantes.length; j++) {
                    System.out.println("\tPalestrante: " + matrizPalestrantes[j][0]);
                }
                System.out.print("Digite sua escolha: ");;
                matrizPalestras[i][4] = teclado.nextLine();
                if (!verificadorCodigoPalestrante(matrizPalestras[i][4], matrizPalestrantes)) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nPalestrante não disponivel.\n");
                }
            } while (!verificadorCodigoPalestrante(matrizPalestras[i][4], matrizPalestrantes));

            do {
                System.out.print("\nEscolha a sala disponível \n");
                for (int j = 0; j < matrizSalas.length; j++) {
                    System.out.println("\tSala: " + matrizSalas[j][0]);
                }
                System.out.print("Digite sua escolha: ");
                matrizPalestras[i][5] = teclado.nextLine();
                if (!verificadorCodigoSala(matrizPalestras[i][5], matrizSalas)) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nSala não disponivel.\n");
                }
            } while (!verificadorCodigoSala(matrizPalestras[i][5], matrizSalas));

            System.out.print("\nEquipe organizadora: ");
            matrizPalestras[i][6] = teclado.nextLine();

            String ano = matrizPalestras[i][2].substring(4, 8);
            String mes = matrizPalestras[i][2].substring(2, 4);
            String dia = matrizPalestras[i][2].substring(0, 2);

            matrizPalestras[i][7] = ano + mes + dia + matrizPalestras[i][0] + "000" + i;

        }
        return (matrizPalestras);
    }

    public static String[][] cadastroAlunos() {
        String matrizAlunos[][] = new String[2][5];

        System.out.println("Cadastro de aluno\n");

        for (int i = 0; i < matrizAlunos.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("RA: ");
                matrizAlunos[i][0] = teclado.nextLine();
                if (!verificadorInteiro(matrizAlunos[i][0])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nRA contém caracteres, somente números são aceitos.\n");
                }
            } while (!verificadorInteiro(matrizAlunos[i][0]));

            do {
                System.out.print("Nome do Aluno: ");
                matrizAlunos[i][1] = teclado.nextLine();
                if (verificadorTamanhoString(matrizAlunos[i][1]) > 50) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNome do aluno excedeu o límite máximo de 50 caracteres.\n");
                }
            } while (verificadorTamanhoString(matrizAlunos[i][1]) > 50);

            do {
                System.out.print("E-mail: ");
                matrizAlunos[i][2] = teclado.nextLine();
                if ((verificadorTamanhoString(matrizAlunos[i][2]) > 30) || (!verificadorCaracteresEmail(matrizAlunos[i][2]))) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nE-mail excedeu o límite máximo de 30 caracteres ou invalido.\n");
                }
            } while ((verificadorTamanhoString(matrizAlunos[i][2]) > 30) || (!verificadorCaracteresEmail(matrizAlunos[i][2])));

            do {
                System.out.print("Telefone (DDD)99999-9999: ");
                matrizAlunos[i][3] = teclado.nextLine();
                if (!verificadorNumeroTelefonico(matrizAlunos[i][3])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNúmero telefônico invalido."
                            + "\nExemplo (DDD)99999-9999.\n");
                }
            } while (!verificadorNumeroTelefonico(matrizAlunos[i][3]));

            do {
                System.out.print("Senha [Letras e Numeros]: ");
                matrizAlunos[i][4] = teclado.nextLine();
                if (!VerificadorSenhas(matrizAlunos[i][4])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nSenha inválida, excedeu o límite máximo de 15 caracteres ou "
                            + "\nnão contém letras e digitos.\n");
                }
            } while (!VerificadorSenhas(matrizAlunos[i][4]));

        }
        return (matrizAlunos);
    }

    public static String[][] cadastroEquipes() {
        String matrizEquipes[][] = new String[2][5];

        System.out.println("Cadastro de Equipe\n");

        for (int i = 0; i < matrizEquipes.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }

            do {
                System.out.print("Código: ");
                matrizEquipes[i][0] = teclado.nextLine();
                if (!verificadorInteiro(matrizEquipes[i][0])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nCódigo contém caracteres, somente números são aceitos.\n");
                }
            } while (!verificadorInteiro(matrizEquipes[i][0]));

            do {
                System.out.print("Nome: ");
                matrizEquipes[i][1] = teclado.nextLine();
                if (verificadorTamanhoString(matrizEquipes[i][1]) > 8) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNome excedeu o límite máximo de 8 caracteres.\n");
                }
            } while (verificadorTamanhoString(matrizEquipes[i][1]) > 8);

            do {
                System.out.print("E-mail: ");
                matrizEquipes[i][2] = teclado.nextLine();
                if ((verificadorTamanhoString(matrizEquipes[i][2]) > 30) || (!verificadorCaracteresEmail(matrizEquipes[i][2]))) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nE-mail excedeu o límite máximo de 30 caracteres ou invalido.\n");
                }
            } while ((verificadorTamanhoString(matrizEquipes[i][2]) > 30) || (!verificadorCaracteresEmail(matrizEquipes[i][2])));

            do {
                System.out.print("Telefone (DDD)99999-9999: ");
                matrizEquipes[i][3] = teclado.nextLine();
                if (!verificadorNumeroTelefonico(matrizEquipes[i][3])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nNúmero telefônico invalido."
                            + "\nExemplo (DDD)99999-9999.\n");
                }
            } while (!verificadorNumeroTelefonico(matrizEquipes[i][3]));

            do {
                System.out.print("Senha [Letras e Numeros]: ");
                matrizEquipes[i][4] = teclado.nextLine();
                if (!VerificadorSenhas(matrizEquipes[i][4])) {
                    System.out.println("\nErro...Repita a operação."
                            + "\nSenha inválida, excedeu o límite máximo de 15 caracteres ou "
                            + "\nnão contém letras e digitos.\n");
                }
            } while (!VerificadorSenhas(matrizEquipes[i][4]));

        }
        return (matrizEquipes);
    }

    public static String[][] cadastroPresencaPalestra(String[][] matrizEvento, String[][] matrizAlunos, String[][] matrizPalestras, String[][] matrizSalas) {
        String matrizPresencaPalestra[][] = new String[2][3];

        for (int i = 0; i < matrizPresencaPalestra.length; i++) {

            if (i == 0) {
                //teclado.nextLine();
            } else {
                linhaSimplesPrograma();
            }
            do {
                do {
                    System.out.print("Escolha o evento disponível \n");
                    for (int j = 0; j < matrizEvento.length; j++) {
                        System.out.println("\tEventos: " + matrizEvento[j][0]);
                    }
                    System.out.print("Digite sua escolha: ");
                    matrizPresencaPalestra[i][0] = teclado.nextLine();
                    if (!verificadorCodigoEvento(matrizPresencaPalestra[i][0], matrizEvento)) {
                        System.out.println("\nErro...Repita a operação."
                                + "\nEvento não disponivel.\n");
                    }
                } while (!verificadorCodigoEvento(matrizPresencaPalestra[i][0], matrizEvento));

                do {
                    System.out.print("\nEscolha o RA disponível\n ");
                    for (int j = 0; j < matrizEvento.length; j++) {
                        System.out.println("\tRAs: " + matrizAlunos[j][0]);
                    }
                    System.out.print("Digite sua escolha: ");
                    matrizPresencaPalestra[i][1] = teclado.nextLine();
                    if (!verificadorRA(matrizPresencaPalestra[i][1], matrizAlunos)) {
                        System.out.println("\nErro...Repita a operação."
                                + "\nRa não cadastrado.\n");
                    }
                } while (!verificadorRA(matrizPresencaPalestra[i][1], matrizAlunos));

                String salaEvento = null;
                String capacidadeSala = null;
                String nomePalestra = null;

                for (int z = 0; z < matrizPalestras.length; z++) {
                    if (matrizPresencaPalestra[i][0].equalsIgnoreCase(matrizPalestras[z][0])) {
                        salaEvento = matrizPalestras[z][5];
                        nomePalestra = matrizPalestras[z][1];
                    }
                }

                for (int j = 0; j < matrizSalas.length; j++) {
                    if (salaEvento.equalsIgnoreCase(matrizSalas[j][0])) {
                        capacidadeSala = matrizSalas[j][1];
                    }
                }

                int NovaCapacidadeSala = Integer.parseInt(capacidadeSala);
                NovaCapacidadeSala = NovaCapacidadeSala - 2;

                if (NovaCapacidadeSala > 0) {
                    matrizPresencaPalestra[i][2] = "Presente";
                    matrizFinal[i][0] = nomePalestra;
                    matrizFinal[i][1] = "1";

                    System.out.println("\nPresença confirmada com sucesso.\n");
                } else {
                    matrizPresencaPalestra[i][2] = "Não";
                    System.out.println("\nErro...Repita a operação.\nCapacitada exedida.");
                }

            } while (matrizPresencaPalestra[i][2].equals("Não"));

        }

        return (matrizPresencaPalestra);
    }

    public static int verificadorTamanhoString(String verificar) {
        int tamanhoString = verificar.length();
        return (tamanhoString);
    }

    public static boolean verificadorInteiro(String verificar) {
        char[] vetorCaracter = verificar.toCharArray();
        boolean status = true;

        for (int i = 0; i < vetorCaracter.length; i++) {
            if (!Character.isDigit(vetorCaracter[i])) {
                status = false;
                break;
            }
        }

        if (verificar.equals("")) {
            status = false;
        }

        return (status);
    }

    public static boolean verificardorData(String verificar) {
        boolean status;
        int dia;
        int mes;
        int ano;
        if ((verificadorTamanhoString(verificar) != 8) || (!verificadorInteiro(verificar))) {
            status = false;
            return (status);
        }
        dia = Integer.parseInt(verificar.substring(0, 2));
        mes = Integer.parseInt(verificar.substring(2, 4));
        ano = Integer.parseInt(verificar.substring(4, 8));
        if ((dia <= 0 || dia > 31) || (mes <= 0 || mes > 12) || (ano <= 1970 || ano > 2099)) {
            status = false;
            return (status);
        }
        status = true;
        return (status);
    }

    public static boolean verificardorHora(String verificar) {
        boolean status;
        int hora;
        int minuto;
        if ((verificadorTamanhoString(verificar) != 4) || (!verificadorInteiro(verificar))) {
            status = false;
            return (status);
        }
        hora = Integer.parseInt(verificar.substring(0, 2));
        minuto = Integer.parseInt(verificar.substring(2, 4));
        if ((hora < 0 || hora > 23) || (minuto < 0 || minuto > 59)) {
            status = false;
            return (status);
        }
        status = true;
        return (status);
    }

    public static boolean verificadorSala(String verificar) {
        boolean status = true;
        if (verificadorTamanhoString(verificar) != 7) {
            status = false;
            return (status);
        }
        String nome = "Sala ";
        String nomeVerificador = verificar.substring(0, 5);
        String numeracao = verificar.substring(5, 7);
        if (!verificadorInteiro(numeracao)) {
            status = false;
            return (status);
        }
        if (!nome.equalsIgnoreCase(nomeVerificador)) {
            status = false;
            return (status);
        }
        return (status);
    }

    public static boolean verificadorCaracteresSite(String verificar) {
        boolean status = true;
        int posicaoHttp = verificar.indexOf("http");
        int posicaoBarra = verificar.indexOf('/');
        if ((!(posicaoHttp > 0)) && (!(posicaoBarra > 0))) {
            status = false;
        }
        return (status);
    }

    public static boolean verificadorCaracteresEmail(String verificar) {
        boolean status = true;
        int posicaoEmail = verificar.indexOf('@');
        if (!(posicaoEmail > 0)) {
            status = false;
        }
        return (status);
    }

    public static void linhaDuplaPrograma() {
        System.out.println("\n===========================================================================\n");
    }

    public static void linhaSimplesPrograma() {
        System.out.println("\n--------------------------------------------------------------------------\n");
    }

    public static boolean verificadorRA(String verificar, String[][] matrizAlunos) {
        boolean status = false;
        for (int i = 0; i < matrizAlunos.length; i++) {
            if (verificar.equalsIgnoreCase(matrizAlunos[i][0])) {
                status = true;
                break;
            }
        }
        return (status);
    }

    public static boolean verificadorCodigoEvento(String verificar, String[][] matrizEvento) {
        boolean status = false;
        for (int i = 0; i < matrizEvento.length; i++) {
            if (verificar.equalsIgnoreCase(matrizEvento[i][0])) {
                status = true;
                break;
            }
        }
        return (status);
    }

    public static boolean verificadorCodigoPalestrante(String verificar, String[][] matrizPalestrantes) {
        boolean status = false;
        for (int i = 0; i < matrizPalestrantes.length; i++) {
            if (verificar.equalsIgnoreCase(matrizPalestrantes[i][0])) {
                status = true;
                break;
            }
        }
        return (status);
    }

    public static boolean verificadorCodigoSala(String verificar, String[][] matrizSalas) {
        boolean status = false;
        for (int i = 0; i < matrizSalas.length; i++) {
            if (verificar.equalsIgnoreCase(matrizSalas[i][0])) {
                status = true;
                break;
            }
        }
        return (status);
    }

    public static boolean verificadorNumeroTelefonico(String verificar) {
        boolean status = true;

        if (verificadorTamanhoString(verificar) != 15) {
            status = false;
            return (status);
        }

        String abriParenteses = verificar.substring(0, 1);
        String ddd = verificar.substring(1, 4);
        String fechaParenteses = verificar.substring(4, 5);
        String codigoPrimeiraParte = verificar.substring(5, 10);
        String hifen = verificar.substring(10, 11);
        String codigoSegundaParte = verificar.substring(11, 15);

        if ((!(abriParenteses.equalsIgnoreCase("("))) || (!(fechaParenteses.equalsIgnoreCase(")"))) || (!(hifen.equalsIgnoreCase("-")))
                || (!verificadorInteiro(ddd)) || (!verificadorInteiro(codigoPrimeiraParte)) || (!verificadorInteiro(codigoSegundaParte))) {
            status = false;
            return (status);
        }
        return (status);
    }

    public static boolean VerificadorSenhas(String verificar) {
        char[] vetorCaracter = verificar.toCharArray();
        boolean status = false;
        boolean statusNumero = false;
        boolean statusLetra = false;
        for (int i = 0; i < vetorCaracter.length; i++) {
            if (Character.isDigit(vetorCaracter[i])) {
                statusNumero = true;
                break;
            }
        }
        for (int j = 0; j < vetorCaracter.length; j++) {
            if (Character.isLetter(vetorCaracter[j])) {
                statusLetra = true;
                break;
            }

        }
        if (statusLetra && statusNumero) {
            status = true;
        }
        return (status);
    }

    public static void consultaEvento(String[][] matrizEventos) {
        System.out.print("\nCódigo\tNome\t\t\tPeríodo de inscrição\tPeríodo de execução\n");
        for (int i = 0; i < matrizEventos.length; i++) {
            for (int j = 0; j < matrizEventos[0].length; j++) {
                System.out.print(matrizEventos[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void consultaSala(String[][] matrizSalas) {
        System.out.print("\nNome\tCapacidade\n");
        for (int i = 0; i < matrizSalas.length; i++) {
            for (int j = 0; j < matrizSalas[0].length; j++) {
                System.out.print(matrizSalas[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void consultaPalestrantes(String[][] matrizPalestrantes) {
        System.out.print("\nCódigo\tNome\tLink\n");
        for (int i = 0; i < matrizPalestrantes.length; i++) {
            for (int j = 0; j < matrizPalestrantes[0].length; j++) {
                System.out.print(matrizPalestrantes[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void consultaPalestras(String[][] matrizPalestras) {
        System.out.print("\nCódigo do evento\tTítulo\tData\tHora\tCódigo palestrante\tSala\tEquipe\tCódigo da palestra\n");
        for (int i = 0; i < matrizPalestras.length; i++) {
            for (int j = 0; j < matrizPalestras[0].length; j++) {
                System.out.print(matrizPalestras[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void consultaAluno(String[][] matrizAlunos) {
        System.out.print("\nRA\tNome\tE-mail\tTelefone\tSenha\n");
        for (int i = 0; i < matrizAlunos.length; i++) {
            for (int j = 0; j < matrizAlunos[0].length; j++) {
                System.out.print(matrizAlunos[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void consultaEquipe(String[][] matrizEquipes) {
        System.out.print("\nRA\tNome\tE-mail\tTelefone\tSenha\n");
        for (int i = 0; i < matrizEquipes.length; i++) {
            for (int j = 0; j < matrizEquipes[0].length; j++) {
                System.out.print(matrizEquipes[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
