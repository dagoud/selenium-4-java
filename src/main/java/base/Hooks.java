package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Hooks {
    public WebDriver driver;

    @BeforeTest
    public void setup() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
        properties.load(file);

        String browserType = properties.getProperty("browser").toLowerCase().trim();

        switch (browserType){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                int width = 1920;
                int height = 1080;
                driver = new SafariDriver(safariOptions);
                driver.manage().window().maximize();
            case "grid":
                ChromeOptions grid_ChromeOptions = new ChromeOptions();
                grid_ChromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                grid_ChromeOptions.addArguments("--start-maximized");
//                grid_ChromeOptions.setBinary("/chromedriver.exe");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), grid_ChromeOptions);
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
