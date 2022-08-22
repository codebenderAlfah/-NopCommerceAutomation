package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplyForVendorPage;

public class applyForVendorSteps {

    DriverManager driverManager = new DriverManager();
    private ApplyForVendorPage applyForVendorPage = new ApplyForVendorPage(driverManager.getDriver());

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/");
    }

    @When("User clicks on the Apply for vendor link")
    public void user_clicks_on_the_apply_for_vendor_link() {
        // Write code here that turns the phrase above into concrete actions
        applyForVendorPage.clickOnApplyForVendorPageLink();
    }

    @And("User should be on the Apply for vendor page")
    public void user_should_be_on_the_apply_for_vendor_page() {
        // Write code here that turns the phrase above into concrete actions
        applyForVendorPage.onVendorpage();
    }

    @Given("User is on the Apply for vendor page")
    public void user_is_on_the_apply_for_vendor_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/vendor/apply");
    }

    @When("User fill in Valid Vendor Name")
    public void user_fill_in_valid_vendor_name() {
        // Write code here that turns the phrase above into concrete actions
        applyForVendorPage.enterVendorName("Test Vendor");
    }

    @When("User click on Submit button")
    public void user_click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        applyForVendorPage.clickOnSubmitButton();
    }

    @When("I should see a success message")
    public void i_should_see_a_success_message() {
        // Write code here that turns the phrase above into concrete actions
        applyForVendorPage.isSuccessMessageExist();
    }

}
