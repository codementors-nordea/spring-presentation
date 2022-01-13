package pl.codementors.springintroduction.database.relationships.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
