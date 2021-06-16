package pl.infoshare.springintroduction.di.props;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value
@Validated
@ConstructorBinding
@ConfigurationProperties("simple")
public class SimpleProperties {
    @Min(18)
    @NotNull
    Integer age;
    List<String> names;
    NestedProperties nested;
}
