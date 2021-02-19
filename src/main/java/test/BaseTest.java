package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static helpedfunctions.PropertiesUtils.getProperties;

public class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public static final long SMALL_TIME = Long.parseLong(getProperties("small_time_out"));
    public static final long LONG_TIME = Long.parseLong(getProperties("big_time_out"));

    @BeforeClass
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("chromedriver", getProperties("chromedriver")));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(LONG_TIME, TimeUnit.SECONDS);
//        webDriverWait = new WebDriverWait(driver, SMALL_TIME);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}
