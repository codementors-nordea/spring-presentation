package pl.infoshare.springintroduction.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.infoshare.springintroduction.validation.exceptions.InfoshareException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotOldEnoughException extends InfoshareException {

    public PersonNotOldEnoughException(String message) {
        super(message, "person.too.young");
    }
}
