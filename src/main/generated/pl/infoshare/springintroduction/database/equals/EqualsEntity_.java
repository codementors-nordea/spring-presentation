package pl.infoshare.springintroduction.database.equals;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EqualsEntity.class)
public abstract class EqualsEntity_ {

	public static volatile SingularAttribute<EqualsEntity, String> name;
	public static volatile SingularAttribute<EqualsEntity, Integer> id;
	public static volatile SingularAttribute<EqualsEntity, UUID> uuid;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String UUID = "uuid";

}

