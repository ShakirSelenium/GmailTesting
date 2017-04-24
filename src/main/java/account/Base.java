package account;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Shakir on 4/19/2017.
 */
public class Base {
    public WebDriver driver = null;
    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver", ".//selenium-browser-driver//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/gmail/about/#");
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByHref(String locator) {
        driver.findElement(By.partialLinkText(locator)).click();
    }
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    public List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            text.add(web.getText());
        }

        return text;
    }
    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
    public void navigateBack() {
        driver.navigate().back();
    }
    public void navigateForward() {
        driver.navigate().forward();
    }
    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }
    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void selectOptionByVisibleText(String locator, String value) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByVisibleText(value);
    }
    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //iFrame Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }
    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    //Taking Screen shots
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }
    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
     }
    public void selectByValue(String locator, String value) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByValue(value);
    }
    public void scrollToElementByxpath(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true)",element);}
    public void navigateRefresh(){
        driver.navigate().refresh();
    }
    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 3000)");
    }
    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("scroll(0, -3000)");
    }
    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void clickAllSimilarLinksByCss (String locator) throws InterruptedException {
        String[] links;
        int linksCount;
        List<WebElement> linksize = driver.findElements(By.cssSelector(locator));
        linksCount = linksize.size();

        links= new String[linksCount];
        for(int i=0;i<linksCount;i++)
        {
            links[i] = linksize.get(i).getAttribute("href");

        }
        for(int i=0;i<linksCount;i++)
        {
            driver.navigate().to(links[i]);
            Thread.sleep(3000);
            driver.navigate().back();
        }
    }
}
