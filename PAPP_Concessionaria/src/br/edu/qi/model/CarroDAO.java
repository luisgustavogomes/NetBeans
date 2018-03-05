/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.utl.HelperStrings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lg
 */
public class CarroDAO {

    private List<CarroVO> carroArr;

    public CarroDAO() {
        this.carroArr = new ArrayList<>();
    }

    public void save(CarroVO carro) throws Exception {
        if (!find(carro)) {
            carroArr.add(HelperStrings.AdapterString(carro));
        } else {
            throw new Exception("Carro já cadastrado!");
        }
    }

    public void remove(CarroVO carro) throws Exception {
        try {
            carroArr.removeIf(c -> c.equals(carro));
        } catch (Exception ex) {
            throw new Exception("Impossivel remover!");
        }

    }

    public boolean find(CarroVO carro) {
        return carroArr.stream().anyMatch((CarroVO c)
                -> c.getProprietario().equalsIgnoreCase(carro.getProprietario())
                && c.getModelo().equalsIgnoreCase(carro.getModelo())
                && c.getAno() == carro.getAno()
                && c.getEstado().equalsIgnoreCase(carro.getEstado())
        );
    }

    public List<CarroVO> getCarroArr() {
        return carroArr;
    }

}
