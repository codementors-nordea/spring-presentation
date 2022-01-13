package pl.codementors.springintroduction.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.codementors.springintroduction.validation.exceptions.ApplicationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotOldEnoughException extends ApplicationException {

    public PersonNotOldEnoughException(String message) {
        super(message, "person.too.young");
    }
}
