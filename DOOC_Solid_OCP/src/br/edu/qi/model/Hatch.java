/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.time.LocalDateTime;

/**
 *
 * @author lg
 */
public class Hatch implements ITipoCarro<Hatch>{

    @Override
    public double obterValor(LocalDateTime localDateTime, ITipoCarro tipoCarro) {
        return localDateTime.getDayOfMonth() * 30;
    }
    
}
