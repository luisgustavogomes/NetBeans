/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.Pessoa;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class PessoaRepository extends RepositoryHibernate<Pessoa, Serializable> implements IRepositoryHibernate<Pessoa> {

    public PessoaRepository() {
        super(new Pessoa());
    }

}
