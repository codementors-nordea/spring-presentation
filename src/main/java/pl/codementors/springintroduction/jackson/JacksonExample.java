package pl.codementors.springintroduction.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class JacksonExample {

    private final ObjectMapper springObjectMapper;


    @PostConstruct
    void init() throws JsonProcessingException {
//        var objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new ParameterNamesModule());
//
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
////{"fullName":"Maciej Koziara","firstName":"Maciej","surname":"Koziara"}
//        var value = new JacksonModel("Maciej", "Koziara", 2, LocalDate.now());
//        var json = objectMapper.writeValueAsString(value);
//
//        var deserializedModel = objectMapper.readValue(json, JacksonModel.class);
//        var deserializerModelFromSpring = springObjectMapper.readValue(json, JacksonModel.class);
//        System.out.println();



    }



}
