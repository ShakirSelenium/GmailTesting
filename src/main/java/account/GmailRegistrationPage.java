package account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shakir on 4/20/2017.
 */
public class GmailRegistrationPage extends Base {
    public static WebDriver driver;
    public GmailRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    protected By createAccount = By.xpath("//a[contains(text(),'Create an account')]");
    protected By firstname = By.xpath(".//*[@id='FirstName']");
    protected By lastname = By.xpath(".//*[@id='LastName']");
    protected By gmailAddress = By.xpath("//input[@id='GmailAddress']");
    protected By password = By.xpath(".//*[@id='Passwd']");
    protected By verifyPassword = By.xpath(".//*[@id='PasswdAgain']");
    protected By birthMonth = By.xpath(".//*[@id='BirthMonth']/div");
    protected By birthDay= By.xpath(".//*[@id='BirthDay']");
    protected By birthYear = By.xpath(".//*[@id='BirthYear']");
    protected By genderMale = By.xpath(".//*[@id=':f']");
    protected By genderClick = By.xpath(".//*[@id='Gender']/div");
    protected By selectPhnCountry = By.xpath(".//*[@id='phone-form-element']/table/tbody/tr/th/div");
    protected By selectPhnCountryUK = By.xpath(".//*[@id=':dx']");
    protected By phone = By.xpath(".//*[@id='RecoveryPhoneNumber']");
    protected By recoveryEmail = By.xpath(".//*[@id='RecoveryEmailAddress']");
    protected By location = By.xpath(".//*[@id=':i']");
    protected By locationUK = By.xpath(".//*[@id=':7c']");
    protected By submitButton = By.xpath(".//*[@id='submitbutton']");
    protected By scrollDownButton = By.xpath(".//*[@id='tos-scroll-button']/div/img");
    public By IAgreeButton = By.xpath(".//*[@id='iagreebutton']");
    public By verifyAccount = By.xpath(".//*[@id='signupidv']/a");



    public void clickOnCreateAccount(){
        driver.findElement(createAccount).click();
    }
    public void inputFirstName(String fname){
        driver.findElement(firstname).sendKeys(fname);
    }
    public void inputLirstName(String lname){
        driver.findElement(lastname).sendKeys(lname);
    }
    public void inputGmailAddress(String email){
        driver.findElement(gmailAddress).sendKeys(email);
    }
    public void inputPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void inputVerifyPWD(String vPassword){
        driver.findElement(verifyPassword).sendKeys(vPassword);
    }
    public void inputBirthMonth(String BirthMonth){
        driver.findElement(birthMonth).sendKeys(BirthMonth);
    }
    public void inputBirthDay(String BirthDay){
        driver.findElement(birthDay).sendKeys(BirthDay);
    }
    public void inputBirthYear(String BirthYear){
        driver.findElement(birthYear).sendKeys(BirthYear);
    }
    public void clickonGenderButton(){
        driver.findElement(genderClick).click();
    }
    public void selectGender(){
        driver.findElement(genderMale).click();
    }
    public void ClickPhoneCountry(){
        driver.findElement(selectPhnCountry).click();
    }
    public void SelectPhoneCountryUK(){
        driver.findElement(selectPhnCountryUK).click();
    }
    public void inputPhone(String phn){
        driver.findElement(phone).sendKeys(phn);
    }
    public void inputRecoveryEmail(String RecEmail){
        driver.findElement(recoveryEmail).sendKeys(RecEmail);
    }
    public void ClickOnLocation(){
        driver.findElement(location).click();
    }
    public void SelectLocationUK(){
        driver.findElement(locationUK).click();
    }
    public void inputSubmitButton(){
        driver.findElement(submitButton).click();
    }
    public void clickOnScrollDownButton()
    {
        driver.findElement(scrollDownButton).click();
    }
    public void clickOnIAgreeButton()
    {
        driver.findElement(IAgreeButton).click();
    }
    public void clickOnVerfyLink()
    {
        driver.findElement(verifyAccount).click();
    }


}
