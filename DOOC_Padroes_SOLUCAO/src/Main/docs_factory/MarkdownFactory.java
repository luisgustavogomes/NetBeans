/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.docs_factory;

import Main.IDocumento;
import Main.IDocumentoFactory;
import Main.docs.Markdown;

/**
 *
 * @author lg
 */
public class MarkdownFactory implements IDocumentoFactory{

    @Override
    public IDocumento criarDocumento() {
        return new Markdown();
    }
    
}
