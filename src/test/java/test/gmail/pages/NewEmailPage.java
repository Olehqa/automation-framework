package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static test.BaseTest.driver;

public class NewEmailPage {
    @FindBy(xpath = "//input[@name='to']")
    private WebElement toEmailField;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//textarea[@name='text']")
    private WebElement bodyField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    private Actions action;

    NewEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public NewEmailPage fillToEmail(String toEmail) {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        action.click(toEmailField).sendKeys(toEmail).build().perform();
        return new NewEmailPage(driver);
    }

    public NewEmailPage fillSubject(String emailSubject) {
        action.click(subjectField).sendKeys(emailSubject).build().perform();
        return new NewEmailPage(driver);
    }

    public NewEmailPage fillBody(String emailBody) {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }

        action.click(bodyField).sendKeys(emailBody).build().perform();
        return new NewEmailPage(driver);
    }

    public EmailBoxPage sendEmail() {
        action.click(submitButton).build().perform();

        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        return new EmailBoxPage(driver);
    }
}
