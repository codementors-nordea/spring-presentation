package pl.infoshare.springintroduction.database.relationships.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, Customer> customer;

	public static final String ADDRESS = "address";
	public static final String ID = "id";
	public static final String CUSTOMER = "customer";

}

