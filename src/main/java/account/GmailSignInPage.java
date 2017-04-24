package account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by Shakir on 4/19/2017.
 */
public class GmailSignInPage {
    public static WebDriver driver;
    public GmailSignInPage(WebDriver driver) {
        this.driver = driver;
    }
    protected By signinButton =By.xpath("//a[contains(text(),'Sign In')]");
    protected By email = By.id("Email");
    protected By nextButton = By.id("next");
    protected By passwordField = By.id("Passwd");
    protected By signin = By.id("signIn");
    protected static By googleIcon = By.id("gb");
    protected By loginSubmitButton = By.xpath("//input[@id='signIn']");
    protected By profilePicIcon = By.xpath("//span[@class='gb_9a gbii']");
    protected By signOutButton = By.xpath("//a[contains(text(),'Sign out')]");

    public void enterUsername(String username){
      driver.findElement(email).sendKeys(username);
    }
    public void clickOnSignIn(){
       driver.findElement(signinButton).click();
    }
     public void clickOnNextButton() {
        driver.findElement(nextButton).click();
    }
     public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
     public void clickOnsigninforlogon(){
        driver.findElement(loginSubmitButton).click();
    }
    public static boolean validateGoogleIconDisplay(){
         return driver.findElement(googleIcon).isDisplayed();
      }
    public void clickOnProfilePic(){
        driver.findElement(profilePicIcon).click();
       }
    public void clickOnSignoutButton(){
        driver.findElement(signOutButton).click();
    }
}
