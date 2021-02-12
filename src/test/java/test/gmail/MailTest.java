package test.gmail;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;
import test.gmail.pages.EmailBoxPage;
import test.gmail.pages.LoginPage;
import test.gmail.pages.NewEmailPage;

public class MailTest extends BaseTest {
    public static final String SUBJECT = "Subject1";
    EmailBoxPage emailBox;
    private String login = "alpegaqa";
    private String login2 = "forfun777";
    private String login3 = "oleh";
    private String fullEmail = "alpegaqa@mailsac.com";
    private String fullEmail2 = "forfun777@mailsac.com";
    private String fullEmail3 = "oleh@mailsac.com";

    //todo insert code with pass
    private String emailForCheck = "qa1.oleh@gmail.com";
    private String bodySubjectText1 = "Subject2";
    private String bodySubjectText2 = "Subject1";
    private LoginPage loginPage;
    NewEmailPage newEmailPage;

    @BeforeTest(description = "open gmail")
    public void openLoginPage() {
        loginPage = new LoginPage(driver);
    }

    @Test(description = "check mail", priority = 1)
    public void checkMail() throws Exception {
        emailBox = loginPage.loginToMailBox(fullEmail2, login, pas);
        emailBox.openEmailIfExistBySubject(bodySubjectText2);
        newEmailPage = emailBox.reply()
                .fillBody(bodySubjectText2);

        emailBox = newEmailPage.sendEmail();
    }
}
