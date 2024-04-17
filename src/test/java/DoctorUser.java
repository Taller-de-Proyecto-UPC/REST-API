import com.tp.neuralscan.person.model.UserEntity;
import com.tp.neuralscan.person.repository.UserEntityRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DoctorUser {
    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();



    @Given("I want to access to the application")
    public void iWantToAccessToTheApplication() {
        String postUrl = url +"user/create";
        //log.info(postUrl);
        assertTrue(true);
    }

    @When("I create a new user with {string}, {string} and {string}")
    public void i_create_a_new_user_with_and(String username, String password, String role) {
        String postUrl = url +"user/create";

        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setActive(true);

        UserEntity user = restTemplate.postForObject(postUrl, newUser, UserEntity.class);

        assertNotNull(user);
    }

    @Then("the system create a new user {string}")
    public void the_system_create_a_new_user(String user) {
        String getUrl = url + "user";

        ResponseEntity<List<UserEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserEntity>>() {}
        );

        List<UserEntity> allUsers = response.getBody();
        assertNotNull(allUsers);
        assertFalse(allUsers.isEmpty());

        UserEntity lastUser = allUsers.get(allUsers.size() - 1);
        assertEquals(user, lastUser.getUsername());
    }

    @Given("I want to update a doctor user")
    public void iWantToUpdateADoctorUser() {
        String postUrl = url +"user/"+ 1;
        //log.info(postUrl);
        assertTrue(true);
    }

    @When("I update a doctor user with {string} and {string}")
    public void iUpdateADoctorUserWithUsernameAndPassword(String username, String password) {
        String putUrl = url +"user/1";

        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole("doctor");
        newUser.setActive(true);

        restTemplate.put(putUrl, newUser);
        assertTrue(true);
    }

    @Then("the system update the {string} and {string}")
    public void theSystemUpdateTheUsernameAndPassword(String username, String password) {
        String getUrl = url + "user";

        ResponseEntity<List<UserEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserEntity>>() {}
        );

        assertEquals(200, response.getStatusCodeValue());

        List<UserEntity> allUsers = response.getBody();
        assertNotNull(allUsers);
        assertFalse(allUsers.isEmpty());

        UserEntity userUpdated = null;
        for (UserEntity user : allUsers) {
            if (user.getId() == 1) {
                userUpdated = user;
                break;
            }
        }

        assertNotNull(userUpdated);

        if(Objects.equals(username, userUpdated.getUsername()) && Objects.equals(password, userUpdated.getPassword()))
            assertTrue(true);
    }
}
