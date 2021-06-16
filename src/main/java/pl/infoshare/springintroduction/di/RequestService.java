package pl.infoshare.springintroduction.di;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService {

    private int counter = 0;

    @PostConstruct
    void init() {
        System.out.println("Request scope init");
    }

    void doSomething() {
        System.out.println("Current counter " + counter);
        counter++;
    }


}
