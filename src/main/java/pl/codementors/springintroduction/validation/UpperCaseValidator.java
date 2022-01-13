package pl.codementors.springintroduction.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class UpperCaseValidator implements ConstraintValidator<Uppercase, String> {

    private String endsWith;

    @Override
    public void initialize(Uppercase constraintAnnotation) {
        this.endsWith = constraintAnnotation.endsWith();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return true;
        }

        return value.toUpperCase().equals(value) && value.endsWith(endsWith);
    }
}
