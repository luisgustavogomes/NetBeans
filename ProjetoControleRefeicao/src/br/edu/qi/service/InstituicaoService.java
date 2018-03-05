/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Instituicao;
import br.edu.qi.repository.IRepositoryHibernate;
import br.edu.qi.repository.InstituicaoRepository;
import java.util.List;

/**
 *
 * @author lg
 */
public class InstituicaoService implements IService<Instituicao> {

    private IRepositoryHibernate repositoryInstituicao;

    public InstituicaoService() {
        repositoryInstituicao = new InstituicaoRepository();
    }

    @Override
    public void save(Instituicao t) throws Exception {
        repositoryInstituicao.save(t);
    }

    @Override
    public void update(Instituicao t) throws Exception {
        repositoryInstituicao.update(t);
    }

    @Override
    public void delete(Instituicao t) throws Exception {
        repositoryInstituicao.delete(t);
    }

    @Override
    public List<Instituicao> findAll() throws Exception {
        return repositoryInstituicao.findAll();
    }

    @Override
    public List<Instituicao> findAllWithoutClose() throws Exception {
        return repositoryInstituicao.findAllWithoutClose();
    }

    @Override
    public Instituicao findByCod(int cod) throws Exception {
        return (Instituicao) repositoryInstituicao.findByCod(cod);
    }

}
