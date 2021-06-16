package pl.infoshare.springintroduction.database.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@DiscriminatorValue("dog")
public class Dog extends Animal {

    private BigDecimal speed;

}
