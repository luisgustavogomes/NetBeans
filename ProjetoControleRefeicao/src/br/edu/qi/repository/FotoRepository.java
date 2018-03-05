/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import br.edu.qi.entity.Foto;
import java.io.Serializable;

/**
 *
 * @author lg
 */
public class FotoRepository extends RepositoryHibernate<Foto, Serializable> implements IRepositoryHibernate<Foto> {

    public FotoRepository() {
        super(new Foto());
    }

}
