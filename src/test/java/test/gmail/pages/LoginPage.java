package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static test.BaseTest.driver;

public class LoginPage {
    @FindBy(xpath = "//input[@name='username']")
    public WebElement loginField;
    //            "https://mailsac.com/";
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signIn;
    private String mainUrl = "https://mailsac.com/login?continue=/inbox/forfun777@mailsac.com";


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(mainUrl);
    }

    public EmailBox loginToMailBox(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signIn.click();
        return new EmailBox(driver);


//        WebElement buttonDali = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonNext));
//        Actions action = new Actions(driver);
//        action.moveToElement(buttonDali).click().build().perform();
    }
}
