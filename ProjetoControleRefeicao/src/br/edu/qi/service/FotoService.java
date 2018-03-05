/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Foto;
import br.edu.qi.repository.FotoRepository;
import br.edu.qi.repository.IRepositoryHibernate;
import java.util.List;

/**
 *
 * @author lg
 */
public class FotoService implements IService<Foto> {

    private IRepositoryHibernate repositoryFoto;

    public FotoService() {
        repositoryFoto = new FotoRepository();
    }

    @Override
    public void save(Foto t) throws Exception {
        repositoryFoto.save(t);
    }

    @Override
    public void update(Foto t) throws Exception {
        repositoryFoto.update(t);
    }

    @Override
    public void delete(Foto t) throws Exception {
        repositoryFoto.delete(t);
    }

    @Override
    public List<Foto> findAll() throws Exception {
        return repositoryFoto.findAll();
    }

    @Override
    public List<Foto> findAllWithoutClose() throws Exception {
        return repositoryFoto.findAllWithoutClose();
    }

    @Override
    public Foto findByCod(int cod) throws Exception {
        return (Foto) repositoryFoto.findByCod(cod);
    }

}
