/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Pessoa;
import br.edu.qi.repository.IRepositoryHibernate;
import br.edu.qi.repository.PessoaRepository;
import java.util.List;

/**
 *
 * @author lg
 */
public class PessoaService implements IService<Pessoa> {

    private IRepositoryHibernate repositoryPessoa;

    public PessoaService() {
        repositoryPessoa = new PessoaRepository();
    }

    @Override
    public void save(Pessoa t) throws Exception {
        repositoryPessoa.save(t);
    }

    @Override
    public void update(Pessoa t) throws Exception {
        repositoryPessoa.update(t);
    }

    @Override
    public void delete(Pessoa t) throws Exception {
        repositoryPessoa.delete(t);
    }

    @Override
    public List<Pessoa> findAll() throws Exception {
        return repositoryPessoa.findAll();
    }

    @Override
    public List<Pessoa> findAllWithoutClose() throws Exception {
        return repositoryPessoa.findAllWithoutClose();
    }

    @Override
    public Pessoa findByCod(int cod) throws Exception {
        return (Pessoa) repositoryPessoa.findByCod(cod);
    }

}
