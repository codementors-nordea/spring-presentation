package pl.infoshare.springintroduction.database.relationships.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SetAttribute<Product, Basket> baskets;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Customer> customer;

	public static final String BASKETS = "baskets";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String CUSTOMER = "customer";

}

