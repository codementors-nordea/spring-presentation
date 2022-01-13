package pl.codementors.springintroduction.validation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class Parent {
    @NotBlank
    @Uppercase(endsWith = "KOZIARA", startsWith = "MACIEK")
    String name;

    @JsonCreator
    public Parent(@JsonProperty("name") String name) {
        this.name = name;
    }
}
