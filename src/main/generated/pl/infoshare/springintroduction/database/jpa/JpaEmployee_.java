package pl.infoshare.springintroduction.database.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaEmployee.class)
public abstract class JpaEmployee_ {

	public static volatile SingularAttribute<JpaEmployee, JpaEmbeddableAddress> address;
	public static volatile SingularAttribute<JpaEmployee, JpaContractType> contractType;
	public static volatile SingularAttribute<JpaEmployee, String> name;
	public static volatile SingularAttribute<JpaEmployee, Long> id;
	public static volatile SingularAttribute<JpaEmployee, Integer> age;

	public static final String ADDRESS = "address";
	public static final String CONTRACT_TYPE = "contractType";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AGE = "age";

}

