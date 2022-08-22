package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {

    private WebDriver driver;

    // 1. element locators
    private By blogPageLink = By.xpath("//a[text()='Blog']");
    private By blogLink = By.xpath("//a[text()='Why your online store needs a wish list']");
    private By blog = By.xpath("//div[@class = 'page-body']");
    private By comment = By.xpath("/html/body/div[6]/div[4]/div/div[2]/div/div[2]/div[5]/div[2]/div[1]/div[2]/div[2]");
    private By commentBox = By.xpath("//*[@id=\"AddNewComment_CommentText\"]");
    private By commentButton = By.xpath("//*[@id=\"comments\"]/form/div[2]/button");
    // 2. constructor
    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions
    public String getPageTitle() {
        return driver.getTitle();
    }
    public void clickOnBlogPageLink() {
        WebElement e = driver.findElement(blogPageLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();

        //driver.findElement(blogPageLink).click();
    }
    public void clickOnBlog() {
        driver.findElement(blogLink).click();
    }
    public boolean isBlogExist() {
        return driver.findElement(blog).isDisplayed();
    }
    public boolean isCommentExist() {
       return driver.findElement(comment).isDisplayed();
    }
    public void enterComment(String comment) {
        driver.findElement(commentBox).sendKeys(comment);
    }
    public void clickOnCommentButton() {
        driver.findElement(commentButton).click();
    }
    public boolean isCommentAdded(String comment) {
        String newComment = comment;
        String newXPath = "//div[@class = 'comment-body' and text() = '" + newComment + "']";
        return driver.findElement(By.xpath(newXPath)).isDisplayed();
    }

}
