//OwnerRepository.java
package cards.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cards.backend.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    
}
