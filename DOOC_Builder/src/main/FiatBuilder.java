/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author lg
 */
public class FiatBuilder extends CarroBuilder {

    @Override
    public void buildPreco() {
        carro.preco = 1000.00;
    }

    @Override
    public void buildDscMotor() {
        carro.dscMotor = "1.0 Flex";
    }

    @Override
    public void buildAnoDeFabricacao() {
        carro.anoDeFabricacao = 2010;
    }

    @Override
    public void buildModelo() {
        carro.modelo = "Palio";
    }

    @Override
    public void buildMontadora() {
        carro.montadora = "Fiat";
    }
}
