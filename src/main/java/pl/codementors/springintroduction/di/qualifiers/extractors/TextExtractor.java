package pl.codementors.springintroduction.di.qualifiers.extractors;

import pl.codementors.springintroduction.di.qualifiers.model.ImportantDocument;

public interface TextExtractor {

    String extract(ImportantDocument document);

    boolean supports(ImportantDocument document);
}
