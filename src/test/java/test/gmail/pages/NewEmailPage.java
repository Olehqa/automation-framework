package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static test.BaseTest.driver;

public class NewEmailPage {

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Send;
    @FindBy(xpath = "//input[@name='to']")
    private WebElement to;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subject;
    @FindBy(xpath = "//textarea[@name='text']")
    private WebElement boddy;

    NewEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillToEmail(String toEmail) {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        

        WebElement to2 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(to));
        Actions action = new Actions(driver);
        action.moveToElement(to2).sendKeys(toEmail).build().perform();
    }

    public NewEmailPage fillSubject(String emailSubject) {
        subject.sendKeys(emailSubject);
        return this;
    }

    public NewEmailPage fillBody(String emailBody) {
        boddy.sendKeys(emailBody);
        return this;
    }
}
