package com.framework.learn.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public String browser;
    public WebDriverWait wait;
    protected WebDriver driver;

    @BeforeSuite(description = "Clean up", enabled = false)
    public void cleanCookie() {
        LOGGER.info(" ______@BeforeSuite______");
        driver.manage().deleteAllCookies();
    }


    @BeforeClass(description = "set ub driver")
    public void setUp() throws Exception {
        LOGGER.info(" ______@BeforeClass______");
        browser = System.getProperty("browser");

        System.setProperty("webdriver.chrome.driver",
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        LOGGER.info(" ______@AfterClass______");
        driver.quit();
    }

    @AfterSuite(description = "Clean up", enabled = true)
    public void cleanCookieAfter() {
        LOGGER.info(" ______@AfterSuite______");
        driver.manage().deleteAllCookies();
    }
}

