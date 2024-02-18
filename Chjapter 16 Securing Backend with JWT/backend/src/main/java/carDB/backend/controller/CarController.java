//CarController.java
package carDB.backend.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import carDB.backend.model.Car;
import carDB.backend.repository.CarRepository;

@RestController
public class CarController {
    
    private final CarRepository carRepository;
    
    public CarController(CarRepository carRepository){
        this.carRepository=carRepository;
    }
    
    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

    
}
