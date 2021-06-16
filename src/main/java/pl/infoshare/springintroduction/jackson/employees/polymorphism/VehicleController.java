package pl.infoshare.springintroduction.jackson.employees.polymorphism;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final List<Vehicle> vehicles = new ArrayList<>();

    @PostConstruct
    void init() {
        vehicles.add(new Car("blue", 90));
        vehicles.add(new Bus(20, 60));
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @PostMapping
    public void createVehicle(@RequestBody Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
