package br.edu.qi.util;

import br.edu.qi.view.TestePessoa1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpDate {

    /**
     *
     * @param srtData String no padrão "dd/MM/yyyy"
     * @return converte no Objeto Date
     */
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date converterStringData(String srtData) {
        Date data = null;
        try {
            data = format.parse(srtData);
        } catch (ParseException ex) {
            Logger.getLogger(TestePessoa1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /**
     *
     * @param data
     * @return String formato 'BR'
     */
    public static String retornarDataString(Date data) {
        return format.format(data);
    }
}
