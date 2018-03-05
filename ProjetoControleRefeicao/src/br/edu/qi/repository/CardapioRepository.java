/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.Menu;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class CardapioRepository extends RepositoryHibernate<Menu, Serializable> implements IRepositoryHibernate<Menu> {

    public CardapioRepository() {
        super(new Menu());
    }

}
