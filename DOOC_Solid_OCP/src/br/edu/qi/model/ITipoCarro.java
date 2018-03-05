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
public interface ITipoCarro<T> {

    public double obterValor(LocalDateTime localDateTime, ITipoCarro tipoCarro);

}
