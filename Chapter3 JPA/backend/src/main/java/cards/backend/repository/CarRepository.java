//CarRepository.java
package cards.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cards.backend.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    
}
