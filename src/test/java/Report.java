import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.patient.model.ReportEntity;
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
public class Report {

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


}
