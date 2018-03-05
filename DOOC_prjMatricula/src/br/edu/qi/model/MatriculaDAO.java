/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.List;
import java.util.ArrayList;

public class MatriculaDAO implements IDao<MatriculaVO> {

    private List<MatriculaVO> matriculaArr;

    public MatriculaDAO() {
        this.matriculaArr = new ArrayList<>();
    }

    @Override
    public void save(MatriculaVO t) throws Exception {
        if (!find(t)) {
            matriculaArr.add(t);
        } else {
            throw new Exception("Matricula já cadastrada nessa disciplina");
        }
    }

    @Override
    public boolean find(MatriculaVO t) {
        return matriculaArr.stream().anyMatch(m -> m.getNroMatricula() == t.getNroMatricula() && m.getDisciplina().equals(t.getDisciplina()));
    }

    public List<MatriculaVO> getMatriculaArr() {
        return matriculaArr;
    }

}
