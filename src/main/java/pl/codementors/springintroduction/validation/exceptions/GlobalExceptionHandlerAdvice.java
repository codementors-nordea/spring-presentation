package pl.codementors.springintroduction.validation.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(ApplicationException exception) {
        return ErrorResponse.singleError(new SimpleError(exception.getMessage(), exception.getErrorCode()), 400);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var errors = ex.getFieldErrors()
                .stream()
                .map(fieldError -> new SimpleError(fieldError.getField() + " " + fieldError.getDefaultMessage(), fieldError.getCode()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ErrorResponse(400, errors));
    }
}
