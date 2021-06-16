package pl.infoshare.springintroduction.validation;

import lombok.Value;

@Value
public class SimpleError {
    String message;
    String errorCode;
}
