package Steps;

import Driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BlogPage;

public class blogSteps {

    DriverManager driverManager = new DriverManager();
    private BlogPage blogPage = new BlogPage(driverManager.getDriver());

    @Given("User is in the Home page")
    public void user_is_in_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/");
    }

    @When("User clicks on the Blog link")
    public void user_clicks_on_the_blog_link() {
        // Write code here that turns the phrase above into concrete actions
        blogPage.clickOnBlogPageLink();
    }

    @Then("User should be in the Blog page")
    public void user_should_be_in_the_blog_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = blogPage.getPageTitle();
        Assert.assertTrue(title.contains("Your store. Blog"));
    }

    @Given("User is in the Blog page")
    public void user_is_in_the_blog_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/blog");
    }

    @When("User clicks on the first Blog post")
    public void user_clicks_on_the_first_blog_post() {
        // Write code here that turns the phrase above into concrete actions
        blogPage.clickOnBlog();
    }

    @Then("User should be in the Blog post page")
    public void user_should_be_in_the_blog_post_page() {
        // Write code here that turns the phrase above into concrete actions
        blogPage.isBlogExist();
    }

    @Then("User should see the comments")
    public void user_should_see_the_comments() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(blogPage.isCommentExist());
    }

    @Given("User is in the Blog post page")
    public void user_is_in_the_blog_post_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.getDriver().get("https://localhost:44369/why-your-online-store-needs-a-wish-list");
    }

    @When("User fills in the comment form {string}")
    public void user_fills_in_the_comment_form(String string) {
        // Write code here that turns the phrase above into concrete actions
        blogPage.enterComment(string);
    }

    @When("User clicks the Add new comment button")
    public void user_clicks_the_add_new_comment_button() {
        // Write code here that turns the phrase above into concrete actions
          blogPage.clickOnCommentButton();
    }

    @Then("User should see the new comment {string} in the list of comments")
    public void user_should_see_the_new_comment_in_the_list_of_comments(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(blogPage.isCommentAdded(string));
    }
}
