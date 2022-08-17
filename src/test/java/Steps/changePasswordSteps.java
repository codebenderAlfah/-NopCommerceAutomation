package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ChnagePasswordPage;

public class changePasswordSteps {

    DriverManager driverManager = new DriverManager();
    private ChnagePasswordPage changePasswordPage = new ChnagePasswordPage(driverManager.getDriver());


    @Given("User is in Change password page")
    public void user_is_in_change_password_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/customer/changepassword");
    }

    @When("user see the Change password page")
    public void user_see_the_change_password_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(changePasswordPage.isChangePasswordPageHeadingExist());
    }

    @When("User enters old password and new password and confirm password")
    public void user_enters_old_password_and_new_password_and_confirm_password() {
        // Write code here that turns the phrase above into concrete actions
        changePasswordPage.enterOldPassword("12345678");
        changePasswordPage.enterNewPassword("123456789");
        changePasswordPage.enterConfirmPassword("123456789");
    }

    @When("Clicks on Change password button")
    public void clicks_on_change_password_button() {
        // Write code here that turns the phrase above into concrete actions
        changePasswordPage.clickOnChangePasswordButton();
    }

    @Then("User should be able to change password successfully")
    public void user_should_be_able_to_change_password_successfully() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(changePasswordPage.isChangePasswordSuccessMessageExist());
    }
}
