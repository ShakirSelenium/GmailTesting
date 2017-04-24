package login;

import account.Base;
import account.GmailRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Shakir on 4/21/2017.
 */
public class GmailInvalidRegistrationPageTest extends Base{
    @Test
    public void Invalid_Register_to_Gmail() throws InterruptedException {
        GmailRegistrationPage regPage = new GmailRegistrationPage(driver);
        regPage.clickOnCreateAccount();
        sleepFor(5);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Create your Google Account"));
        regPage.inputFirstName("Purple");
        regPage.inputLirstName("Bricks");
        regPage.inputGmailAddress("PurpleBricks2001");
        regPage.inputPassword("Purple@2017");
        regPage.inputVerifyPWD("Purple@2017");
        regPage.inputBirthMonth("August");
        regPage.inputBirthDay("01");
        regPage.inputBirthYear("2000");
        regPage.clickonGenderButton();
        regPage.selectGender();
        regPage.ClickPhoneCountry();
    }

}
