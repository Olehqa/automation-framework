package test.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static test.BaseTest.driver;

public class EmailBox {

    @FindBy(xpath = "//button[contains(text(),'Compose Message')]")
    private WebElement newEmailButton;

    EmailBox(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public NewEmailPage openNewEmailPage() {
        newEmailButton.click();
        return new NewEmailPage(driver);
    }
}
