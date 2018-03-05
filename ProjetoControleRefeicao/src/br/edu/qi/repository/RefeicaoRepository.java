/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.Refeicao;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class RefeicaoRepository extends RepositoryHibernate<Refeicao, Serializable> implements IRepositoryHibernate<Refeicao> {

    public RefeicaoRepository() {
        super(new Refeicao());
    }

}
