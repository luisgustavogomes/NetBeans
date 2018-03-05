/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.docs;

import Main.IDocumento;
import Main.base.Documento;
import Main.base.ICabecalho;
import Main.base.ICorpo;
import Main.base.IRodape;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lg
 */
public class Html extends Documento implements IDocumento, ICabecalho, ICorpo, IRodape {

    @Override
    public String getOutput() {
        return getOutputCabecalho() + getOutoutCorpo() + getOutputRodape();
    }

    @Override
    public String getOutputCabecalho() {
        return "<html><head><title>" + getTitulo() + "</title></head><body>\n"
                + "<h1>" + getTitulo() + "</h1>\n"
                + "<h2>" + getEmpresa() + "</h2>\n";
    }

    @Override
    public String getOutoutCorpo() {
        return "<p>" + getTexto() + "</p>";
    }

    @Override
    public String getOutputRodape() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "<hr/>" + getData().format(formatador)
                + "</body></html>\n";
    }

}
