/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lg
 */
public class HelperLocalDate {

    static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatador(LocalDate localDate) {
        return localDate.format(formatador);
    }
}
