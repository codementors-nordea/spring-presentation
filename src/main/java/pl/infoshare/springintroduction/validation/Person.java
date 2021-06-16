package pl.infoshare.springintroduction.validation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Value
@Schema(description = "Model osoby")
public class Person {

    int age;

    @NotBlank
    @Schema(description = "Imie osoby")
    String name;

}
