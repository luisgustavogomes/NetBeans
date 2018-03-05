/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.ParametroEmail;
import br.edu.qi.repository.ConfiguracaoRepository;
import br.edu.qi.repository.IRepositoryHibernate;
import java.util.List;

/**
 *
 * @author lg
 */
public class ConfiguracaoService implements IService<ParametroEmail> {

    private IRepositoryHibernate configuracaoRepository;

    public ConfiguracaoService() {
        configuracaoRepository = new ConfiguracaoRepository();
    }

    @Override
    public void save(ParametroEmail t) throws Exception {
        configuracaoRepository.save(t);
    }

    @Override
    public void update(ParametroEmail t) throws Exception {
        configuracaoRepository.update(t);
    }

    @Override
    public void delete(ParametroEmail t) throws Exception {
        configuracaoRepository.delete(t);
    }

    @Override
    public List<ParametroEmail> findAll() throws Exception {
        return configuracaoRepository.findAll();
    }

    @Override
    public List<ParametroEmail> findAllWithoutClose() throws Exception {
        return configuracaoRepository.findAllWithoutClose();
    }

    @Override
    public ParametroEmail findByCod(int cod) throws Exception {
        return (ParametroEmail) configuracaoRepository.findByCod(cod);
    }

}
