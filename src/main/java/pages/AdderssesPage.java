package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AdderssesPage {

    private WebDriver driver;

    //1. element locators
    private By noaddress = By.xpath("/html/body/div[6]/div[4]/div/div[2]/form/div/div[1]/h1");
    private By newAddressHeading = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[1]/h1");
    private final By noAddresstest = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]");
    private final By editAddress = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[1]/h1");
    private final By addNewAddressButton = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button");
    private final By firstName = By.id("Address_FirstName");
    private final By lastName = By.id("Address_LastName");
    private final By email = By.id("Address_Email");
    private final By country = By.id("Address_CountryId");
    private final By state = By.id("Address_StateProvinceId");
    private final By city = By.id("Address_City");
    private final By address1 = By.id("Address_Address1");
    private final By zipCode = By.id("Address_ZipPostalCode");
    private final By phoneNumber = By.id("Address_PhoneNumber");
    private final By saveButton = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[2]/button");
    private final By editButton = By.xpath("(//button[@class='button-2 edit-address-button'])[1]");
    private final By deleteButton = By.xpath("(//button[@class='button-2 delete-address-button'])[1]");
    private final By existingAddressHeading = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]/div/div[1]/strong");


    //2. constructor
    public AdderssesPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions
    public boolean isAddNewAddressHeadingDisplayed() {
        return driver.findElement(newAddressHeading).isDisplayed();
    }
    public boolean noAddressExist() {
        return driver.findElement(noaddress).isDisplayed();
    }
    public boolean addressExist() {
        return driver.findElement(existingAddressHeading).isDisplayed();
    }
    public boolean isEditAddressHeadingDisplayed() {
        return driver.findElement(editAddress).isDisplayed();
    }
    public void clickOnAddNewAddressButton() {
        driver.findElement(addNewAddressButton).click();
    }
    public void enterAddress(String firstNameInfo, String lastNameInfo, String emailInfo, String countryInfo, String stateInfo, String cityInfo, String address1Info, String zipCodeInfo, String phoneNumberInfo) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(firstNameInfo);
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastNameInfo);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailInfo);
        Select countryDropdown = new Select(driver.findElement(country));
        countryDropdown.selectByVisibleText(countryInfo);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Select stateDropdown = new Select(driver.findElement(state));
        stateDropdown.selectByVisibleText(stateInfo);
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityInfo);
        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(address1Info);
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(zipCodeInfo);
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(phoneNumberInfo);
    }
    public void clickOnSaveButton() {
        driver.findElement(saveButton).click();
    }
    public void clickOnEditButton() {
        driver.findElement(editButton).click();
    }
    public void clickOnDeleteButton() {
        driver.findElement(deleteButton).click();
        driver.switchTo().alert().accept();
    }
}
