/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.ArrayList;
import java.util.List;
import arquivos.GerenciadorArquivo;
import usuario.GerenciadorUsuario;

/**
 *
 * @author Luis Gustavo
 */
public class GerenciadorBibliotecaVirtual {

    public static List<Livro> livros = new ArrayList<>();
    public static List<GerenciadorUsuario> usuarios = new ArrayList<>();
    public static GerenciadorUsuario USUARIOLOGADO = new GerenciadorUsuario();

    public static boolean isCadastrarArquivoLivro(String nome, String autor, int numeroPaginas, String editora, String conteudo) {
        Livro livro = new Livro(nome, autor, numeroPaginas, editora, conteudo);
        if (!livros.contains(livro) && conteudo != null) {
            livros.add(livro);
            GerenciadorArquivo.escreverArquivoClassAppend(livro.toString(), livro.getClass().getSimpleName());
            return true;
        }
        return false;
    }
    
    public static boolean isCadastrarArquivoUsuario(String nome, String login, String senha) {

        GerenciadorUsuario usuario = new GerenciadorUsuario(nome, login, senha);
        if (!usuarios.contains(usuario) && usuario.isVerificadorSenhas(senha)) {
            usuarios.add(usuario);
            GerenciadorArquivo.escreverArquivoClassAppend(usuario.toString(), GerenciadorUsuario.class.getSimpleName());
            return true;
        }
        return false;
    }
    
    protected static boolean isCadastrarAdmin() {
        GerenciadorUsuario admin = new GerenciadorUsuario();
        if (!usuarios.contains(admin)) {
            usuarios.add(admin);
            GerenciadorArquivo.escreverArquivoClassAppend(admin.toString(), GerenciadorUsuario.class.getSimpleName());
            return true;
        }
        return false;
    }

    protected static boolean isCarregarArquivoUsuario() {
        List<String> str = GerenciadorArquivo.lerArquivoClass(new GerenciadorUsuario("", "", "").getClass().getSimpleName());
        if (str != null) {
            str.stream().forEach((String s) -> usuarios.add(new GerenciadorUsuario(s)));
            return true;
        }
        return false;
    }
    
    protected static boolean isCarregarArquivoLivro() {
        List<String> str = GerenciadorArquivo.lerArquivoClass(new Livro("", "", 0, "", "").getClass().getSimpleName());
        if (str != null) {
            str.stream().forEach((String s) -> livros.add(new Livro(s)));
            return true;
        }
        return false;
    }
    
    public static boolean isVerificadorUsuario(String login, String senha) {
        return usuarios.stream().anyMatch((u) -> (login.equalsIgnoreCase(u.getLogin()) && senha.equalsIgnoreCase(u.getSenha())));
    }

    public static boolean isAlteracaoArquivoUsuarioSenha(String novaSenha) {
        usuarios.stream().filter((GerenciadorUsuario u) -> u.getLogin().equalsIgnoreCase(USUARIOLOGADO.getLogin())).forEach((GerenciadorUsuario u) -> {
            u.setSenha(novaSenha);
        });
        List<String> lista = new ArrayList<>();
        usuarios.stream().forEach((GerenciadorUsuario u) -> lista.add(u.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new GerenciadorUsuario().getClass().getSimpleName());
    }
   
    public static boolean isExclusaoLivro(Livro livro) {
        livros.removeIf((Livro l) -> l.equals(livro));
        List<String> lista = new ArrayList<>();
        livros.stream().forEach(l -> lista.add(l.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new Livro("", "", 0, "", "").getClass().getSimpleName());
    }

    public static boolean isExclusaoUsuario(GerenciadorUsuario gerenciadorUsuario) {
        if (gerenciadorUsuario != null) {
            usuarios.removeIf((GerenciadorUsuario u) -> u.equals(gerenciadorUsuario));
            List<String> lista = new ArrayList<>();
            usuarios.stream().forEach((GerenciadorUsuario u) -> lista.add(u.toString()));
            return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new GerenciadorUsuario().getClass().getSimpleName());
        } else{
            return false;
        }
    }
}
