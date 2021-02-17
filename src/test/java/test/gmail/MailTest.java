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

    private String pas2 = "forFun7777";
    private String pas3 = "autoauto77";
    private String pas = "Transwide01";

    private String bodySubjectText = "email for myself";
    private LoginPage loginPage;
    NewEmailPage newEmailPage;

    @BeforeTest(description = "Open email")
    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        emailBox = loginPage.loginToMailBox(fullEmail2, login, pas);
    }

    @Test(description = "check mail", priority = 1)
    public void checkMail() {

        emailBox.openEmailIfExistBySubject(bodySubjectText);
        newEmailPage = emailBox.reply()
                .fillBody(bodySubjectText);

        emailBox = newEmailPage.sendEmail();
    }
}
