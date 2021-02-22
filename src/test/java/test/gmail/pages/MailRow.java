package test.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static test.BaseTest.driver;
import static test.gmail.MailTest.SUBJECT;

@FindBy(xpath = "//table[contains(@class, 'table')]//tr[contains(class, '')]")
public class MailRow {

    private static final By REPLY_BUTTON = By.xpath(String.format(".//input[contains(@value, '%s')]//following-sibling::button", SUBJECT));
    private String emailAdressPath = ".//td[contains(@class, 'col-xs-4')]";


//    public BookingRow(By locator) {
//        super(locator);
//    }

    //    @FindBy(xpath = "//table[contains(@class, 'table')]//td[contains(@class, 'col-xs-4')]//strong")
//    private List<WebElement> emailAddresses;
//
//    @FindBy(xpath = "//table[contains(@class, 'table')]//td[contains(@class, 'col-xs-5')]")
//    private List<WebElement> subjects;
    private String subjectPath = ".//td[contains(@class, 'col-xs-5')]";
    @FindBy(xpath = "//table[contains(@class, 'table')]//tr[contains(class, '')]//td[contains(@class, 'col-xs-4')]")
    private WebElement emailAddress;
    @FindBy(xpath = "/table[contains(@class, 'table')]//tr[contains(class, '')]//td[contains(@class, 'col-xs-5')]")
    private WebElement subject;
    private String emailAdressPathPosition = "//table[contains(@class, 'table')]//tr[contains(class, '')][%s]//td[contains(@class, 'col-xs-4')]";
    private String subjectPathPosition = "//table[contains(@class, 'table')]//tr[contains(class, '')][%s]//td[contains(@class, 'col-xs-5')]";

    MailRow(WebDriver driver) {
        PageFactory.initElements(driver, this);
//               driver.findElements(By.xpath("//table[contains(@class, 'table')]//tr[contains(class, '')]"));
    }

    //To locate table.
//    private WebElement table = driver.findElement(By.xpath(""));

    public By getAddressXpath(String position) {
        return By.xpath(String.format(emailAdressPath, position));
    }

    public By getSubjectXpath(String position) {
        return By.xpath(String.format(subjectPath, position));
    }

    private String getCellValue(By xpath) {
        return driver.findElement(xpath).getText();
    }

    private String getCellValue(WebElement element) {
        return element.getText();
    }

    public String getAddressValueByPosition(int position) {
        return getCellValue(getAddressXpath(String.valueOf(position)));
    }

    public String getSubjectValueByPosition(int position) {
        return getCellValue(getSubjectXpath(String.valueOf(position)));
    }

    public String getAddressValue() {
        return getCellValue(emailAddress);
    }

    public String getSubjectValue() {
        return getCellValue(subject);
    }

//    public void getCell() {
//
//
//        int rows_count = rows.size();
//        String celtext;
//        for (int row = 0; row < rows_count; row++) {
//            int columns_count = Columns_row.size();
//            for (int column = 0; column < columns_count; column++) {
//
//                celtext = Columns_row.get(column).getText();
//            }
//        }
//    }

    public MailRow select() {
        emailAddress.click();
        return this;
    }

    public NewEmailPage reply() {
        driver.findElement(REPLY_BUTTON).click();
        return new NewEmailPage(driver);
    }
}
