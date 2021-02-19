package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static helpedfunctions.PropertiesUtils.getProperties;

public class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;


    public static final long SMALL_TIME = Long.parseLong(getProperties("small_time_out"));
    public static final long LONG_TIME = Long.parseLong(getProperties("big_time_out"));
    private final String CHROMEDRIVER_KEY = "chromedriveref";

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
        driver.manage().timeouts().implicitlyWait(SMALL_TIME, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}


