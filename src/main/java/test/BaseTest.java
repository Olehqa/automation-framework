package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public String browser;
//    public static WebDriverWait webDriverWait;

//    public static final long SMALL_TIME = Long.parseLong(getProperties("small_time_out"));
//    public static final long LONG_TIME = Long.parseLong(getProperties("big_time_out"));

    @BeforeTest(alwaysRun = true)
    public void setUP() {
        browser = System.getProperty("browser");

        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver_v87.exe");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("chromedriver", getProperties("chromedriverdef")));
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--ignore-certificate-errors");
//        driver = new ChromeDriver(options);
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        webDriverWait = new WebDriverWait(driver, SMALL_TIME);


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterClass(alwaysRun = true)
    public void driverDown() {
        driver.close();
        driver.quit();
    }
}

//    public static WebDriver driver;
//    public WebDriverWait webDriverWait;
//    public String browser;
//    private final ResourceBundle waiterTime = ResourceBundle.getBundle("java.resources.waitertime");
//    public long smallTime = Long.parseLong(waiterTime.getString("small_time_out"));
//    public long longTime = Long.parseLong(waiterTime.getString("big_time_out"));
//todo reveiw base test //

//    @BeforeTest(alwaysRun = true)
//    public void setUP() {
//        ClassLoader classLoader = getClass().getClassLoader();
//        String path = classLoader.getResource("chromedriver_v87.exe").getPath();

//        browser = System.getProperty("browser");

//        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver_v87.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--ignore-certificate-errors");
//        driver = new ChromeDriver(options);
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
////        webDriverWait = new WebDriverWait(driver, 10);
//    }

//    @AfterClass(alwaysRun = true)
//    public void driverDown() {
//        driver.close();
//        driver.quit();
//    }


