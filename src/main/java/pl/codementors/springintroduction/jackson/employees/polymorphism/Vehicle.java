package pl.codementors.springintroduction.jackson.employees.polymorphism;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Bus.class, name = "bus")
})
public interface Vehicle {

    Integer getMaxSpeed();
}
