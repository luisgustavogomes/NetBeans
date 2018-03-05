/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author Luis Gustavo
 */
public class MatriculaBO {
    
    private MatriculaDAO dao;
    
    public MatriculaBO() {
        this.dao = new MatriculaDAO();
    }
    
    public void save(MatriculaVO matricula) throws Exception {
        dao.save(matricula);
    }
    
    public double findValor(MatriculaVO matricula) {
        return dao.getMatriculaArr().stream().filter((MatriculaVO m) -> m.getNroMatricula() == matricula.getNroMatricula()).mapToDouble(m -> m.getValor()).sum();
    }
    
    public void calcularValor(MatriculaVO matricula) {
        if (matricula.getDesconto() > 0) {
            matricula.setValor(matricula.getValor() - (matricula.getValor() * (matricula.getDesconto() / 100)));
        } 
    }
    
}
