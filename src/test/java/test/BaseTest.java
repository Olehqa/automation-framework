package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static helpedfunctions.PropertiesUtils.getProperties;

public class BaseTest {
    private final String CHROMEDRIVER_KEY = "chromedriver";
    private final long MEDIUM_TIME_OUT = Long.parseLong(getProperties("medium_time_out"));
    public static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(CHROMEDRIVER_KEY, getProperties(CHROMEDRIVER_KEY)));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(MEDIUM_TIME_OUT, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}
