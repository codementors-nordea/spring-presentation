package pl.codementors.springintroduction.di.qualifiers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.springintroduction.di.qualifiers.model.ImportantDocument;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final TextService textService;

    @PostMapping("/documents")
    String extractTextFromDocument(@RequestBody ImportantDocument document) {
        return textService.extract(document);
    }
}
