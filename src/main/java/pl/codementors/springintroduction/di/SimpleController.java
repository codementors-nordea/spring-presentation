package pl.codementors.springintroduction.di;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleService simpleService;
    private final RequestService requestService;

    @GetMapping("/scope-test")
    void scopeTest() {
        simpleService.doSomething();
    }

    @GetMapping("/request-scope-test")
    void requestScopeTest() {
        requestService.doSomething();
        requestService.doSomething();
        requestService.doSomething();
    }

}
