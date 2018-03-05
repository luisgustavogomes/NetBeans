/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.utl;

import br.edu.qi.model.CarroVO;

/**
 *
 * @author lg
 */
public class HelperStrings {
    
    public static CarroVO AdapterString(CarroVO carro){
        CarroVO carroAjusted = new CarroVO(
                carro.getProprietario().trim().toUpperCase(), 
                carro.getAno(), 
                carro.getMarca().trim().toUpperCase(), 
                carro.getModelo().trim().toUpperCase(), 
                carro.getCor().trim().toUpperCase(), 
                carro.getDescricao().trim().toUpperCase(), 
                carro.isArCondicionado(), 
                carro.isTocaFita(), 
                carro.isRodaLiga(), 
                carro.isTapetes(), 
                carro.isAlarme(), 
                carro.getTipo().trim().toUpperCase(), 
                carro.getEstado().trim().toUpperCase(), 
                carro.getKm(), 
                carro.getValor());
        return carroAjusted;
    }
    
    public static boolean isText (String str){
        try {
            return str.matches("^[a-zA-Z\\s]+");
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isTextOrNumber (String str){
        try {
            return str.matches("^[a-zA-Z0-9\\s]+");
        } catch (Exception e) {
            return false;
        }
    }
}
