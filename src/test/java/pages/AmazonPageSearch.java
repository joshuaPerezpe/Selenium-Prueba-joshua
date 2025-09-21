package pages;

import org.openqa.selenium.By;

import java.util.List;

public class AmazonPageSearch extends BasePage{

    private String continueShoppingButton = "//button[normalize-space()='Continue shopping']";
    private String searchBox = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String secondPageButton = "//a[@aria-label='Ir a la página 2']";
    private String searchResults = "//div[@data-component-type='s-search-result']"; // <-- Versión CORRECTA
    private String addToCartButton = "//input[@id='add-to-cart-button']";

    public AmazonPageSearch(){
        super(driver);
    }

    public void clickOnContinueShoppingButton(){
        clickElement(continueShoppingButton);

    }

    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");

    }

    public void clickOnSearchBox(){
            clickElement(searchBox);

    }

    public void clickOnSearchButton(){
            clickElement(searchButton);

    }

    public void clickOnSecondPageButton(){
            clickElement(secondPageButton);

    }

    public void clickOnAddToCartButton(){
        clickElement((addToCartButton));
    }

//    public void goToLink(String linkText){
//        driver.findElement(By.linkText(linkText)).click();
//    }


    public void enterProduct(String product){
            write(searchBox, product);
    }

    public void selectThirdResult() {
        selectNthElement(searchResults, 2);
    }





}
