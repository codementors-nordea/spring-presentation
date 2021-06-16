package pl.infoshare.springintroduction.jackson.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;
import lombok.With;

@Value
public class Employee {
    @With
    @JsonIgnore
    Integer id;

    @JsonProperty("fullName")
    @JsonView(EmployeeViews.Overview.class)
    String name;

    int age;
}

