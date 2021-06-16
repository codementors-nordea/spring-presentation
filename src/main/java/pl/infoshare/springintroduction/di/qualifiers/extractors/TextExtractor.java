package pl.infoshare.springintroduction.di.qualifiers.extractors;

import pl.infoshare.springintroduction.di.qualifiers.model.ImportantDocument;

public interface TextExtractor {

    String extract(ImportantDocument document);

    boolean supports(ImportantDocument document);
}
