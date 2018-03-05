/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.modelo;

import br.edu.qi.modelo.Conta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author lg
 */
public class Teste {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Conta conta = new Conta();
        conta.setTitular("Luis");
        conta.setAgencia("123");
        conta.setBanco("BB");
        conta.setNumero("987");
        
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(conta);

        tx.commit();

        session.flush();
        session.close();
        System.exit(0);

    }
}
