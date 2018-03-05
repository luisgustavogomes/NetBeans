/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.Scanner;
import javax.swing.JOptionPane;
import view.FrmLogin;

/**
 *
 * @author Luis Gustavo
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicializador();
        FrmLogin frmlogin = new FrmLogin();
        frmlogin.setVisible(true);
    }

    public static void inicializador() {
        carregarDadosClasse();
        GerenciadorBibliotecaVirtual.isCadastrarAdmin();
        //carregarTeste();
    }

    //Métodos carga arquivo
    private static void carregarDadosClasse() {
        boolean statusArquivoLivro = GerenciadorBibliotecaVirtual.isCarregarArquivoLivro();
        boolean statusArquivoUsuario = GerenciadorBibliotecaVirtual.isCarregarArquivoUsuario();
//        if (!statusArquivoUsuario && !statusArquivoLivro) {
//            JOptionPane.showMessageDialog(null, "Erro, ao upload de arquivo");
//        }
        
    }

    private static void carregarTeste() {

        GerenciadorBibliotecaVirtual.isCadastrarArquivoLivro("Tche loko", "Luis Gustavo", 10, "Qi", "O vídeo fornece uma maneira poderosa de ajudá-lo a provar seu argumento. Ao clicar em Vídeo Online, você pode colar o código de inserção do vídeo que deseja adicionar. Você também pode digitar uma palavra-chave para pesquisar online o vídeo mais adequado ao seu documento.");
        GerenciadorBibliotecaVirtual.isCadastrarArquivoLivro("Bagual", "Bruno Murata", 140, "Qi", "Clique em Inserir e escolha os elementos desejados nas diferentes galerias. Temas e estilos também ajudam a manter seu documento coordenado. Quando você clica em Design e escolhe um novo tema.");
        GerenciadorBibliotecaVirtual.isCadastrarArquivoLivro("Gaiteiro", "Mauro Hanh", 55, "Qi", "Para alterar a maneira como uma imagem se ajusta ao seu documento, clique nela e um botão de opções de layout será exibido ao lado.");
        GerenciadorBibliotecaVirtual.isCadastrarArquivoUsuario("Luis Gomes", "luis.gomes", "123");
    }

}
