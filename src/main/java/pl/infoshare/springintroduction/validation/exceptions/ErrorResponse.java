package pl.infoshare.springintroduction.validation.exceptions;

import lombok.Value;

import java.util.List;

@Value
public class ErrorResponse {

    Integer errorCode;
    List<SimpleError> errors;

    public static ErrorResponse singleError(SimpleError error, Integer errorCode) {
        return new ErrorResponse(errorCode, List.of(error));
    }
}
