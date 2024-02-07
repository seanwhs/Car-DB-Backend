// CommandLineAppStartupRunner.java
package cards.backend;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import cards.backend.model.Car;
import cards.backend.model.Owner;
import cards.backend.repository.CarRepository;
import cards.backend.repository.OwnerRepository;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CommandLineAppStartupRunner(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Add owner objects and save them to the database
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        Owner owner3 = new Owner("Bob", "Smith");

        // ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));
        List<Owner> owners = new ArrayList<>(Arrays.asList(owner1, owner2, owner3)); // Explicit type for the list
        ownerRepository.saveAll(owners);

        // Create cars and associate owners
        Set<Owner> owners1 = new HashSet<>();
        owners1.add(owner1);
        Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owners1);
        carRepository.save(car1);

        Set<Owner> owners2 = new HashSet<>();
        owners2.add(owner2);
        Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owners2);
        carRepository.save(car2);

        Set<Owner> owners3 = new HashSet<>();
        owners3.add(owner3);
        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owners3);
        carRepository.save(car3);

        // Add cars to the owners
        owner1.getCars().add(car1);
        owner2.getCars().add(car2);
        owner3.getCars().add(car3);

        // Update owners in the database
        // ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));
        ownerRepository.saveAll(owners);


        // Fetch all cars and log to console
        logger.info("Cars in the database:");
        for (Car car : carRepository.findAll()) {
            logger.info("Brand: {}, Model: {}", car.getBrand(), car.getModel());
        }
    }
}