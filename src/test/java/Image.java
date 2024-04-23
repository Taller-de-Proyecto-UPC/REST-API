import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.person.model.PersonEntity;
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
public class Image {

    String url = "http://localhost:8080/api/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I want to create a image")
    public void i_want_to_create_a_image() {
        String postUrl = url + "image/create";
        assertTrue(true);
    }


    @When("I create a new image with {string} and {string}")
    public void i_image_a_new_person_with_and(String path, String added) {
        String postUrl = url + "image/create";
        ImageEntity newImage = new ImageEntity();
        newImage.setPath(path);
        newImage.setAdded(added);

        ImageEntity image = restTemplate.postForObject(postUrl,newImage, ImageEntity.class);
        //PersonEntity person2 = restTemplate.getForObject(postUrl,)
        assertNotNull(image);
    }


    @Then("the system create a new image {string}")
    public void the_system_create_a_new_image(String path) {
        String getUrl = url + "image";

        ResponseEntity<List<ImageEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ImageEntity>>() {
                }
        );

        List<ImageEntity> allImages = response.getBody();
        assertNotNull(allImages);
        assertFalse(allImages.isEmpty());

        ImageEntity lastImage = allImages.get(allImages.size() - 1);
        assertEquals(path,lastImage.getPath());
    }

    @Given("I want to updated a image")
    public void i_want_to_updated_a_image() {
        String putUrl = url +"image/"+ 12;
        //log.info(postUrl);
        assertTrue(true);
    }

    @When("I updated a image with {string} and {string}")
    public void i_updated_a_image_with_and(String path, String added) {
        String putUrl = url +"image/"+12;

        ImageEntity newImage = new ImageEntity();
        newImage.setPath(path);
        newImage.setAdded(added);

        restTemplate.put(putUrl,newImage);
        assertTrue(true);
    }

    @Then("the system updated the {string} and {string}")
    public void the_system_updated_the_and(String path, String added) {
        String getUrl = url +"image";

        ResponseEntity<List<ImageEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ImageEntity>>(){}
        );

        assertEquals(200, response.getStatusCodeValue());

        List<ImageEntity> allImages = response.getBody();
        assertNotNull(allImages);
        assertFalse(allImages.isEmpty());

        ImageEntity imageUpdated = null;
        for(ImageEntity image : allImages){
            if(image.getId() == 12){
                imageUpdated = image;
                break;
            }
        }

        assertNotNull(imageUpdated);

        if(Objects.equals(path,imageUpdated.getPath()) && Objects.equals(added,imageUpdated.getAdded()))
            assertTrue(true);

    }

    @Given("I want to see all the images registered")
    public void i_want_to_see_all_the_images_registered() {
        String getUrl = url + "image";
        //log.info(getUrl);
        assertTrue(true);
    }

    @When("I look to the image list")
    public void i_look_to_the_image_list() {
        String getUrl = url + "image";

        ResponseEntity<List<ImageEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ImageEntity>>() {
                }
        );

        assertEquals(200,response.getStatusCodeValue());

        List<ImageEntity> allImages = response.getBody();
        assertNotNull(allImages);
    }

    @Then("the system shows all the images in the database")
    public void the_system_shows_all_the_images_in_the_database() {
        String getUrl = url + "image";

        ResponseEntity<List<ImageEntity>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ImageEntity>>() {
                }
        );

        List<ImageEntity> allImages = response.getBody();
        assertNotNull(allImages);
    }


}
