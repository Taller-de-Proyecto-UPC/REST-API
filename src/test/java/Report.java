import com.tp.neuralscan.patient.model.ReportEntity;
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
public class Report {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I want to create a report")
    public void i_want_to_create_a_report() {
        String postUrl = url + "report/doctor/9/patient/18/create";
        assertTrue(true);
    }

    @When("I create a new report with {string}, {string} and {string}")
    public void i_create_a_new_report_with_and(String summary, String description, String comment) {
        String postUrl = url + "report/doctor/9/patient/18/create";

        ReportEntity newReport = new ReportEntity();
        newReport.setSummary(summary);
        newReport.setDescription(description);
        newReport.setComment(comment);

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
                new ParameterizedTypeReference<List<ReportEntity>>() {
                }
        );

        List<ReportEntity> allReport = response.getBody();
        assertNotNull(allReport);
        assertFalse(allReport.isEmpty());

        ReportEntity lastReport = allReport.get(allReport.size()-1);
        assertEquals(summary,lastReport.getSummary());


    }

}
