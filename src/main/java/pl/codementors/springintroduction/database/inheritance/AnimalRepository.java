package pl.codementors.springintroduction.database.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
