package pl.infoshare.springintroduction.di.qualifiers.extractors;

import org.springframework.stereotype.Component;
import pl.infoshare.springintroduction.di.qualifiers.model.DocumentType;
import pl.infoshare.springintroduction.di.qualifiers.model.ImportantDocument;

@Component
public class SimpleTextExtractor implements TextExtractor {
    private static final String TXT_FORMAT = "Text from txt: %s";

    @Override
    public String extract(ImportantDocument document) {
        return String.format(TXT_FORMAT, document.getFilePath());
    }

    @Override
    public boolean supports(ImportantDocument document) {
        return document.getType() == DocumentType.TXT;
    }
}
