import com.tp.neuralscan.person.model.PersonEntity;
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

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Person {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I want to create a person")
    public void i_want_to_create_a_person() {
        String postUrl = url + "person/create";
        assertTrue(true);
    }

    @When("I create a new person with {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_create_a_new_person_with(String name, String lastName, String email, String phone, String address, String birthday) {
        String postUrl = url + "person/create";
        PersonEntity newPerson = new PersonEntity();
        newPerson.setName(name);
        newPerson.setLastName(lastName);
        newPerson.setEmail(email);
        newPerson.setPhone(phone);
        newPerson.setAddress(address);
        newPerson.setBirthday(birthday);

        PersonEntity person = restTemplate.postForObject(postUrl,newPerson, PersonEntity.class);

        assertNotNull(person);
    }

    @Then("the system create a new person {string}")
    public void the_system_create_a_new_person(String person) {
        String getUrl = url + "person";

        ResponseEntity<List<PersonEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonEntity>>() {
                }
        );

        List<PersonEntity> allPersons = response.getBody();
        assertNotNull(allPersons);
        assertFalse(allPersons.isEmpty());

        PersonEntity lastPerson = allPersons.get(allPersons.size() - 1);
        assertEquals(person,lastPerson.getAddress());

    }
}
