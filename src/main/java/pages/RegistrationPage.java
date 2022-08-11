package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utill.RandmonGenaretor;

public class RegistrationPage {

    private WebDriver driver;
    private RandmonGenaretor randmonGenaretor = new RandmonGenaretor();

    // 1. element locators
    private By firstName= By.id("FirstName");
    private By lastName= By.id("LastName");
    private By email= By.id("Email");
    private By password= By.id("Password");
    private By confirmPassword= By.id("ConfirmPassword");
    private By registerButton= By.xpath("//*[@id=\"register-button\"]");
    private By successMessage= By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");
    private By continueButton= By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a");

    // 2. constructor
    public RegistrationPage(WebDriver driver) {
        this.driver=driver;

    }

    // 3. page actions

    public String getPageTitle() {
       return driver.getTitle();
    }
    public void enterFirstName() {
        String firstName = randmonGenaretor.randFirstName();
        driver.findElement(this.firstName).sendKeys(firstName);
    }
    public void enterLastName() {
        String lastName = randmonGenaretor.randLastName();
        driver.findElement(this.lastName).sendKeys(lastName);
    }
    public void enterEmail() {
        String email = randmonGenaretor.randEmail();
        driver.findElement(this.email).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }
    public void clickOnRegister() {
        driver.findElement(this.registerButton).click();
    }
    public boolean isSuccessMessageExist() {
        return driver.findElement(this.successMessage).isDisplayed();
    }
    public void clickOnContinue() {
        driver.findElement(this.continueButton).click();
    }
}
