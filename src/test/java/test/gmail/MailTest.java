package test.gmail;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;
import test.gmail.pages.EmailBox;
import test.gmail.pages.LoginPage;
import test.gmail.pages.NewEmailPage;

public class MailTest extends BaseTest {

    EmailBox emailBox;
    NewEmailPage newEmailPage;
    private String email = "forfun777";
    private String fullEmail = "forFun@mailsac.com";
    private String p = "forFun7777";


//    By login = By.xpath(".//input[@id='identifierId']");
//    By buttonNext = By.xpath("//span[contains (text(), 'Далі')]");
//    By pass = By.xpath("//input[@type='password']");
//    By create = By.xpath("//div[contains(text(),'Написати')]");
//    By forWhom = By.xpath("//div[contains(text(),'Одержувачі')]");
//    By subject = By.xpath("//div[contains(text(),'Тема')]");

    //    By body = By.xpath("/*[@id =':zg']");
//    By send = By.xpath("//div[contains(text(), 'Надіслати')]");
    private String bodySubject = "email for myself";


//    private WebElement openLogin;

    @BeforeTest(description = "open gmail")
    public void openGmail() {
//        driver.get(gmailUrl);
    }

    @Test(description = "check mail", priority = 1)
    public void checkMail() throws InterruptedException {
//        driver.get(authUrl);
        LoginPage loginPage = new LoginPage(driver);
        newEmailPage = loginPage.loginToMailBox(email, p)
                .openNewEmailPage();


        newEmailPage.fillToEmail(email)
                .fillSubject("Email to myself")
                .fillBody("Hello to you");


//        login.sendKeys(email);
//        buttonDali.click();
//        pass.sendKeys("2018-2018");
//        buttonDali.click();
//        driver.get(gmailUrl);
//        driver.findElement(login).sendKeys(email);
//
//        WebElement buttonDali = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonNext));
//        Actions action = new Actions(driver);
//        action.moveToElement(buttonDali).click().build().perform();

//        driver.findElement(pass).sendKeys(password);
//
//        WebElement buttonDali2 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonNext));
//        Actions action2 = new Actions(driver);
//        action2.moveToElement(buttonDali2).click().build().perform();
//
//        driver.get(gmailUrl);
//
//        WebElement createEmail = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(create));
//        action.moveToElement(createEmail).click().build().perform();
//
//        WebElement foWhom2 = driver.findElement(forWhom);
//        Actions action3 = new Actions(driver);
//        action.moveToElement(foWhom2).click().build().perform();
//
//        driver.findElement(forWhom).sendKeys(email);
//        driver.findElement(subject).sendKeys(bodySubject);
//        driver.findElement(body).sendKeys(bodySubject);
//
//
//        WebElement sendEmail = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(create));
//        driver.findElement(send).click();
//        action.moveToElement(sendEmail).click().build().perform();
    }
}
