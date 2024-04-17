import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonStepDenition {
    @Given("I want to create a person")
    public void i_want_to_create_a_person() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("I create a new person with {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_create_a_new_person_with(String name, String lastname, String email, String phone, String address, String birthday) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Name: " + name);
        System.out.println("LastName: " + lastname);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Birthday: " + birthday);

    }

    @Then("the system create a new person")
    public void the_system_create_a_new_person() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
