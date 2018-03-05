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
public class ProfessorBO {

    private static ProfessorBO instancia;
    private static ProfessorDAO dao;

    public ProfessorBO() {
    }

    public static ProfessorBO getIntancia() {
        if (instancia == null) {
            instancia = new ProfessorBO();
            dao = new ProfessorDAO();
        }
        return instancia;
    }

    public void save(ProfessorVO professorVO) throws Exception {
        dao.save(professorVO);
    }
    
    public float bonus(ProfessorVO professorVO){
        return !professorVO.isAndamento() ? professorVO.getFormacao() : professorVO.getFormacao() / 2;
    }

    public float total(ProfessorVO professorVO) {
        return professorVO.getSalario() + bonus(professorVO);
    }

}
