package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LogoutPage;

public class logoutSteps {

    private DriverManager driverManager = new DriverManager();

    private LogoutPage logoutpage = new LogoutPage(driverManager.getDriver());

    @Given("user is logged in to the application and see {string} link")
    public void user_is_logged_in_to_the_application_and_see_link(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(logoutpage.isLogoutButtonExist());
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        // Write code here that turns the phrase above into concrete actions
        logoutpage.clickOnLogout();
    }

    @Then("user should be logged out from the application and see {string} link")
    public void user_should_be_logged_out_from_the_application_and_see_link(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(logoutpage.isLoginButtonExist());
    }
}
