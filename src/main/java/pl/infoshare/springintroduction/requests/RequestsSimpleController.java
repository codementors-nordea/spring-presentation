package pl.infoshare.springintroduction.requests;

import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class RequestsSimpleController {

    private final FileStorage fileStorage;

    // /requests/test/2?myString=str&myInt=123
    // Content-Type: application/json
    //
    // { message: "Maciek" }
    @GetMapping("/requests/test/{id}")
    public void someRequest(@RequestBody HelloModel simpleHello,
                            @RequestHeader("Content-Type") String contentType,
                            @RequestParam String myString,
                            @RequestParam Integer myInt,
                            @PathVariable int id,
                            HelloSearch search,
                            @CookieValue String cookie,
                            RequestEntity<HelloModel> entity) {

        var query = entity.getUrl().getQuery();

    }

    // /requests/test/1?myParam=123
    @GetMapping(value = "/requests/test/{id}", params = "myParam=123")
    public void withParam() {

    }

    @GetMapping("/requests/model")
    @ResponseStatus(HttpStatus.CREATED)
    public HelloModel getModel() {
        return new HelloModel("Some message");
    }

    @GetMapping("/requests/entity")
    public ResponseEntity<HelloModel> getEntity() {
        if (true) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok()
                .header("X-WHATEVER", "my value")
                .contentLength(20)
                .body(new HelloModel("Some message"));
    }





    @GetMapping("/requests/completable")
    public CompletableFuture<String> completableFuture() {
        var future = CompletableFuture.supplyAsync(() -> longMessage("Completable future finished"));
        System.out.println("Request finished");
        return future;
    }

    private String longMessage(String message) {
        try {
            System.out.println("sleep");
            Thread.sleep(1000L);
            System.out.println("after sleep");
            return message;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping("/requests/files")
    public void someRequest(@RequestPart MultipartFile file) {
        fileStorage.store(file);
    }

    @GetMapping("/requests/files/{name}")
    public StreamingResponseBody downloadFile(@PathVariable String name) {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(fileStorage.loadFile(name));
            }
        };
    }

    @GetMapping("/requests/files-stream/{name}")
    public StreamingResponseBody streamFile(@PathVariable String name) {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                fileStorage.streamFile(outputStream, name);
            }
        };
    }

    @GetMapping(value = "/requests/hello", headers = "X-MY-HEADER=value", params = "myQueryParam")
    public String getHello(@RequestParam String myQueryParam, @RequestHeader("") String value) {
        System.out.println("Hello");
        return "hello";
    }

    @GetMapping(value = "/requests/hello", produces = "application/json")
    public String getHello2() {
        System.out.println("Hello");
        return "hello";
    }

    @GetMapping(value = "/requests/hello", produces = "application/xml")
    public String getHelloXml() {
        System.out.println("Hello");
        return "hello";
    }

    @PostMapping("/requests/hello")
    public String getHelloXml(@RequestBody HelloModel helloModel) {
        return helloModel.getMessage();
    }

    // /requests/files/image.jpg
    @GetMapping(value = "/requests/files/{fileName}.{fileExtension}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String getHello2(@PathVariable String fileExtension) {
        System.out.println("Hello");
        return "hello";
    }
}
