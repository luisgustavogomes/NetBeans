package br.edu.qi.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, String> numero;
	public static volatile SingularAttribute<Conta, String> banco;
	public static volatile SingularAttribute<Conta, Integer> id;
	public static volatile SingularAttribute<Conta, String> titular;
	public static volatile SingularAttribute<Conta, String> agencia;

}

