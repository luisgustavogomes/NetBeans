/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Menu;
import br.edu.qi.repository.CardapioRepository;
import br.edu.qi.repository.IRepositoryHibernate;
import java.util.List;

/**
 *
 * @author lg
 */
public class CardapioService implements IService<Menu> {

    private IRepositoryHibernate repositoryCardapio;

    public CardapioService() {
        repositoryCardapio = new CardapioRepository();
    }

    @Override
    public void save(Menu t) throws Exception {
        repositoryCardapio.save(t);
    }

    @Override
    public void update(Menu t) throws Exception {
        repositoryCardapio.update(t);
    }

    @Override
    public void delete(Menu t) throws Exception {
        repositoryCardapio.delete(t);
    }

    @Override
    public List<Menu> findAll() throws Exception {
        return repositoryCardapio.findAll();
    }

    @Override
    public List<Menu> findAllWithoutClose() throws Exception {
        return repositoryCardapio.findAllWithoutClose();
    }

    @Override
    public Menu findByCod(int cod) throws Exception {
        return (Menu) repositoryCardapio.findByCod(cod);
    }

}
