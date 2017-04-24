package login;

import account.Base;
import account.GmailSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Shakir on 4/19/2017.
 */
public class GmailSignInPageTest extends Base{
    @Test
    public void Login_To_Gmail() throws InterruptedException {
        GmailSignInPage signInPage = new GmailSignInPage(driver);
        signInPage.clickOnSignIn();
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Gmail"));
        sleepFor(5);
        signInPage.enterUsername("PurpleBricks2017");
        signInPage.clickOnNextButton();
        sleepFor(5);
        signInPage.enterPassword("Purple@2017");
        signInPage.clickOnsigninforlogon();
        sleepFor(8);
        Assert.assertTrue(GmailSignInPage.validateGoogleIconDisplay());
        sleepFor(8);
        signInPage.clickOnProfilePic();
        signInPage.clickOnSignoutButton();
        sleepFor(5);
    }
}
