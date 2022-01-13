package pl.codementors.springintroduction.di.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropService {

    public PropService(@Value("${my.own.config}") List<String> prop) {
        System.out.println("My prop " + prop);
    }
}
