package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    private static Actions action;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    public BasePage(WebDriver driver){

        BasePage.driver = driver;
    }


    public static void navigateTo(String url){

        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void clickElement(String locator){
        Find(locator).click();

    }

    public void write(String locator, String KeyToSend){
        Find(locator).clear();
        Find(locator).sendKeys(KeyToSend);
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void selectNthElement(String locator, int index){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();

    }

    public void selectFromDropDownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropDownByIndex(String locator, int index) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int selectFromDropDownSize(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public void hoverOverElement(String locator){

        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){

        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){

        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

}
