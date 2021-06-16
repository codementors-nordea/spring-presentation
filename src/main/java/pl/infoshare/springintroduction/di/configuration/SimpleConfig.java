package pl.infoshare.springintroduction.di.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
