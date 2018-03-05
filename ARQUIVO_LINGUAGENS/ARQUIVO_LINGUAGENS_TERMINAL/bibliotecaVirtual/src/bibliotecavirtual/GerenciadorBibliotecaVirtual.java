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
    public static final GerenciadorUsuario USUARIOLOGADO = new GerenciadorUsuario();

    //Criação
    protected static boolean cadastrarArquivoLivro(String nome, String autor, int numeroPaginas, String editora, String conteudo) {
        Livro livro = new Livro(nome, autor, numeroPaginas, editora, conteudo);
        if (!livros.contains(livro) && conteudo != null) {
            livros.add(livro);
            GerenciadorArquivo.escreverArquivoClassAppend(livro.toString(), livro.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    protected static boolean cadastrarArquivoUsuario(String nome, String login, String senha) {

        GerenciadorUsuario usuario = new GerenciadorUsuario(nome, login, senha);
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            GerenciadorArquivo.escreverArquivoClassAppend(usuario.toString(), GerenciadorUsuario.class.getSimpleName());
            return true;
        }
        return false;
    }

    protected static boolean cadastrarAdmin() {
        GerenciadorUsuario admin = new GerenciadorUsuario();
        if (!usuarios.contains(admin)) {
            usuarios.add(admin);
            GerenciadorArquivo.escreverArquivoClassAppend(admin.toString(), GerenciadorUsuario.class.getSimpleName());
            return true;
        }
        return false;
    }

    //Carga
    protected static boolean carregarArquivoUsuario() {
        List<String> str = GerenciadorArquivo.lerArquivoClass(new GerenciadorUsuario("", "", "").getClass().getSimpleName());
        if (str != null) {
            str.stream().forEach((String s) -> usuarios.add(new GerenciadorUsuario(s)));
            return true;
        }
        return false;
    }

    protected static boolean carregarArquivoLivro() {
        List<String> str = GerenciadorArquivo.lerArquivoClass(new Livro("", "", 0, "", "").getClass().getSimpleName());
        if (str != null) {
            str.stream().forEach((String s) -> livros.add(new Livro(s)));
            return true;
        }
        return false;
    }

    protected static String uploadConteudo(String caminho) {
        List<String> strs = GerenciadorArquivo.lerArquivoClass(caminho);
        String str = "";
        if (strs != null) {
            for (int i = 0; i < strs.size(); i++) {
                str += strs.get(i);
            }
            return str;
        }
        return null;
    }

    //Verificação
    protected static boolean verificadorUsuario(String login, String senha) {
        return usuarios.stream().anyMatch((u) -> (login.equalsIgnoreCase(u.getLogin()) && senha.equalsIgnoreCase(u.getSenha())));
    }

    protected static boolean verificadorLivro(String nome) {
        return livros.stream().anyMatch(l -> l.getNome().equalsIgnoreCase(nome));
    }

    protected static boolean verificadorUsuario(String login) {
        return usuarios.stream().anyMatch(l -> l.getLogin().equalsIgnoreCase(login));
    }

    //Alterações
    protected static boolean alteracaoArquivoLivro(String nomePesquisa, String nome, String autor, int numeroPaginas, String editora, String conteudo) {
        if (conteudo != null) {
            livros.stream().filter((Livro l) -> l.getNome().equalsIgnoreCase(nomePesquisa)).forEach((Livro l) -> {
                l.setNome(nome);
                l.setAutor(autor);
                l.setNumeroPaginas(numeroPaginas);
                l.setEditora(editora);
                l.setConteudo(conteudo);
            });
            List<String> lista = new ArrayList<>();
            livros.stream().forEach(l -> lista.add(l.toString()));
            return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new Livro("", "", 0, "", "").getClass().getSimpleName());
        } else {
            return false;
        }
    }

    protected static boolean alteracaoArquivoUsuarioSenha(String novaSenha) {
        usuarios.stream().filter((GerenciadorUsuario u) -> u.getLogin().equalsIgnoreCase(USUARIOLOGADO.getLogin())).forEach((GerenciadorUsuario u) -> {
            u.setSenha(novaSenha);
        });
        List<String> lista = new ArrayList<>();
        usuarios.stream().forEach((GerenciadorUsuario u) -> lista.add(u.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new GerenciadorUsuario().getClass().getSimpleName());

    }

    protected static boolean exclusaoLivro(String nomePesquisa) {
        livros.removeIf((Livro l) -> l.getNome().equalsIgnoreCase(nomePesquisa));
        List<String> lista = new ArrayList<>();
        livros.stream().forEach(l -> lista.add(l.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new Livro("", "", 0, "", "").getClass().getSimpleName());
    }

    protected static boolean exclusaoUsuario(String nomePesquisa) {
        usuarios.removeIf((GerenciadorUsuario u) -> u.getLogin().equalsIgnoreCase(nomePesquisa));
        List<String> lista = new ArrayList<>();
        usuarios.stream().forEach((GerenciadorUsuario u) -> lista.add(u.toString()));
        return GerenciadorArquivo.escreverArquivoClassTruncate(lista, new GerenciadorUsuario().getClass().getSimpleName());
    }

    //Visualizador do objeto
    protected static String visualizadorLivro(String nome) {
        return livros.stream().filter(l -> l.getNome().equalsIgnoreCase(nome)).findFirst().get().toString();
    }
}
