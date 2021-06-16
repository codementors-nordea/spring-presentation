package pl.infoshare.springintroduction.database.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaEmbeddableAddress.class)
public abstract class JpaEmbeddableAddress_ {

	public static volatile SingularAttribute<JpaEmbeddableAddress, String> zipCode;
	public static volatile SingularAttribute<JpaEmbeddableAddress, String> city;
	public static volatile SingularAttribute<JpaEmbeddableAddress, String> street;

	public static final String ZIP_CODE = "zipCode";
	public static final String CITY = "city";
	public static final String STREET = "street";

}

