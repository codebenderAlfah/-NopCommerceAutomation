package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.nio.file.Paths;
import java.util.HashMap;



public class DriverManagerForDownload {

    public WebDriver driver;
    public String downloadPath = System.getProperty("user.dir")+"\\download\\";
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    HashMap<String, Object> chromeprefs = new HashMap<String, Object>();

    public WebDriver init_driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        chromeprefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromeprefs);
        tlDriver.set(new ChromeDriver(options));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
         return getDriver();
    }
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

}
