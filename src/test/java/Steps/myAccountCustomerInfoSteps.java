package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.CustomerInfoPage;
import utill.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class myAccountCustomerInfoSteps {

    DriverManager driverManager = new DriverManager();
    private CustomerInfoPage customerInfoPage = new CustomerInfoPage(driverManager.getDriver());

    @Given("user is on My Account Customer Info page")
    public void user_is_on_my_account_customer_info_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/customer/info");
    }

    @Then("User should be able to see Customer info")
    public void user_should_be_able_to_see_customer_info() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(customerInfoPage.customerInfoExist());
    }

    @When("User enter valid data in all fields from sheetname {string} and rownumber {int}")
    public void user_enter_valid_data_in_all_fields_from_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        // Write code here that turns the phrase above into concrete actions
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testdata = excelReader.getData("Testdata.xlsx", sheetName);
        String firstName = testdata.get(rowNumber).get("FirstName");
        String lastName = testdata.get(rowNumber).get("LastName");
        String email = testdata.get(rowNumber).get("Email");
        customerInfoPage.customerInfoEdit(firstName, lastName, email);
    }

    @When("Click on Save Button")
    public void click_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        customerInfoPage.clickOnSaveButton();
    }

}
