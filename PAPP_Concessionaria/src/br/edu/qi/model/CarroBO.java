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

    public static CarroBO instancia;

    private static CarroDAO carroDAO;

    private CarroBO() {

    }

    public static CarroBO getInstancia() {
        if (instancia == null) {
            carroDAO = new CarroDAO();
            instancia = new CarroBO();
        }
        return instancia;
    }

    public void save(CarroVO carro) throws Exception {
        carroDAO.save(carro);
    }

    public void remove(CarroVO carro) throws Exception {
        carroDAO.remove(carro);
    }

    public CarroDAO getCarroDAO() {
        return carroDAO;
    }

}
