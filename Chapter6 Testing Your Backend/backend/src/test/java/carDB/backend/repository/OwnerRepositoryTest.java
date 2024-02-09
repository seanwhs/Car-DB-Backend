//OwnerRepositoryTest.java
package carDB.backend.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import carDB.backend.model.Owner;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("Test Create Functionality of OwnerRespository")
    void saveOwner() {
        ownerRepository.save(new Owner("Lucy", "Smith"));
        assertThat(ownerRepository
        .findByFirstname("Lucy")
        .isPresent())
        .isTrue();
    }
    
    @Test
    @DisplayName("Test Delete  Functionality of OwnerRespository")
    void deleteOwners() {
        ownerRepository.save(new Owner("Lisa", "Morrison"));
        ownerRepository.deleteAll();
        assertThat(ownerRepository.count()).isEqualTo(0);
    }

}
