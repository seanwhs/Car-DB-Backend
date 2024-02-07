//Application.java
package cards.backend;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cards.backend.model.Car;
import cards.backend.model.Owner;
import cards.backend.repository.CarRepository;
import cards.backend.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

	public Application(CarRepository carRepository, OwnerRepository ownerRepository) {
		this.carRepository = carRepository;
		this.ownerRepository=ownerRepository;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		logger.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John" , "Johnson");
 		Owner owner2 = new Owner("Mary" , "Robinson");
		
		List<Owner> owners = new ArrayList<>();
		owners.add(owner1);
    	owners.add(owner2);
        ownerRepository.saveAll(owners);

		
		carRepository.save(new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius",
				"Silver", "KKO-0212", 2022, 39000, owner1));
		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}",
					car.getBrand(), car.getModel());
		}
	}

}
