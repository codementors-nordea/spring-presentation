package pl.infoshare.springintroduction.database.relationships.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Basket.class)
public abstract class Basket_ {

	public static volatile SingularAttribute<Basket, Long> id;
	public static volatile SetAttribute<Basket, Product> products;

	public static final String ID = "id";
	public static final String PRODUCTS = "products";

}

