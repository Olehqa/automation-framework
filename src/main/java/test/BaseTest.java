package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    private final ResourceBundle waiterTime = ResourceBundle.getBundle("resources.resoursebundle.waitertime");
    public long smallTime = Long.parseLong(waiterTime.getString("small_time_out"));
    public long longTime = Long.parseLong(waiterTime.getString("big_time_out"));

    @BeforeClass
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_v88.exe");
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
