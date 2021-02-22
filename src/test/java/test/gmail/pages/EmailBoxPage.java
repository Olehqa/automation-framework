package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static test.BaseTest.driver;

@FindBy(xpath = "//table[contains(@class, 'table')]")
public class EmailBoxPage {


    @FindBy(xpath = "//button[contains(text(),'Compose Message')]")
    private WebElement newEmailButton;

    @FindBys(@FindBy(xpath = "//table[contains(@class, 'table')]//tr[contains(class, '')]"))
    public List<MailRow> mailRows;

    public List<MailRow> getRows() {
//        mailRows = driver.findElements(By.xpath("//table[contains(@class, 'table')]//tr[contains(class, '')]"));
        return mailRows;
    }

    EmailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public NewEmailPage openCreateNewEmailPage() {
        newEmailButton.click();
        return new NewEmailPage(driver);
    }


    public MailRow searchEmail(String address, String subject) {
        return mailRows.stream().filter(row -> row.getAddressValue().equals(address) &&
                row.getSubjectValue().equals(subject))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format(
                        "There is no email with address %s and subject %s", address, subject)))
                .select();
    }
}


