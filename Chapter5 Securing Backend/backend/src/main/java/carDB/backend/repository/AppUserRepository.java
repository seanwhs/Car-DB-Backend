//AppUserRepository.java
package carDB.backend.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import carDB.backend.model.AppUser;
import java.util.Optional;


@Repository
public interface AppUserRepository extends CrudRepository <AppUser, Long>{
    Optional <AppUser>  findByUsername(String username);
}
