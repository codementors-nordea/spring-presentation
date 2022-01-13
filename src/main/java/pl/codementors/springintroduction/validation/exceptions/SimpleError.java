package pl.codementors.springintroduction.validation.exceptions;

import lombok.Value;

@Value
public class SimpleError {
    String message;
    String errorCode;
}
