package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInfoPage {

    private WebDriver driver;

    //1. element locators
    private By customerInfoLink = By.xpath("/html/body/div[6]/div[4]/div/div[1]/div/div[2]/ul/li[1]/a");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By saveButton = By.xpath("//*[@id=\"save-info-button\"]");

    //2. constructor
    public CustomerInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions
    public void clickOnCustomerInfoLink() {
        driver.findElement(customerInfoLink).click();
    }
    public boolean customerInfoExist() {
        return driver.findElement(firstName).isDisplayed();
    }
    public void customerInfoEdit(String firstNameInfo, String lastNameInfo, String emailInfo) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(firstNameInfo);
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastNameInfo);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailInfo);
    }
    public void clickOnSaveButton() {
        driver.findElement(saveButton).click();
    }

}
