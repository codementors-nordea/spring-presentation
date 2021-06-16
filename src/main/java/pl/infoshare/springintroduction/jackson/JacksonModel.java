package pl.infoshare.springintroduction.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.Valid;
import java.time.LocalDate;

@Value
public class JacksonModel {
    @JsonProperty(value = "firstName", access = JsonProperty.Access.READ_ONLY)
    String name;
    String lastName;
    @JsonIgnore
    Integer age;
    @JsonFormat(pattern = "yyMMdd")
    LocalDate date;

    @JsonProperty("surname")
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

}
