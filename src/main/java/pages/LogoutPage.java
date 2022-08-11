package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;

    //1. element locator
    private By logOutButton= By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a");
    private By loginButton= By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

    //2. constructor
    public LogoutPage(WebDriver driver) {
        this.driver=driver;
    }
    //3. page actions
    public void clickOnLogout() {
        driver.findElement(logOutButton).click();
    }
    public boolean isLogoutButtonExist() {
        return driver.findElement(logOutButton).isDisplayed();
    }
    public boolean isLoginButtonExist() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
