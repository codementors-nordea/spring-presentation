package pl.infoshare.springintroduction.di.configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecondOutsideDependency {

    private final OutsideDependency outsideDependency;

}
