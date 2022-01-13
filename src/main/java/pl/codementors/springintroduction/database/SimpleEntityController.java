package pl.codementors.springintroduction.database;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SimpleEntityController {

    private final SimpleEntityRepository simpleEntityRepository;
    private final CodementorsSimpleEntityRepository codementorsSimpleEntityRepository;


    @PostConstruct
    void init() {
            var simpleEntity = new SimpleEntity();
            simpleEntity.setName("Maciek");
            simpleEntity.setAge(18);
            simpleEntityRepository.save(simpleEntity);
    }

    @GetMapping("/api/adult-entities")
    public Page<SimpleEntity> getAdultEntities(@RequestParam(required = false) String name,
                                               Pageable pageable) {
        return simpleEntityRepository.findAll(SimpleEntityFilters.adultsOnly().and(SimpleEntityFilters.hasName(name)), pageable);

    }

    @GetMapping("/jdbc/entities")
    public List<SimpleEntityOverview> getEntities(@RequestParam Optional<String> name) {
//        return simpleEntityRepository.findAllByName(name.get());
        return name.map(simpleEntityRepository::findAllByName)
                .orElseGet(simpleEntityRepository::findAllProjectedBy);
    }

    @GetMapping("/jdbc/entities/{id}")
    public SimpleEntity getEntities(@PathVariable Long id) {
        return simpleEntityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/jdbc/entities")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void createEntity(@RequestBody SimpleEntity simpleEntity) {
        simpleEntityRepository.save(simpleEntity);
//        codementorsSimpleEntityRepository.save(simpleEntity);
    }

    @GetMapping("/spring/entities/pageable")
    public Page<SimpleEntity> getPagesEntities(@PageableDefault(size = 3) Pageable pageable) {
        Page<SimpleEntity> entities = simpleEntityRepository.findAll(pageable);
        return entities;
    }

    @PutMapping("/spring/entities/{id}")
    @Transactional
    public void createSimpleEntity(@PathVariable Long id, @RequestBody SimpleEntity updatedEntity) {
        var entityFromDatabase = simpleEntityRepository.findById(id).orElseThrow();
        entityFromDatabase.setName(updatedEntity.getName());
    }

    @PutMapping("/spring/owners/{id}/version")
    @Transactional
    public void checkLocking(@PathVariable Long id,
                             @RequestBody SimpleEntity simpleEntity) {
        var savedProduct = simpleEntityRepository.findById(id).get();
        if (!simpleEntity.getVersion().equals(savedProduct.getVersion())) {
            throw new RuntimeException();
        }

        savedProduct.setName(simpleEntity.getName());
        savedProduct.setVersion(simpleEntity.getVersion());
        System.out.println();
    }
}
