package pl.codementors.springintroduction.validation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Schema(description = "Model osoby")
public class Person {

    @Min(18)
    int age;

    @NotBlank
    @Schema(description = "Imie osoby")
    String name;

    @Valid
    @NotNull
    Parent parent;

}
