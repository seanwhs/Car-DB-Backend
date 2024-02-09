//ApplicationTests
package carDB.backend;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import carDB.backend.controller.AppUserController;
import carDB.backend.controller.CarController;
import carDB.backend.controller.LoginController;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private CarController carController;
	@Autowired
	private AppUserController appUserController;
	@Autowired
	private LoginController loginController;

	@Test
	@DisplayName("CarController is not NULL")
	void carControllerNullTest() {
		assertThat(carController).isNotNull();
	}
	
	@Test
	@DisplayName("AppUserController is not NULL")
	void appUserControllerNullTest() {
		assertThat(appUserController).isNotNull();
	}
	
	@Test
	@DisplayName("LoginController is not NULL")
	void loginControllerNullTest() {
		assertThat(loginController).isNotNull();
	}

}
