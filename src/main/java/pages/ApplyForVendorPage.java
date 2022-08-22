package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplyForVendorPage {

    private WebDriver driver;

    // 1. element locators
    private By applyForVendorPageLink = By.xpath("//a[text()='Apply for vendor account']");
    private By vendorName = By.xpath("//*[@id='Name']");
    private By submitButton = By.xpath("//*[@id='apply-vendor']");
    private By successMessage = By.xpath("//div[@class = 'result']");
    private By applyForVendorHeader = By.xpath("//h1[text()='Apply for vendor account']");

    // 2. constructor
    public ApplyForVendorPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions
    public void clickOnApplyForVendorPageLink() {
        driver.findElement(applyForVendorPageLink).click();
    }
    public void onVendorpage() {
        driver.findElement(applyForVendorHeader).isDisplayed();
    }
    public void enterVendorName(String vendorName) {
        driver.findElement(this.vendorName).sendKeys(vendorName);
    }
    public void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public boolean isSuccessMessageExist() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
