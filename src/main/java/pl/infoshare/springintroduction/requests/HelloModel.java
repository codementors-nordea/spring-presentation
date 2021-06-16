package pl.infoshare.springintroduction.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class HelloModel {

    String message;

    @JsonCreator
    public HelloModel(@JsonProperty("message") String message) {
        this.message = message;
    }
}
