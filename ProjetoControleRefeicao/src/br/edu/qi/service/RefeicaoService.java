/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Refeicao;
import br.edu.qi.repository.IRepositoryHibernate;
import br.edu.qi.repository.RefeicaoRepository;
import java.util.List;

/**
 *
 * @author lg
 */
public class RefeicaoService implements IService<Refeicao> {

    private IRepositoryHibernate repositoryRefeicao;

    public RefeicaoService() {
        repositoryRefeicao = new RefeicaoRepository();
    }

    @Override
    public void save(Refeicao t) throws Exception {
        repositoryRefeicao.save(t);
    }

    @Override
    public void update(Refeicao t) throws Exception {
        repositoryRefeicao.update(t);
    }

    @Override
    public void delete(Refeicao t) throws Exception {
        repositoryRefeicao.delete(t);
    }

    @Override
    public List<Refeicao> findAll() throws Exception {
        return repositoryRefeicao.findAll();
    }

    @Override
    public List<Refeicao> findAllWithoutClose() throws Exception {
        return repositoryRefeicao.findAllWithoutClose();
    }

    @Override
    public Refeicao findByCod(int cod) throws Exception {
        return (Refeicao) repositoryRefeicao.findByCod(cod);
    }

}
