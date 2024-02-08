//CommandLineAppStartupRunner.java
package carDB.backend;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import carDB.backend.model.Car;
import carDB.backend.model.Owner;
import carDB.backend.repository.CarRepository;
import carDB.backend.repository.OwnerRepository;

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
	public void run(String... args) throws Exception {
		 // Add owner objects and save them to the database
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        Owner owner3 = new Owner("Bob", "Smith");

        // ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));
        List<Owner> owners = new ArrayList<>(Arrays.asList(owner1, owner2, owner3)); // Explicit type for the list
        ownerRepository.saveAll(owners);
			
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner3));
		
		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}	
	}
    
}
