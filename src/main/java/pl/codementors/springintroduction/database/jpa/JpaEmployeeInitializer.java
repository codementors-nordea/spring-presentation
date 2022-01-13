package pl.codementors.springintroduction.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequiredArgsConstructor
public class JpaEmployeeInitializer {

    private final EntityManager entityManager;

    @GetMapping("/jpa-init")
    @Transactional
    public void init() {
        var employee = new JpaEmployee();
        employee.setAge(25);
        employee.setContractType(JpaContractType.EMPLOYMENT);
        entityManager.persist(employee);

        var employee2 = new JpaEmployee();
        employee2.setAge(25);
        employee2.setContractType(JpaContractType.MANDATE);
        entityManager.persist(employee2);
    }
}
