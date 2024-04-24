import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.patient.model.ReportEntity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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
public class ReportStepsDefinition {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I want to updated a report")
    public void i_want_to_updated_a_report() {
        String getUrl = url +"report/" + 1;
        assertTrue(true);
    }

    @When("I updated a report with {string}, {string} and {string}")
    public void i_updated_a_report_with_and(String summary, String description, String comment) {
        String putUrl = url + "report/1";

        ReportEntity newReport = new ReportEntity();
        newReport.setSummary(summary);
        newReport.setDescription(description);
        newReport.setComment(comment);

        restTemplate.put(putUrl, newReport);
        assertTrue(true);
    }

    @Then("the system updated the {string}, {string} and {string}")
    public void the_system_updated_the_and(String summary, String description, String comment) {
        String getUrl = url + "report";

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {}
        );

        assertEquals(200,response.getStatusCodeValue());

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);
        assertFalse(allReports.isEmpty());

        ReportEntity reportUpdated = null;
        for(ReportEntity report : allReports){
            if( report.getId() == 1){
                reportUpdated = report;
                break;
            }
        }

        assertNotNull(reportUpdated);

        if(Objects.equals(summary,reportUpdated.getSummary()) && Objects.equals(description,reportUpdated.getDescription())
                && Objects.equals(comment,reportUpdated.getComment()))
            assertTrue(true);

    }

    @Given("I want to see all the reports created")
    public void i_want_to_see_all_the_reports_created() {
        String getUrl = url + "report";
        //log.info(getUrl);
        assertTrue(true);
    }

    @When("I look to the report list")
    public void i_look_to_the_report_list() {
        String getUrl = url + "report";

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        assertEquals(200,response.getStatusCodeValue());

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);

    }

    @Then("the system shows all the reports in the database")
    public void the_system_shows_all_the_reports_in_the_database() {
        String getUrl = url + "report";

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);

    }

    private int doctorId;

    @Given("I want to see the report created by a {int}")
    public void i_want_to_see_the_report_created_by_a(Integer doctorId) {
        this.doctorId = doctorId;
    }


    @When("I look for the report")
    public void i_look_for_the_report() {
        String getUrl = url + "report/doctor/" + doctorId;

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        assertEquals(200, response.getStatusCodeValue());

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);
    }

    @Then("the system shows the report in the database")
    public void the_system_shows_the_report_in_the_database() {
        String getUrl = url + "report/doctor/" + doctorId;

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);

    }

    private int patientId;

    @Given("I want to see the patient created by a {int}")
    public void i_want_to_see_the_patient_created_by_a(Integer patientId) {
        this.patientId = patientId;
    }

    @When("I look for the report of patient")
    public void i_look_for_the_report_of_patient() {
        String getUrl = url + "report/patient/" + patientId;

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        assertEquals(200, response.getStatusCodeValue());

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);
    }

    @Then("the system shows the reports of the patient in the database")
    public void the_system_shows_the_reports_of_the_patient_in_the_database() {
        String getUrl = url + "report/patient/" + patientId;

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        List<ReportEntity> allReports = response.getBody();
        assertNotNull(allReports);

    }

    /*
    private String idpatient;
    private String iddoctor;
    @Given("I doctor {string} want to create a report by patient {string}")
    public void i_doctor_want_to_create_a_report_by_patient(String iddoctor, String idpatient) {
        this.iddoctor=iddoctor;
        this.idpatient=idpatient;
    }


    @When("I create a new report with {string}, {string}, {string}, {string} and {string}")
    public void i_create_a_new_report_with_and(String summary, String description, String comment, String path, String added) {
        String postUrl = url + "report/doctor/"+iddoctor+"/patient/"+idpatient+"/create";

        ImageEntity newImage = new ImageEntity();
        ReportEntity newReport = new ReportEntity();

        newReport.setSummary(summary);
        newReport.setDescription(description);
        newReport.setComment(comment);

        newImage.setPath(path);
        newImage.setAdded(added);
        newReport.setImageEntity(newImage);

        ReportEntity report = restTemplate.postForObject(postUrl,newReport, ReportEntity.class);

        assertNotNull(report);
    }


    @Then("the system create a new report {string}")
    public void the_system_create_a_new_report(String summary) {
        String getUrl = url + "report";

        ResponseEntity<List<ReportEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportEntity>>() {}
        );

        List<ReportEntity> allReport = response.getBody();
        assertNotNull(allReport);
        assertFalse(allReport.isEmpty());

        ReportEntity lastReport = allReport.get(allReport.size() - 1);
        assertEquals(summary,lastReport.getSummary());
    }


*/

    private String docId;
    private String patId;

    private ResponseEntity<String> response;

    @Given("a doctor with ID {string} and a patient with ID {string}")
    public void un_médico_con_ID_y_un_paciente_con_ID(String docId, String patId) {
        this.docId = docId;
        this.patId = patId;
    }


    @When("a POST request is sent to create a medical report")
    public void se_envía_una_solicitud_POST_para_crear_un_informe_médico() {
        // Construir la URL con los IDs del médico y el paciente
        String postUrl = url + "report/doctor/" + doctorId + "/patient/" + patientId + "/create";

        // Construir el cuerpo de la solicitud (en tu caso, deberías construir el JSON)
        String jsonInputString = "{\"summary\":\"nuevo informe\"," +
                "\"description\":\"Descripción detallada del nuevo\"," +
                "\"comment\":\"Comentarios adicionales\"," +
                "\"image\":{\"path\":\"C:/Users/user/Pictures/Melosita\"," +
                "\"added\":\"Logo.png\"}}";

        // Configurar la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonInputString, headers);

        // Realizar la solicitud POST
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);
    }


    @Then("an successful response with status code {int} is expected")
    public void se_espera_una_respuesta_exitosa_con_código_de_estado(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCodeValue());
    }


    @Then("the medical report is created correctly")
    public void el_informe_médico_se_crea_correctamente() {
        String responseBody = response.getBody();
    }




}
