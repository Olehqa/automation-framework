package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static test.BaseTest.driver;

public class LoginPage {
    @FindBy(name = "username")
    public WebElement loginField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    private String mainUrl = "https://mailsac.com/login?continue=/inbox/";


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public EmailBoxPage loginToMailBox(String fullEmail, String login, String password) {
        driver.get(mainUrl.concat(fullEmail));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new EmailBoxPage(driver);

    }
}
