package pl.codementors.springintroduction.database;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class SimpleEntityFilters {

    public static Specification<SimpleEntity> adultsOnly() {
        return ageGreaterThan(18);
    }

    public static Specification<SimpleEntity> ageGreaterThan(int givenAge) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get(SimpleEntity_.age), givenAge);
    }

    public static Specification<SimpleEntity> hasName(String givenName) {
        if (Objects.isNull(givenName)) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }

        // upper(name) like '%' + ? + '%'
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.upper(root.get(SimpleEntity_.name)),
                "%" + givenName.toUpperCase() + "%"
        );
    }
}
