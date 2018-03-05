/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.ParametroEmail;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class ConfiguracaoRepository extends RepositoryHibernate<ParametroEmail, Serializable> implements IRepositoryHibernate<ParametroEmail> {

    public ConfiguracaoRepository() {
        super(new ParametroEmail());
    }

}
