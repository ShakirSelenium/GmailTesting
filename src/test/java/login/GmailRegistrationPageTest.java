package login;

import account.Base;
import account.GmailRegistrationPage;
import org.testng.annotations.Test;

/**
 * Created by Shakir on 4/20/2017.
 */
public class GmailRegistrationPageTest extends Base{
    @Test
    public void Register_to_Gmail() throws InterruptedException {
        GmailRegistrationPage regPage = new GmailRegistrationPage(driver);
        regPage.clickOnCreateAccount();
        sleepFor(5);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
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
        regPage.SelectPhoneCountryUK();
        regPage.inputPhone("08008108419");
        regPage.inputRecoveryEmail("purplebricks555@gmail.com");
        regPage.ClickOnLocation();
        regPage.SelectLocationUK();
        regPage.inputSubmitButton();
        sleepFor(8);
        regPage.clickOnScrollDownButton();
        regPage.clickOnScrollDownButton();
        regPage.clickOnScrollDownButton();
        regPage.clickOnScrollDownButton();
        waitUntilClickAble(regPage.IAgreeButton);
        regPage.clickOnIAgreeButton();
        waitUntilVisible(regPage.verifyAccount);
        regPage.clickOnVerfyLink();
        sleepFor(10);
    }
}
