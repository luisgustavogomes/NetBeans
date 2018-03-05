/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.utl;

import br.edu.qi.model.CarroVO;
import br.edu.qi.view.CarroModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lg
 */
public class HelperAdapter {

    public static List<CarroModel> adater(List<CarroVO> carroVoArr) {
        List<CarroModel> carroModelArr = new ArrayList<>();
        for (CarroVO carroVO : carroVoArr) {
            CarroModel carroModel = new CarroModel();
            carroModel.setProprietario(carroVO.getProprietario());
            carroModel.setAno(carroVO.getAno());
            carroModel.setMarca(carroVO.getMarca());
            carroModel.setModelo(carroVO.getModelo());
            carroModel.setCor(carroVO.getCor());
            carroModel.setDescricao(carroVO.getDescricao());
            carroModel.setArCondicionado(carroVO.isArCondicionado());
            carroModel.setTocaFita(carroVO.isTocaFita());
            carroModel.setRodaLiga(carroVO.isRodaLiga());
            carroModel.setTapetes(carroVO.isTapetes());
            carroModel.setAlarme(carroVO.isAlarme());
            carroModel.setTipo(carroVO.getTipo());
            carroModel.setEstado(carroVO.getEstado());
            carroModel.setKm(carroVO.getKm());
            carroModel.setValor(carroVO.getValor());
            carroModelArr.add(carroModel);
        }
        return carroModelArr;
    }
}
