package pl.codementors.springintroduction.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonCreateService {

    private final PersonComplexValidator personComplexValidator;

    void create(Person person) {
        if (!personComplexValidator.isOldEnough(person)) {
            throw new PersonNotOldEnoughException("Person is not old enough");
        }



    }
}
