package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage {

    private WebDriver driver;

    // 1. element locators
    private By newsPageLink = By.xpath("//a[text()='News']");
    private By newsLink = By.xpath("//a[text()='New online store is open!']");
    private By news = By.xpath("//h1[text()='New online store is open!']");
    private By commentTitle = By.xpath("//*[@id='AddNewComment_CommentTitle']");
    private By commentBox = By.xpath("//*[@id='AddNewComment_CommentText']");
    private By commentButton = By.xpath("//button[text()='New comment']");

    // 2. constructor
    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions
    public String getPageTitle() {
        return driver.getTitle();
    }
    public void clickOnNewsPageLink() {
        WebElement e = driver.findElement(newsPageLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
    }
    public void clickOnNews() {
        driver.findElement(newsLink).click();
    }
    public boolean isNewsExist() {
        return driver.findElement(news).isDisplayed();
    }
    public void enterCommentTitle(String comment) {
        driver.findElement(commentTitle).sendKeys(comment);
    }
    public void enterComment(String comment) {
        driver.findElement(commentBox).sendKeys(comment);
    }
    public void clickOnCommentButton() {
        driver.findElement(commentButton).click();
    }
    public boolean isCommentAdded(String comment) {
        String newComment = comment;
        String newXPath = "//strong[@class='comment-text' and text()= '" + newComment + "']";
        return driver.findElement(By.xpath(newXPath)).isDisplayed();
    }

}
