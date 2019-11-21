package ForgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.*;


public class ForgotPasswordTest extends BaseTests {
    @Test
    public  void testForgotPassword(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("sobachiy@hui.com");
        //forgotPasswordPage.clickRetrievePasswordButton();
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();
        assertTrue(emailSentPage.getMessageText().contains("Your e-mail's been sent!"),
                "Alert text is incorrect");

    }
}
