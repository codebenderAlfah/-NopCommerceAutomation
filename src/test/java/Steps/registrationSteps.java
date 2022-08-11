package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.RegistrationPage;
import utill.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @When("user enters valid info from given sheetname {string} and rownumber {int}")
    public void user_enters_valid_info_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        // Write code here that turns the phrase above into concrete actions
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testdata = excelReader.getData("Testdata.xlsx", sheetName);
        String firstName = testdata.get(rowNumber).get("FirstName");
        String lastName = testdata.get(rowNumber).get("LastName");
        String email = testdata.get(rowNumber).get("Email");
        String password = testdata.get(rowNumber).get("Password");
        String confirmPassword = testdata.get(rowNumber).get("ConfirmPassword");
        registrationpage.enterRegistrationInfo(firstName, lastName, email, password, confirmPassword);
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
