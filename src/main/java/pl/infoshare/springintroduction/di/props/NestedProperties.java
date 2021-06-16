package pl.infoshare.springintroduction.di.props;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class NestedProperties {

    @NotBlank
    String city;

}
