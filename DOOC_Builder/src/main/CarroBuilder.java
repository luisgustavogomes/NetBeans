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
public abstract class CarroBuilder {

    protected CarroProduct carro = new CarroProduct();

    public abstract void buildPreco();

    public abstract void buildDscMotor();

    public abstract void buildAnoDeFabricacao();

    public abstract void buildModelo();

    public abstract void buildMontadora();

    public CarroProduct getCarro() {
        return carro;
    }

}
