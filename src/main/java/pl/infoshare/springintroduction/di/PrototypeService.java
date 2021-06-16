package pl.infoshare.springintroduction.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class PrototypeService {

    @PostConstruct
    void init() {
        System.out.println("Init from prototype");
    }

    void doSomething() {
        System.out.println("Doing something prototype");
    }

}
