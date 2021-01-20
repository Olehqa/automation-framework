package test;

import helpedfunctions.PropertiesUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public long smallTime = Long.parseLong(System.getProperty("small_time_out", "50"));
    public long longTime = Long.parseLong(System.getProperty("big_time_out", "100"));


    @BeforeClass
    public void setUP() {
        try {
            PropertiesUtils.loadProperties("config.properties");

        } catch (IOException e) {
            LOGGER.error("Cannot find properties file by path");
        }

        System.setProperty("webdriver.chrome.driver", System.getProperty("chromedriver", "chromedriver_v87.exe"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(longTime, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, smallTime);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}
