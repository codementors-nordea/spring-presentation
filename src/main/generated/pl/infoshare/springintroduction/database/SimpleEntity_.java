package pl.infoshare.springintroduction.database;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SimpleEntity.class)
public abstract class SimpleEntity_ {

	public static volatile SingularAttribute<SimpleEntity, LocalDate> modificationDate;
	public static volatile SingularAttribute<SimpleEntity, String> name;
	public static volatile SingularAttribute<SimpleEntity, Long> id;
	public static volatile SingularAttribute<SimpleEntity, Long> version;
	public static volatile SingularAttribute<SimpleEntity, Integer> age;
	public static volatile SingularAttribute<SimpleEntity, LocalDate> createDate;

	public static final String MODIFICATION_DATE = "modificationDate";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String AGE = "age";
	public static final String CREATE_DATE = "createDate";

}

