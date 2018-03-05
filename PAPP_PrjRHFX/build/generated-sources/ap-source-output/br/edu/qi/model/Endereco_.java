package br.edu.qi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SetAttribute<Endereco, Pessoa> pessoas;
	public static volatile SingularAttribute<Endereco, Integer> numero;
	public static volatile SingularAttribute<Endereco, Integer> idendereco;
	public static volatile SingularAttribute<Endereco, String> rua;

}

