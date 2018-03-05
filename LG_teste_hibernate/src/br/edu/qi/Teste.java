/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author lg
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Participante p = new Participante();
        p.setNome("Eduardo");
        p.setEmail("eduardo@teste.com");
        p.setDepartamento("Informática");
        p.setTelefone("9999-9999");
        p.setRamal1("253");
        p.setRamal2("271");
        p.setCelular("8888-8888");

        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(p);

        tx.commit();

        session.flush();
        session.close();
        System.exit(0);
    }

}
