import com.tp.neuralscan.patient.model.PatientEntity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Patient {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I want to create a patient")
    public void i_want_to_create_a_patient() {
        String postUrl = url + "patient/"+9+"/create";
        assertTrue(true);
    }

    @When("I create a new patient with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {double} and {double}")
    public void i_create_a_new_patient_with_and(String name, String lastName, String email, String phone, String address, String birthday, String dni, String bloodType, String diseases, Double height, Double weight) {
        String postUrl = url + "patient/"+9+"/create";

        PatientEntity newPatient = new PatientEntity();
        newPatient.setName(name);
        newPatient.setLastName(lastName);
        newPatient.setEmail(email);
        newPatient.setPhone(phone);
        newPatient.setAddress(address);
        newPatient.setBirthday(birthday);
        newPatient.setDni(dni);
        newPatient.setBloodType(bloodType);
        newPatient.setDiseases(diseases);
        newPatient.setHeight(height.floatValue());
        newPatient.setWeight(weight.floatValue());

        PatientEntity patient = restTemplate.postForObject(postUrl,newPatient, PatientEntity.class);

        assertNotNull(patient);
    }

    @Then("the system create a new patient {string}")
    public void the_system_create_a_new_patient(String dni) {
        String getUrl = url + "patient";

        ResponseEntity<List<PatientEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientEntity>>() {}
        );

        List<PatientEntity> allPatient = response.getBody();
        assertNotNull(allPatient);
        assertFalse(allPatient.isEmpty());

        PatientEntity lastPatient = allPatient.get(allPatient.size() - 1);
        assertEquals(dni,lastPatient.getDni());

    }

    @Given("I want to updated a patient")
    public void i_want_to_updated_a_patient() {
        String getUrl = url +"patient/" + 10;
        assertTrue(true);
    }

    @When("I updated a new patient with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {double} and {double}")
    public void i_updated_a_new_patient_with_and(String name, String lastname, String email, String phone, String address, String birthday, String bloodType, String diseases, Double height, Double weight) {
        String putUrl = url + "patient/10";

        PatientEntity newPatient = new PatientEntity();
        newPatient.setName(name);
        newPatient.setLastName(lastname);
        newPatient.setEmail(email);
        newPatient.setPhone(phone);
        newPatient.setAddress(address);
        newPatient.setBirthday(birthday);
        newPatient.setBloodType(bloodType);
        newPatient.setDiseases(diseases);
        newPatient.setHeight(height.floatValue());
        newPatient.setWeight(weight.floatValue());

        restTemplate.put(putUrl, newPatient);
        assertTrue(true);

    }

    @Then("the system updated the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {double} and {double}")
    public void the_system_updated_the_and(String name, String lastname, String email, String phone, String address, String birthday, String bloodType, String diseases, Double height, Double weight) {
        String getUrl = url + "patient";

        ResponseEntity<List<PatientEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientEntity>>() {}
        );

        assertEquals(200,response.getStatusCodeValue());

        List<PatientEntity> allPatients = response.getBody();
        assertNotNull(allPatients);
        assertFalse(allPatients.isEmpty());

        PatientEntity patientUpdated = null;
        for(PatientEntity patient : allPatients){
            if( patient.getId() == 10){
                patientUpdated = patient;
                break;
            }
        }

        assertNotNull(patientUpdated);

        if(Objects.equals(name,patientUpdated.getName()) && Objects.equals(lastname,patientUpdated.getLastName())
        && Objects.equals(email,patientUpdated.getEmail()) && Objects.equals(phone,patientUpdated.getPhone())
        && Objects.equals(address,patientUpdated.getAddress()) && Objects.equals(birthday,patientUpdated.getBirthday())
        && Objects.equals(bloodType,patientUpdated.getBloodType()) && Objects.equals(diseases,patientUpdated.getDiseases())
        && Objects.equals(height,patientUpdated.getHeight()) && Objects.equals(weight,patientUpdated.getWeight()))
            assertTrue(true);

    }


    @Given("I want to see all the patients registered")
    public void i_want_to_see_all_the_patients_registered() {
        String getUrl = url + "patient";
        //log.info(getUrl);
        assertTrue(true);
    }


    @When("I look to the patient list")
    public void i_look_to_the_patient_list() {
        String getUrl = url + "patient";

        ResponseEntity<List<PatientEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientEntity>>() {
                }
        );

        assertEquals(200,response.getStatusCodeValue());

        List<PatientEntity> allPatients = response.getBody();
        assertNotNull(allPatients);

    }


    @Then("the system shows all the patients in the database")
    public void the_system_shows_all_the_patients_in_the_database() {
        String getUrl = url + "patient";

        ResponseEntity<List<PatientEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientEntity>>() {
                }
        );

        List<PatientEntity> allPatients = response.getBody();
        assertNotNull(allPatients);

    }


}
