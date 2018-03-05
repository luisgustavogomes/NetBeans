/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Aluno
 */
public class GerenciadorArquivo {
    
    private static Path montarCaminho(String nomeArquivo){
        return Paths.get(System.getProperty("user.dir"), nomeArquivo);
    }
    
    public static List<String> lerArquivo(String nomeArquivo){
        Path caminho = montarCaminho(nomeArquivo);
        try {
            if(Files.exists(caminho))
                return Files.readAllLines(caminho);
            else
                return new ArrayList<String>();
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<JSONObject> lerArquivoJSON(String nomeArquivo){
        List<String> linhas = lerArquivo(nomeArquivo);
        String conteudo = "";
        for (String linha : linhas) {
            conteudo += linha;
        }
        
        JSONArray array = (JSONArray)JSONValue.parse(conteudo);
        List<JSONObject> retorno = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            retorno.add((JSONObject)array.get(i));
        }
        return retorno;
    }
    
    public static boolean sobrescreverArquivo(String nomeArquivo, String conteudo){
        return escreverArquivo(nomeArquivo, conteudo, true);
    }
    
    public static boolean escreverArquivo(String nomeArquivo, String conteudo){
        return escreverArquivo(nomeArquivo, conteudo, false);
    }
    
    private static boolean escreverArquivo(String nomeArquivo, String conteudo, boolean sobrescrever){
        Path caminho = montarCaminho(nomeArquivo);
        try {
            
            Files.write(caminho, conteudo.getBytes(), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE, sobrescrever ?
                                            StandardOpenOption.TRUNCATE_EXISTING
                                           : StandardOpenOption.APPEND);
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
