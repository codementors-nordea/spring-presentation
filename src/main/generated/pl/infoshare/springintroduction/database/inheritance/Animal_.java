package pl.infoshare.springintroduction.database.inheritance;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, String> name;
	public static volatile SingularAttribute<Animal, Long> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

