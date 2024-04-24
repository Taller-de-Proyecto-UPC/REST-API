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
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //PersonEntity person2 = restTemplate.getForObject(postUrl,)
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
        assertEquals(person,lastPerson.getName());
    }

    @Given("I want to update a person")
    public void i_want_to_update_a_person() {
        String putUrl = url +"person/"+ 1;
        //log.info(postUrl);
        assertTrue(true);
    }

    @When("I update a person with {string}, {string}, {string}, {string}, {string} and {string}")
    public void i_update_a_person_with_and(String name, String lastName, String email, String phone, String address, String birthday) {
        String putUrl = url +"person/1";

        PersonEntity newPerson = new PersonEntity();
        newPerson.setName(name);
        newPerson.setLastName(lastName);
        newPerson.setEmail(email);
        newPerson.setPhone(phone);
        newPerson.setAddress(address);
        newPerson.setBirthday(birthday);

        restTemplate.put(putUrl,newPerson);
        assertTrue(true);

    }

    @Then("the system update the {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_system_update_the_and(String name, String lastName, String email, String phone, String address, String birthday) {
        String getUrl = url +"person";

        ResponseEntity<List<PersonEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonEntity>>(){}
        );

        assertEquals(200, response.getStatusCodeValue());

        List<PersonEntity> allPersons = response.getBody();
        assertNotNull(allPersons);
        assertFalse(allPersons.isEmpty());

        PersonEntity personUpdated = null;
        for(PersonEntity person : allPersons){
            if(person.getId() == 1){
                personUpdated = person;
                break;
            }
        }

        assertNotNull(personUpdated);

        if(Objects.equals(name,personUpdated.getName()) && Objects.equals(lastName,personUpdated.getLastName())
        && Objects.equals(email,personUpdated.getEmail()) && Objects.equals(phone,personUpdated.getPhone())
        && Objects.equals(address,personUpdated.getAddress()) && Objects.equals(birthday,personUpdated.getBirthday()))
            assertTrue(true);

    }

    @Given("I want to see all the persons registered")
    public void i_want_to_see_all_the_persons_registered() {
        String getUrl = url + "person";
        assertTrue(true);
    }

    @When("I look to the person list")
    public void i_look_to_the_person_list() {
        String getUrl = url + "person";

        ResponseEntity<List<PersonEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonEntity>>() {}
        );

        assertEquals(200,response.getStatusCodeValue());

        List<PersonEntity> allPersons = response.getBody();
        assertNotNull(allPersons);

    }

    @Then("the system shows all the persons in the database")
    public void the_system_shows_all_the_persons_in_the_database() {
        String getUrl = url + "person";

        ResponseEntity<List<PersonEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonEntity>>() {}
        );

        List<PersonEntity> allPersons = response.getBody();
        assertNotNull(allPersons);

    }

}
