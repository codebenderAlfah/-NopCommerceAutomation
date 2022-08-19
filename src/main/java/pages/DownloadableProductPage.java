package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class DownloadableProductPage {

    private WebDriver driver;

    //1. element locators
    private By downloadButton = By.xpath("/html/body/div[6]/div[4]/div/div[2]/div/div[2]/div/table/tbody/tr/td[4]/div/a");
    private By orderDetailsLink = By.xpath("/html/body/div[6]/div[4]/div/div[2]/div/div[2]/div/table/tbody/tr/td[1]/a");
    private By downloadableProductsPageHeading = By.xpath("/html/body/div[6]/div[4]/div/div[2]/div/div[1]/h1");
    private By orderDetailsPageHeading = By.xpath("/html/body/div[6]/div[4]/div/div/div/div[2]/div[1]/div/strong");
    //2. constructor

    public DownloadableProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions
    public void clickOnDownloadButton() {
        driver.findElement(downloadButton).click();
    }
    public void clickOnOrderDetailsLink() {
        driver.findElement(orderDetailsLink).click();
    }
    public boolean isDownloadableProductsPageHeadingExist() {
        return driver.findElement(downloadableProductsPageHeading).isDisplayed();
    }
    public boolean isOrderDetailsPageHeadingExist() {
        return driver.findElement(orderDetailsPageHeading).isDisplayed();
    }
    public boolean isFileDownloaded() {

        String pdPath = System.getProperty("user.dir")+"\\download\\Night_Vision_1.zip";
        File file = new File(pdPath);
        boolean b=false;
        b = file.exists();
        return b;
    }

}
