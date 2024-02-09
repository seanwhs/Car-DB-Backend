//AppUserController.java
package carDB.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import carDB.backend.model.AppUser;
import carDB.backend.repository.AppUserRepository;

@RestController
public class AppUserController {
    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }

    @GetMapping("/user")
    public Iterable<AppUser> getAppUser(){
        return appUserRepository.findAll();
    }
}
