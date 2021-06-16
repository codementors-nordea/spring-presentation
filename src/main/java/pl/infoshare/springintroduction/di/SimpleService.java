package pl.infoshare.springintroduction.di;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.infoshare.springintroduction.di.configuration.OutsideDependency;
import pl.infoshare.springintroduction.di.props.SimpleProperties;

@Component
public class SimpleService {

    private String name = "maciek";

    private final PrototypeService prototypeService;
    private final ApplicationContext applicationContext;
    private final OutsideDependency outsideDependency;
    private final SimpleProperties simpleProperties;

    public SimpleService(PrototypeService prototypeService, ApplicationContext applicationContext, OutsideDependency outsideDependency, SimpleProperties simpleProperties) {
        this.prototypeService = prototypeService;
        this.applicationContext = applicationContext;
        this.outsideDependency = outsideDependency;
        this.simpleProperties = simpleProperties;
    }

    void doSomething() {
        applicationContext.getBean(PrototypeService.class).doSomething();
        applicationContext.getBean(PrototypeService.class).doSomething();
        applicationContext.getBean(PrototypeService.class).doSomething();
    }


}
