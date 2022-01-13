package pl.codementors.springintroduction.database.inheritance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class InheritanceDemo {

    private final AnimalRepository animalRepository;


//    @PostConstruct
//    @Transactional
    public void init() {
        var dog = new Dog();
        dog.setName("dog");
        dog.setSpeed(BigDecimal.TEN);

        var cat = new Cat();
        cat.setName("cat");
        cat.setColor("Blue");

        var cat2 = new Cat();
        cat2.setName("cat2");
        cat.setColor("Brown");

        animalRepository.save(dog);
        animalRepository.save(cat);
        animalRepository.save(cat2);

        var animals = animalRepository.findAll();
        animals.forEach(System.out::println);
    }

}
