package pl.codementors.springintroduction.validation;

import org.springframework.stereotype.Component;

@Component
public class PersonComplexValidator {

    boolean isOldEnough(Person person) {
        return person.getAge() > 18;
    }
}
