package pl.codementors.springintroduction.jackson.employees;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    @JsonView(EmployeeViews.Overview.class)
    public Collection<Employee> getEmployees(@RequestParam(defaultValue = "") String query) {
        return employeeRepository.getEmployees(query);
    }

    @GetMapping("/employees/{identifier}")
    public Employee getEmployee(@PathVariable("identifier") int id) {
        return employeeRepository.getEmployee(id);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.createEmployee(employee);
    }
}
