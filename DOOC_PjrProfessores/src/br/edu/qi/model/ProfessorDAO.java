/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lg
 */
public class ProfessorDAO {

    private List<ProfessorVO> professorArr;

    public ProfessorDAO() {
        professorArr = new ArrayList<>();
    }

    public List<ProfessorVO> getProfessorArr() {
        return professorArr;
    }

    public void save(ProfessorVO professorVO) throws Exception {
        if (!find(professorVO)) {
            professorArr.add(professorVO);
        } else {
            throw new Exception("Professor já cadastrado com essa especialização");
        }
    }

    public boolean find(ProfessorVO professorVO) {
        return professorArr.stream().anyMatch(p -> p.equals(professorVO));
    }
}
