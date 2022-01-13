package pl.codementors.springintroduction.di.qualifiers.extractors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.codementors.springintroduction.di.qualifiers.model.DocumentType;
import pl.codementors.springintroduction.di.qualifiers.model.ImportantDocument;

@Component
@Order(1)
public class PdfTextExtractor implements TextExtractor {
    private static final String PDF_FORMAT = "Text from pdf: %s";

    @Override
    public String extract(ImportantDocument document) {
        return String.format(PDF_FORMAT, document.getFilePath());
    }

    @Override
    public boolean supports(ImportantDocument document) {
        return document.getType() == DocumentType.PDF;
    }
}
