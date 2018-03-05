/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.Instituicao;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class InstituicaoRepository extends RepositoryHibernate<Instituicao, Serializable> implements IRepositoryHibernate<Instituicao> {

    public InstituicaoRepository() {
        super(new Instituicao());
    }

}
