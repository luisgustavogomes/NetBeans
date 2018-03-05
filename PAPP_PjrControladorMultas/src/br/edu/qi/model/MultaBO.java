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
public class MultaBO {

    private static MultaBO instancia;
    private static MultaDAO dao;

    public MultaBO() {
    }

    public static MultaBO getInstancia() {
        if (instancia == null) {
            instancia = new MultaBO();
            dao = new MultaDAO();
        }
        return instancia;
    }

    public void save(MultaVO multaVO) throws Exception {
        dao.save(multaVO);
    }

    public static MultaDAO getDao() {
        return dao;
    }

    public int percentual(int velocidadePemitida, int velocidadeVelocidade) {
        int resultado =  ((velocidadeVelocidade * 100)/ velocidadePemitida ) - 100;
        return resultado;
    }
    
    public double valorApagar(int percentual){
        if (percentual >= 20 && percentual < 30) {
            return 85;
        }
        if (percentual >= 30 && percentual < 40) {
            return 150;
        }
        if (percentual >= 40 && percentual <= 50) {
            return 250;
        }
        if (percentual > 50) {
            return 2000;
        }
        return 0;
    }

}
