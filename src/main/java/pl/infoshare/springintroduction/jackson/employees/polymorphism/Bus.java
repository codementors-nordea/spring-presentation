package pl.infoshare.springintroduction.jackson.employees.polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Bus implements Vehicle {
    Integer numberOfPassengers;
    Integer maxSpeed;

    @JsonCreator
    public Bus(@JsonProperty("numberOfPassengers") Integer numberOfPassengers,
               @JsonProperty("maxSpeed") Integer maxSpeed) {
        this.numberOfPassengers = numberOfPassengers;
        this.maxSpeed = maxSpeed;
    }
}
