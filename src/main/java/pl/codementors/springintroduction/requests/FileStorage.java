package pl.codementors.springintroduction.requests;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorage {

    private final static Path STORAGE_PATH = Paths.get("storage");

    void store(MultipartFile file) {
        try {
            var filePath = STORAGE_PATH.resolve(UUID.randomUUID() + "-" + file.getName());
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void streamFile(OutputStream outputStream, String name) {
        try (var inputStream = Files.newInputStream(STORAGE_PATH.resolve(name))) {
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public byte[] loadFile(String name) {
        try {
            return Files.readAllBytes(STORAGE_PATH.resolve(name));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
