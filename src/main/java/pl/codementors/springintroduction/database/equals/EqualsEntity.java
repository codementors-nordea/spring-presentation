package pl.codementors.springintroduction.database.equals;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "uuid")
public class EqualsEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private UUID uuid = UUID.randomUUID();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EqualsEntity that = (EqualsEntity) o;
//        return Objects.equals(externalId, that.externalId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(externalId);
//    }

    @Override
    public String toString() {
        return "EqualsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
