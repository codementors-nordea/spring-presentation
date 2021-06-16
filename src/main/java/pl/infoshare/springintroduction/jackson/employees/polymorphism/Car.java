package pl.infoshare.springintroduction.jackson.employees.polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Car implements Vehicle {
    String color;
    Integer maxSpeed;

    @JsonCreator
    public Car(@JsonProperty("color") String color,
               @JsonProperty("maxSpeed") Integer maxSpeed) {
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
