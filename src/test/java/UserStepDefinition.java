import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefinition {
    @Given("I want to access to the application")
    public void i_want_to_access_to_the_application() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @When("I create a new user with {string}, {string} and {string}")
    public void i_create_a_new_user_with_and(String user, String password, String role) {
        // Imprimir los valores en la consola
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);
    }

    @Then("The system create a new user")
    public void the_system_create_a_new_user() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
