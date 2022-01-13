package pl.codementors.springintroduction.database.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")
//@MappedSuperclass
@Entity
public abstract class Animal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
