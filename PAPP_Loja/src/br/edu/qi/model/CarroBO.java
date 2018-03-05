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
public class CarroBO {

    private CarroDAO carroDAO;

    public CarroBO() {
        this.carroDAO = new CarroDAO();
    }

    public void save(CarroVO carro) throws Exception {
        carroDAO.save(carro);
    }

    public void remove(CarroVO carro) throws Exception {
        carroDAO.remove(carro);
    }
}
