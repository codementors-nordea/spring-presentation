package pl.codementors.springintroduction.database.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("cat")
public class Cat extends Animal {

    private String color;

}
