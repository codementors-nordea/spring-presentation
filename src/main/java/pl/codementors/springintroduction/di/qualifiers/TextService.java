package pl.codementors.springintroduction.di.qualifiers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.codementors.springintroduction.di.qualifiers.extractors.TextExtractor;
import pl.codementors.springintroduction.di.qualifiers.model.ImportantDocument;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TextService {

    private static final String ERROR_MESSAGE =  "No extractor for type: %s.";

    private final List<TextExtractor> textExtractors;


    public String extract(ImportantDocument document) {
        return textExtractors.stream()
                .filter(extractor -> extractor.supports(document))
                .findFirst()
                .map(extractor -> extractor.extract(document))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(ERROR_MESSAGE, document.getType())));
    }
}
