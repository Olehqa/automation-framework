package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuilder verificationErrors = new StringBuilder();
    public String browser;
    public WebDriverWait webDriverWait;

    @BeforeClass
    public void setUP() {
        browser = System.getProperty("browser");

        System.setProperty("webdriver.chrome.driver",
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}
