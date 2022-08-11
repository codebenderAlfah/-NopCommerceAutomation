package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;

public class registrationSteps {

    DriverManager driverManager = new DriverManager();
    RegistrationPage registrationpage = new RegistrationPage(driverManager.getDriver());

    @Given("user is in the registration page")
    public void user_is_in_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/register");
    }

    @When("user get the title of the current page")
    public void user_get_the_title_of_the_current_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = registrationpage.getPageTitle();
        System.out.println("The Tittle of the page is: " + title);
    }

    @Then("user should see the registration page title as {string}")
    public void user_should_see_the_registration_page_title_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        String title = driverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains(string));
    }

    @When("user enters valid First name")
    public void user_enters_valid_first_name() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.enterFirstName();
    }

    @When("user enters valid Last name")
    public void user_enters_valid_last_name() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.enterLastName();
    }

    @When("user enters valid Email")
    public void user_enters_valid_email() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.enterEmail();
    }

    @When("user enters valid Password")
    public void user_enters_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.enterPassword("12345678");
    }

    @When("user enters valid Confirm Password")
    public void user_enters_valid_confirm_password() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.enterConfirmPassword("12345678");
    }

    @When("user clicks on Register button")
    public void user_clicks_on_register_button() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.clickOnRegister();
    }

    @Then("user should see the registration success message")
    public void user_should_see_the_registration_success_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(registrationpage.isSuccessMessageExist());
    }

    @When("user clicks continue button")
    public void user_clicks_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        registrationpage.clickOnContinue();
    }

    @Then("user should see the home page")
    public void user_should_see_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(registrationpage.getPageTitle().contains("Your store. Home page title"));
    }
}
