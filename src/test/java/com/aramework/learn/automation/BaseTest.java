package com.aramework.learn.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public String browser;
    public WebDriverWait wait;


    @BeforeSuite(description = "Clean up", enabled = false)
    public void cleanCookie() {
        driver.manage().deleteAllCookies();
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        browser = System.getProperty("browser");
        System.setProperty("webdriver.chrome.driver",
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
//        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterSuite(description = "Clean up", enabled = true)
    public void cleanCookieAfter() {
        driver.manage().deleteAllCookies();
    }
}

