package pl.infoshare.springintroduction.database.equals;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;


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
