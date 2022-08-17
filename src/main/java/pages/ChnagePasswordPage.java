package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChnagePasswordPage {

    private WebDriver driver;


    //1. element locators
    private By oldPassword = By.id("OldPassword");
    private By newPassword = By.id("NewPassword");
    private By confirmPassword = By.id("ConfirmNewPassword");
    private By changePasswordButton = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button");
    private By ChangePasswordSuccessMessage = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    private By ChangePasswordPageHeading = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]");

    //2. constructor
    public ChnagePasswordPage(WebDriver driver) {
        this.driver = driver;

    }

    //3. page actions
    public void enterOldPassword(String oldPwd) {
        driver.findElement(oldPassword).sendKeys(oldPwd);
    }
    public void enterNewPassword(String newPwd) {
        driver.findElement(newPassword).sendKeys(newPwd);
    }
    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }
    public void clickOnChangePasswordButton() {
        driver.findElement(changePasswordButton).click();
    }
    public boolean isChangePasswordSuccessMessageExist() {
        return driver.findElement(ChangePasswordSuccessMessage).isDisplayed();
    }
    public boolean isChangePasswordPageHeadingExist() {
        return driver.findElement(ChangePasswordPageHeading).isDisplayed();
    }

}
