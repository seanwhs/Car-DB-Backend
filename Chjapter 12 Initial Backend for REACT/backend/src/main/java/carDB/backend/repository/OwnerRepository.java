//OwnerRepository.java
package carDB.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import carDB.backend.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    
}
