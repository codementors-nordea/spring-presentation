package pl.codementors.springintroduction.database.relationships.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
