package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature/downloadbaleProducts.feature"},
        glue = {"Steps"},
        plugin = {"pretty",
                "html:target/cucumber-report/nopCommerce-pretty",
                "json:target/cucumber-report/nopCommerce.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class MyTestRunner {



}
