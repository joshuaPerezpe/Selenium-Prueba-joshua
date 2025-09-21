package pages;



import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    // defino variable del tipo WebDriver llamada driver para que sea llamada desde otras clases
    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // crear constructor de BasePag que acepta Webdriver como argumento.
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
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

    public void selectNthElement(String locator, int index){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();

    }



}
