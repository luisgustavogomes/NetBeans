/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.docs_factory.HtmlFactory;
import Main.docs_factory.LatexFactory;
import Main.docs_factory.MarkdownFactory;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IDocumento documento;
        IDocumentoFactory factoryDocumento;
        
        
        factoryDocumento = new HtmlFactory();
        documento = factoryDocumento.criarDocumento();
        System.out.println(documento.getOutput());
        
        factoryDocumento = new LatexFactory();
        documento = factoryDocumento.criarDocumento();
        System.out.println(documento.getOutput());
        
        factoryDocumento = new MarkdownFactory();
        documento = factoryDocumento.criarDocumento();
        System.out.println(documento.getOutput());
    }

}
