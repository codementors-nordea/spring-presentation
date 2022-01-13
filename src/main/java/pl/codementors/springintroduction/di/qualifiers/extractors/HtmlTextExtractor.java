package pl.codementors.springintroduction.di.qualifiers.extractors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.codementors.springintroduction.di.qualifiers.model.DocumentType;
import pl.codementors.springintroduction.di.qualifiers.model.ImportantDocument;

@Component
@Order(0)
public class HtmlTextExtractor implements TextExtractor {

    private static final String HTML_FORMAT = "<html>%s</html>";

    @Override
    public String extract(ImportantDocument document) {
        return String.format(HTML_FORMAT, document.getFilePath());
    }

    @Override
    public boolean supports(ImportantDocument document) {
        return document.getType() == DocumentType.HTML;
    }
}
