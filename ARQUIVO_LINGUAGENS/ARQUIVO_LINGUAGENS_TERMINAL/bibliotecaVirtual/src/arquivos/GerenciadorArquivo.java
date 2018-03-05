/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Luis Gustavo
 */
public class GerenciadorArquivo {
    
    private static Path montarCaminho(String nomeClasse){
        return Paths.get(System.getProperty("user.dir"), nomeClasse + ".txt");
    }

    public static boolean escreverArquivoClassAppend(String conteudo, String nomeClasse) {
        Path p = montarCaminho(nomeClasse);
        try {
            Files.write(p, conteudo.getBytes(Charset.forName("UTF-8")),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND);
            return true;
        } catch (NoSuchFileException y) {
            System.err.format("%s: no such" + " file or directory%n", p);
        } catch (DirectoryNotEmptyException z) {
            System.err.format("%s not empty%n", p);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean escreverArquivoClassTruncate(List<String> conteudo, String nomeClasse) {
        Path p = montarCaminho(nomeClasse);
        try {
            String listaCompletaString = "";
            for (String s : conteudo) {
                listaCompletaString += s;
            }
            Files.write(p, listaCompletaString.getBytes(Charset.forName("UTF-8")),
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );
            return true;
        } catch (NoSuchFileException y) {
            System.err.format("%s: no such" + " file or directory%n", p);
        } catch (DirectoryNotEmptyException z) {
            System.err.format("%s not empty%n", p);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<String> lerArquivoClass(String nomeClasse) {
        Path p = montarCaminho(nomeClasse);
        List<String> str = null;
        if (!Files.exists(p)) {
        } else {
            try {
                str = Files.readAllLines(p, Charset.forName("UTF-8"));
            } catch (NoSuchFileException y) {
                System.err.format("%s: no such" + " file or directory%n", p);
            } catch (DirectoryNotEmptyException z) {
                System.err.format("%s not empty%n", p);
            } catch (IOException ex) {
                Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return str;
    }
    
    public static Boolean apagarArquivoClass(String nomeClasse) {
        Path p = montarCaminho(nomeClasse);
        try {
            Files.delete(p);
            return true;
        } catch (NoSuchFileException y) {
            System.err.format("%s: no such" + " file or directory%n", p);
        } catch (DirectoryNotEmptyException z) {
            System.err.format("%s not empty%n", p);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
