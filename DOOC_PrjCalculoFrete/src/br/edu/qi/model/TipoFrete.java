/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public enum TipoFrete {
    PADRAO {
        @Override
        public Frete ObterFrete() {
            return new Padrao();
        }
    },
    EXPRESSO {
        @Override
        public Frete ObterFrete() {
            return new Expresso();
        }
    };

    public abstract Frete ObterFrete();
}
