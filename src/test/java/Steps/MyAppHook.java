package Steps;

import Driver.DriverManager;
import Driver.DriverManagerForDownload;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utill.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class
MyAppHook {
    private WebDriver driver,driver1;
    Properties prop;
    public ConfigReader configReader;
    public DriverManager driverManager;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(value = "@Skip", order = 0)
    public void skipScenario(Scenario scenario) {
        Assume.assumeTrue(false);
    }
    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverManager = new DriverManager();
        driver = driverManager.init_driver(browserName);
    }
    @Before(order = 2)
    public void launchBrowserForDownloadableProduct() throws IOException {
        DriverManagerForDownload driverManagerForDownload = new DriverManagerForDownload();
        driver1 = driverManagerForDownload.init_driver();
        String downloadedFilePath = System.getProperty("user.dir")+"\\download\\";
        File f = new File(downloadedFilePath);
        FileUtils.cleanDirectory(f);
    }

    @After(order = 0)
    public void browserQuit(){
        driver.quit();
    }
    @After(order = 1)
    public void browserQuitForDownloadableProduct(){
        driver1.quit();
    }

    @After(order = 2)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String ssName = scenario.getName().replace(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach("target/screenshot", "photo.png", ssName);
        }

    }


}
