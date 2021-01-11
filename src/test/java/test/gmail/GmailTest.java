package test.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

public class GmailTest extends BaseTest {
    By login = By.xpath(".//input[@id='identifierId']");
    By buttonNext = By.xpath("//span[contains (text(), 'Далі')]");
    By pass = By.xpath("//input[@type='password']");
    By create = By.xpath("//div[contains(text(),'Написати')]");
    By forWhom = By.xpath("//div[contains(text(),'Одержувачі')]");
    By subject = By.xpath("//div[contains(text(),'Тема')]");

    //    @FindBy(xpath = ".//input[@id='identifierId']")
//    WebElement login;
//
//    @FindBy(xpath = "//span[contains (text(), 'Далі')]")
//    WebElement buttonDali;
//
//    @FindBy(xpath = "//input[@type='password']")
//    WebElement pass;
//
//    @FindBy(xpath = "//div[contains(text(),'Написати')]")
//    WebElement whiteALetterButton;
//
//    @FindBy(xpath = "//div[contains(text(),'Одержувачі')]")
//    WebElement forWhomeField;
//
//    @FindBy(xpath = "//div[contains(text(),'Тема')]")
//    WebElement subject;
//
//    @FindBy(xpath = "//*[@id =':zg']")
//    WebElement body;
    By body = By.xpath("/*[@id =':zg']");
    By send = By.xpath("//div[contains(text(), 'Надіслати')]");
    private String authUrl = "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?redirect_uri=https%3A%2F%2Fdevelopers.google.com%2Foauthplayground&prompt=consent&response_type=code&client_id=407408718192.apps.googleusercontent.com&scope=email&access_type=offline&flowName=GeneralOAuthFlow";
    private String gmailUrl = "https://www.gmail.com";
    private String stack = "https://www.stackoverflow.com";
    private String email = "qa1.oleh@gmail.com";
    private String password = "2018-2018";
    private String bodySubject = "email for myself";


//    private WebElement openLogin;

    @BeforeTest(description = "open gmail")
    public void openGmail() {
//        driver.get(gmailUrl);
    }

    @Test(description = "check mail", priority = 1)
    public void checkMail() throws InterruptedException {
        driver.get(authUrl);


//        login.sendKeys(email);
//        buttonDali.click();
//        pass.sendKeys("2018-2018");
//        buttonDali.click();
//        driver.get(gmailUrl);
        driver.findElement(login).sendKeys(email);

        WebElement buttonDali = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonNext));
        Actions action = new Actions(driver);
        action.moveToElement(buttonDali).click().build().perform();

        driver.findElement(pass).sendKeys(password);

        WebElement buttonDali2 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonNext));
        Actions action2 = new Actions(driver);
        action2.moveToElement(buttonDali2).click().build().perform();

        driver.get(gmailUrl);

        WebElement createEmail = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(create));
        action.moveToElement(createEmail).click().build().perform();

        WebElement foWhom2 = driver.findElement(forWhom);
        Actions action3 = new Actions(driver);
        action.moveToElement(foWhom2).click().build().perform();

        driver.findElement(forWhom).sendKeys(email);
        driver.findElement(subject).sendKeys(bodySubject);
        driver.findElement(body).sendKeys(bodySubject);


        WebElement sendEmail = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(create));
        driver.findElement(send).click();
        action.moveToElement(sendEmail).click().build().perform();
    }
}
