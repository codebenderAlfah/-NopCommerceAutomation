package Steps;

import Driver.DriverManager;
import Driver.DriverManagerForDownload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class loginSteps {

    DriverManager driverManager = new DriverManager();
    private LoginPage loginpage = new LoginPage(driverManager.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/login");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = loginpage.getPageTitle();
        System.out.println("The Tittle of the page is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
        String title = loginpage.getPageTitle();
        Assert.assertTrue(title.contains(expectedTitle));
    }

    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(loginpage.isForgotPwdLinkExist());
    }
    @When("User enter valid username as {string}")
    public void user_enter_valid_username_as(String email) {
        // Write code here that turns the phrase above into concrete actions
        loginpage.enterUserName(email);
    }
    @When("User enter valid password as {string}")
    public void user_enter_valid_password_as(String pswd) {
        // Write code here that turns the phrase above into concrete actions
        loginpage.enterPassword(pswd);
    }
    @When("Click on Login Button")
    public void click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginpage.clickOnLogin();
    }
    @Then("User should see Home page title as {string}")
    public void userShouldSeeHomePageTitleAs(String string) {
        String title = loginpage.getPageTitle();
        Assert.assertTrue(title.contains(string));
    }
}
