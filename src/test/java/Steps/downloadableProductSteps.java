package Steps;

import Driver.DriverManager;
import Driver.DriverManagerForDownload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DownloadableProductPage;

public class downloadableProductSteps {

    DriverManagerForDownload driverManagerForDownload = new DriverManagerForDownload();
    private DownloadableProductPage downloadableProductPage = new DownloadableProductPage(driverManagerForDownload.getDriver());


    @Given("User is in Downloadable products page")
    public void user_is_in_downloadable_products_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManagerForDownload.getDriver().get("https://localhost:44369/customer/downloadableproducts");
    }


    @When("User should see Downloadable products page")
    public void user_should_see_downloadable_products_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(downloadableProductPage.isDownloadableProductsPageHeadingExist());
    }

    @Then("User click on order number link")
    public void user_click_on_order_number_link() {
        // Write code here that turns the phrase above into concrete actions
        downloadableProductPage.clickOnOrderDetailsLink();

    }

    @Then("User should see Downloadable product's order details page")
    public void user_should_see_downloadable_product_s_order_details_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(downloadableProductPage.isOrderDetailsPageHeadingExist());
    }

    @Then("User click on Download link of a downloadable product")
    public void user_click_on_download_link_of_a_downloadable_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        downloadableProductPage.clickOnDownloadButton();
        Thread.sleep(2000);
    }

    @Then("The product download should start")
    public void the_product_download_should_start() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(downloadableProductPage.isFileDownloaded());
    }

}
