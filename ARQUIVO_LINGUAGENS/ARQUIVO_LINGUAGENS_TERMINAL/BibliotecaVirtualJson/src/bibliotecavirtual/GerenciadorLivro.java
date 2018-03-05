/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Aluno
 */
public class GerenciadorLivro {
    
    private static final String ARQUIVO_LIVROS = "livros.txt";
    
    /*public static List<Livro> retornarTodos(){
        return retornarTodos(false);
    }*/
    
    public static List<Livro> retornarTodosJSON(){
        return retornarTodos(true);
    }
    
    private static List<Livro> retornarTodos(boolean isJson){
        List<Livro> livros = new ArrayList<>();
        if(isJson){
            for(JSONObject obj : GerenciadorArquivo.lerArquivoJSON(ARQUIVO_LIVROS)){
                livros.add(new Livro(obj));
            }
        }
        else{
            for(String linha : GerenciadorArquivo.lerArquivo(ARQUIVO_LIVROS)){
                //livros.add(new Livro(linha));
            }
        }
        return livros;
    }
    
    public static List<Livro> pesquisar(String termo){
        termo = termo.toLowerCase();
        List<Livro> livros = new ArrayList<>();
        for(String linha : GerenciadorArquivo.lerArquivo(ARQUIVO_LIVROS)){
            //if(linha.toLowerCase().contains(termo))
                //livros.add(new Livro(linha));
        }
        return livros;
    }
    
    public static boolean adicionarLivro(String titulo, String autor, int ano){
        List<Livro> livros = retornarTodosJSON();
        int maxCodigo = 0;
        
        if(livros.size() > 0)
            maxCodigo = livros.stream().max((Livro l1, Livro l2) -> Integer.compare(l1.getCodigo(), l2.getCodigo()) ).get().getCodigo();
        
        Livro livro = new Livro(++maxCodigo, titulo, autor, ano);
        livros.add(livro);
        
        JSONArray array = new JSONArray();
        for (Livro l : livros) {
            array.add(l.toJSON());
        }
        
        return GerenciadorArquivo.sobrescreverArquivo(ARQUIVO_LIVROS, array.toJSONString());
    }
    
    
}
