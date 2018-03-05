/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import br.edu.qi.model.Pessoa;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lg
 */
public class HelperHibernate {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void persistePessoa(Pessoa p) {
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(p.getEndereco());
        tr.commit();
        tr = null;
        ss.close();
    }

    public static List<Pessoa> listarPessoas() {
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Criteria crit = ss.createCriteria(Pessoa.class);
        List<Pessoa> listp;
        listp = crit.list();
        crit.list();
        return listp;
    }
}
