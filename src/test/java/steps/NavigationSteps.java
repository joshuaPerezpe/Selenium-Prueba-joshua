package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.amazon.AmazonPageSearch;

public class NavigationSteps {

    AmazonPageSearch amazon = new AmazonPageSearch(); // Esto es una instancia. Que define el objeto real como tal.

    @Given("the user nagivates to www.amazon.com")
    public void navigateToAmazon() {
        amazon.navigateToAmazon();
    }

    @And("click on Continue Shopping button")
    public void clickOnContinueShoppingButton() {
        amazon.clickOnContinueShoppingButton();
    }



    @And("click on SearchBox")
        public void clickOnSearchBox(){
        amazon.clickOnSearchBox();

    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria){
        amazon.enterProduct(criteria);
        amazon.clickOnSearchButton();

    }

    @And("navigates to page number 2")
    public void goToSecondPage(){
        amazon.clickOnSecondPageButton();
    }
// option para ir a link optiones
//    @And("^navigates to page number (.+)$")
//    public void goToSecondPage(String pageNumber){
//    amazon.goToLink(pageNumber);
//    }

    @And("selects the third item")
    public void selectThirdResult(){
        amazon.selectThirdResult();
    }

    @Then("the user is able to add it to the cart")
    public void clickOnAddToCartButton(){
        amazon.clickOnAddToCartButton();
    }

    @And("validate text")
    public void validateResult(){
        Assert.assertEquals(amazon.validateFirstResult(), "Envío GRATIS a Chile");
    }




}
