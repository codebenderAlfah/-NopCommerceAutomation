package Steps;

import Driver.DriverManager;
import Driver.DriverManagerForDownload;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class loginWithDataTableSteps {

    private DriverManagerForDownload driverManagerForDownload = new DriverManagerForDownload();
    private LoginPage loginPage = new LoginPage(driverManagerForDownload.getDriver());

    @When("User enter following data:")
    public void user_enter_following_data(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            driverManagerForDownload.getDriver().get("https://localhost:44369/customer/login");
            loginPage.enterUserName(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
            Thread.sleep(2000);
        }
//        String email = credentials.get(0).get("username");
//        String password = credentials.get(0).get("password");
//        loginPage.enterUserName(email);
//        loginPage.enterPassword(password);
    }
}
