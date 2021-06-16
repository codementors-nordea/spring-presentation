package pl.infoshare.springintroduction.jackson.employees;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmployeeRepository {

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final Map<Integer, Employee> employees = new HashMap<>();

    @PostConstruct
    void init() {
        employees.put(idGenerator.getAndIncrement(), new Employee(idGenerator.getAndIncrement(), "Maciek", 22));
    }

    public Collection<Employee> getEmployees(String query) {
        return employees.values();
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void createEmployee(Employee employee) {
        var id = idGenerator.getAndIncrement();
        var newEmployee = employee.withId(id);

        employees.put(id, newEmployee);
    }
}
