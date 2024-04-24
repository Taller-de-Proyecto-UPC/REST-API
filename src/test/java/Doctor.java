import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.person.model.UserEntity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Doctor {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;

    @Given("I want to create a doctor")
    public void i_want_to_create_a_doctor() {
        String postUrl = url + "doctor/create";
        assertTrue(true);
    }


    @When("I create a new doctor with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void i_create_a_new_doctor_with_and(String name, String lastName, String email, String phone, String address, String birthday, String specialty, String username, String password, String role, String active, String cip) {
        String postUrl = url + "doctor/create";

        // Construir el cuerpo de la solicitud (en tu caso, deberías construir el JSON)
        String jsonInputString = "{"
                + "\"name\":\""+name+"\","
                + "\"lastName\":\""+lastName+"\","
                + "\"email\":\""+email+"\","
                + "\"phone\":\""+phone+"\","
                + "\"address\":\""+address+"\","
                + "\"birthday\":\""+birthday+"\","
                + "\"specialty\":\""+specialty+"\","
                + "\"user\":"
                + "{"
                + "\"username\":\""+username+"\","
                + "\"password\":\""+password+"\","
                + "\"role\":\""+role+"\","
                + "\"active\":\""+active+"\""
                + "},"
                + "\"cip\":\""+cip+"\""
                + "}";

        // Configurar la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonInputString, headers);

        // Realizar la solicitud POST
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);


    }


    @Then("the system create a new doctor {string}")
    public void the_system_create_a_new_doctor(String name) {
        String getUrl = url + "doctor";

        ResponseEntity<List<DoctorEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DoctorEntity>>() {}
        );

        List<DoctorEntity> allDoctor = response.getBody();
        assertNotNull(allDoctor);
        assertFalse(allDoctor.isEmpty());

        DoctorEntity lastDoctor = allDoctor.get(allDoctor.size() - 1);
        assertEquals(name,lastDoctor.getName());
    }


    @Given("I want to updated a doctor")
    public void i_want_to_updated_a_doctor() {
        String getUrl = url +"doctor/" + 24;
        assertTrue(true);
    }


    @When("I updated a new doctor with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void i_updated_a_new_doctor_with_and(String name, String lastName, String email, String phone, String address, String birthday, String specialty, String username, String password, String role, String active, String cip) {
        String putUrl = url + "doctor/24";

        String jsonInputString = "{"
                + "\"name\":\""+name+"\","
                + "\"lastName\":\""+lastName+"\","
                + "\"email\":\""+email+"\","
                + "\"phone\":\""+phone+"\","
                + "\"address\":\""+address+"\","
                + "\"birthday\":\""+birthday+"\","
                + "\"specialty\":\""+specialty+"\","
                + "\"user\":"
                + "{"
                + "\"username\":\""+username+"\","
                + "\"password\":\""+password+"\","
                + "\"role\":\""+role+"\","
                + "\"active\":\""+active+"\""
                + "},"
                + "\"cip\":\""+cip+"\""
                + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonInputString, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(putUrl, HttpMethod.PUT, entity, String.class);

    }


    @Then("the system updated the doctor {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_system_updated_the_doctor_and(String name, String lastName, String email, String phone, String address, String birthday, String specialty, String cip) {
        String getUrl = url + "doctor";

        ResponseEntity<List<DoctorEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DoctorEntity>>() {}
        );

        assertEquals(200,response.getStatusCodeValue());

        List<DoctorEntity> allDoctors = response.getBody();
        assertNotNull(allDoctors);
        assertFalse(allDoctors.isEmpty());

        DoctorEntity doctorUpdated = null;
        for(DoctorEntity doctor : allDoctors){
            if( doctor.getId() == 24){
                doctorUpdated = doctor;
                break;
            }
        }

        assertNotNull(doctorUpdated);

        if(Objects.equals(name,doctorUpdated.getName()) && Objects.equals(lastName,doctorUpdated.getLastName())
                && Objects.equals(email,doctorUpdated.getEmail()) && Objects.equals(phone,doctorUpdated.getPhone())
                && Objects.equals(address,doctorUpdated.getAddress()) && Objects.equals(birthday,doctorUpdated.getBirthday())
                && Objects.equals(specialty,doctorUpdated.getSpecialty()) && Objects.equals(cip,doctorUpdated.getCIP()))
            assertTrue(true);
    }

    @Given("I want to see all the doctors registered")
    public void i_want_to_see_all_the_doctors_registered() {
        String getUrl = url + "doctors";
        //log.info(getUrl);
        assertTrue(true);
    }


    @When("I look to the doctors list")
    public void i_look_to_the_doctors_list() {
        String getUrl = url + "doctor";

        ResponseEntity<List<DoctorEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DoctorEntity>>() {
                }
        );

        assertEquals(200,response.getStatusCodeValue());

        List<DoctorEntity> allDoctors = response.getBody();
        assertNotNull(allDoctors);
    }


    @Then("the system shows all the doctors in the database")
    public void the_system_shows_all_the_doctors_in_the_database() {
        String getUrl = url + "doctor";

        ResponseEntity<List<DoctorEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DoctorEntity>>() {
                }
        );

        List<DoctorEntity> allDoctors = response.getBody();
        assertNotNull(allDoctors);
    }


    private String username;
    private DoctorEntity doctor;
    private UserEntity user;

    @Given("I want to see the doctor registered with username {string}")
    public void i_want_to_see_the_doctor_registered_with_username(String username) {
        this.username = username;
    }


    @When("I look for the doctor")
    public void i_look_for_the_doctor() {
        String getUrl = url + "doctor/username/" + username;

        ResponseEntity<DoctorEntity> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                DoctorEntity.class
        );

        assertEquals(200, response.getStatusCodeValue());

        doctor = response.getBody();
        assertNotNull(doctor);
    }


    @Then("the system shows the doctor in the database")
    public void the_system_shows_the_doctor_in_the_database() {
        assertNotNull(doctor);
    }


}
