package pl.infoshare.springintroduction.di.qualifiers.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.nio.file.Path;

@Value
public class ImportantDocument {

    Path filePath;
    DocumentType type;

    @JsonCreator
    public ImportantDocument(@JsonProperty("filePath") Path filePath,
                             @JsonProperty("type") DocumentType type) {
        this.filePath = filePath;
        this.type = type;
    }
}
