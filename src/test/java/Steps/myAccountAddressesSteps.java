package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.AdderssesPage;
import utill.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class myAccountAddressesSteps {

    DriverManager driverManager = new DriverManager();
    private AdderssesPage addressPage = new AdderssesPage(driverManager.getDriver());

    @Given("User is on My Account Addresses page")
    public void user_is_on_my_account_addresses_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/customer/addresses");
    }

    @When("user click on Add New Address button")
    public void user_click_on_add_new_address_button() {
        // Write code here that turns the phrase above into concrete actions
        addressPage.clickOnAddNewAddressButton();
    }

    @Then("user should see Add New Address page")
    public void user_should_see_add_new_address_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(addressPage.isAddNewAddressHeadingDisplayed());
    }

    @When("User click on Save Address Button")
    public void user_click_on_save_address_button() {
        // Write code here that turns the phrase above into concrete actions
        addressPage.clickOnSaveButton();
    }

    @Then("User should be able to see the address in My Account Addresses page")
    public void user_should_be_able_to_see_the_address_in_my_account_addresses_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(addressPage.addressExist());
    }

    @When("User click on Edit Address Button")
    public void user_click_on_edit_address_button() {
        // Write code here that turns the phrase above into concrete actions
        addressPage.clickOnEditButton();
    }

    @When("User should be on Edit Address page")
    public void user_should_be_on_edit_address_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(addressPage.isEditAddressHeadingDisplayed());
    }

    @When("User click on Delete Address Button")
    public void user_click_on_delete_address_button() {
        // Write code here that turns the phrase above into concrete actions
        addressPage.clickOnDeleteButton();
    }

    @And("User enter valid addresses")
    public void userEnterValidAddresses() {
        String firstName = "FirstName";
        String lastName = "LastName";
        String email = "valid@email.com";
        String country = "United States of America";
        String state = "Alabama";
        String city = "Birmingham";
        String address1 = "House 1, Road 1, District 1";
        String zipCode = "35213";
        String phoneNumber = "+1(205)555-3890";
        addressPage.enterAddress(firstName, lastName, email, country, state, city, address1, zipCode, phoneNumber);
    }
}
