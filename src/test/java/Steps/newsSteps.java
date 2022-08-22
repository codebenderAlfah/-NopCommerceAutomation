package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.NewsPage;

public class newsSteps {

    DriverManager driverManager = new DriverManager();
    private NewsPage newsPage = new NewsPage(driverManager.getDriver());

    @When("User clicks on the News link")
    public void user_clicks_on_the_news_link() {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnNewsPageLink();
    }

    @Then("User should be in the News page")
    public void user_should_be_in_the_news_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = newsPage.getPageTitle();
        Assert.assertTrue(title.contains("Your store. News Archive"));
    }

    @Given("User is in the News page")
    public void user_is_in_the_news_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/news");
    }

    @When("User clicks on the first News post")
    public void user_clicks_on_the_first_news_post() {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnNews();
    }

    @Then("User should be in the News post page")
    public void user_should_be_in_the_news_post_page() {
        // Write code here that turns the phrase above into concrete actions
        newsPage.isNewsExist();
    }

    @Given("User is in the News post page")
    public void user_is_in_the_news_post_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/new-online-store-is-open");
    }

    @When("User fills in the comment form tittle {string}")
    public void user_fills_in_the_comment_form_tittle(String string) {
        // Write code here that turns the phrase above into concrete actions
        newsPage.enterCommentTitle(string);
    }

    @When("User fills in the comment form text {string}")
    public void user_fills_in_the_comment_form_text(String string) {
        // Write code here that turns the phrase above into concrete actions
        newsPage.enterComment(string);
    }

    @When("User clicks the Add new comment button on news post page")
    public void user_clicks_the_add_new_comment_button_on_news_post_page() {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnCommentButton();
    }

    @Then("User should see the new comment {string} in the list of comments on the news post page")
    public void user_should_see_the_new_comment_in_the_list_of_comments_on_the_news_post_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(newsPage.isCommentAdded(string));
    }

}
