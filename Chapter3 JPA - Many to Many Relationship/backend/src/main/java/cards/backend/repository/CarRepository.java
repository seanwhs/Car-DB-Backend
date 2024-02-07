//CarRepository.java
package cards.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cards.backend.model.Car;
import java.util.List;


@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModel(String model);
    List<Car> findByModelYear(int modelYear);
    List<Car> findByPrice(int price);
    List<Car> findByRegistrationNumber(String registrationNumber);

    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);

}
