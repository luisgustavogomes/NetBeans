/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.repository;

import java.util.List;

/**
 *
 * @author lg
 */
public interface IRepositoryHibernate<T> {

    void save(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findAllWithoutClose() throws Exception;

    T findByCod(int cod) throws Exception;
}
