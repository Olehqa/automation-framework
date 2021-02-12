package test.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static test.BaseTest.driver;
import static test.gmail.MailTest.SUBJECT;

public class EmailBoxPage {

    private static final By REPLY_BUTTON = By.xpath(String.format("//input[contains(@value, '%s')]//following-sibling::button", SUBJECT));

    @FindBy(xpath = "//button[contains(text(),'Compose Message')]")
    private WebElement newEmailButton;

    @FindBy(xpath = "//table[contains(@class, 'table')]//td[contains(@class, 'col-xs-4')]//strong")
    private List<WebElement> emailAddresses;

    @FindBy(xpath = "//table[contains(@class, 'table')]//td[contains(@class, 'col-xs-5')]")
    private List<WebElement> subjects;

    @FindBy(xpath = "//table[contains(@class, 'table')]//tr[contains(class, '')][2]//td[contains(@class, 'col-xs-4')]")
    private WebElement emailAddress;

    @FindBy(xpath = "//table[contains(@class, 'table')]//tr[contains(class, '')][2]//td[contains(@class, 'col-xs-5')]")
    private WebElement subject;


    EmailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public NewEmailPage openCreateNewEmailPage() {
        newEmailButton.click();
        return new NewEmailPage(driver);
    }

    public String getLastEmailAddressFromEmailList() {
        return emailAddresses.get(0).getText();
    }

    public void openLastEmailAddressFromEmailList() {
        emailAddresses.get(0).click();
    }

    public List<WebElement> getAllEmailAddresses() {
        return new ArrayList<>(emailAddresses);
    }

    public List<WebElement> getAllSubjects() {
        return new ArrayList<>(subjects);
    }

    public EmailBoxPage openEmailIfExistByEmail(String emailAddress) throws Exception {
        for (WebElement email : getAllEmailAddresses()) {
            if (email.getText().equals(emailAddress)) {
                email.click();
                return new EmailBoxPage(driver);
            }
        }
        throw new Exception("email not found");
    }

    public EmailBoxPage openEmailIfExistBySubject(String subject) throws Exception {
        for (WebElement text : getAllSubjects()) {
            if (text.getText().equals(subject)) {
                text.click();
                return new EmailBoxPage(driver);
            }
        }
        throw new Exception("email not found");
    }

    public NewEmailPage reply() {
        driver.findElement(REPLY_BUTTON).click();
        return new NewEmailPage(driver);
    }
}


