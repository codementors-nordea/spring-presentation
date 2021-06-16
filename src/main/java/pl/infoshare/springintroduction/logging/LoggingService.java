package pl.infoshare.springintroduction.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingService {

    void logThings() {
        log.debug("Debug log");
        log.info("Info log");
        log.error("Error log");
    }
}
