/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.List;

/**
 *
 * @author lg
 */
public interface IBO<T> {

    public void save(T t) throws Exception;

    public void delete(T t) throws Exception;

    public List<T> findAll() throws Exception;

    public List<T> findAllWithoutClose() throws Exception;

}
