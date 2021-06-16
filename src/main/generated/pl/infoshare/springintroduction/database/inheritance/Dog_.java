package pl.infoshare.springintroduction.database.inheritance;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dog.class)
public abstract class Dog_ extends pl.infoshare.springintroduction.database.inheritance.Animal_ {

	public static volatile SingularAttribute<Dog, BigDecimal> speed;

	public static final String SPEED = "speed";

}

