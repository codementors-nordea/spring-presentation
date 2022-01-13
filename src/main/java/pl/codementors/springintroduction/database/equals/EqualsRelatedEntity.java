package pl.codementors.springintroduction.database.equals;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
@ToString(of = {"id", "name"})
public class EqualsRelatedEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private EqualsEntity equalsEntity;

    @Override
    public String toString() {
        return "EqualsRelatedEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
