package pl.infoshare.springintroduction.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpperCaseValidator.class)
public @interface Uppercase {

    String endsWith();
    String startsWith();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
