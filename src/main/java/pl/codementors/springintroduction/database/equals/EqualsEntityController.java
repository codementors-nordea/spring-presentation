package pl.codementors.springintroduction.database.equals;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@RestController
@RequiredArgsConstructor
public class EqualsEntityController {

    private final EqualsEntityRepository equalsEntityRepository;

    @PostConstruct
    void init() {
        var equalsRelatedEntity = new EqualsRelatedEntity();
        equalsRelatedEntity.setName("Related Name");

        var equalsEntity = new EqualsEntity();
        equalsEntity.setName("Equals name");
        equalsRelatedEntity.setEqualsEntity(equalsEntity);
//        equalsEntity.setEqualsRelatedEntities(List.of(equalsRelatedEntity));
        equalsEntityRepository.save(equalsEntity);
    }

    @Transactional
    @GetMapping("/spring/jpa/equals")
    public void equalsShowcase() {

        HashSet<EqualsEntity> hashSet = new HashSet<>();
        var equalsEntity = new EqualsEntity();
        equalsEntity.setName("Some Name");

        hashSet.add(equalsEntity);
        equalsEntityRepository.save(equalsEntity);

        hashSet.add(equalsEntity);


    }
}
