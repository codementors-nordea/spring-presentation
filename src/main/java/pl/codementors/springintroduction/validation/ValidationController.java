package pl.codementors.springintroduction.validation;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ValidationController {

    private final PersonCreateService personCreateService;

    @PostMapping("/people")
    @Operation(description = "Tworzy nowa osobe")
    public void createPerson(@Valid @RequestBody Person person) {
        personCreateService.create(person);
    }

    @PutMapping("/people/{id}")
    public void updatePerson(@Validated(PersonValidations.Update.class) @RequestBody Person person, @PathVariable String id) {
    }


}
