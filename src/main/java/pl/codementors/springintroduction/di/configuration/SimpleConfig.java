package pl.codementors.springintroduction.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

    @Bean
    OutsideDependency outsideDependency() {
        return new OutsideDependency();
    }

    @Bean
    SecondOutsideDependency secondOutsideDependency(OutsideDependency outsideDependency) {
        var first = outsideDependency();
        var second = outsideDependency();
        return new SecondOutsideDependency(outsideDependency);
    }

}
