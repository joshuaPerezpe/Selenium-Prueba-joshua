package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridTestSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to (.*)$")
    public void navigateToGridPage(String texto){
        grid.navigateToGrid();
        System.out.println("el texto es: " + texto);

    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3, 2);

        System.out.println(value);
    }

    @Then("I can validate the table is displayed")
    public void validateResult(){
        Assert.assertFalse("booom", grid.cellStatus());
    }



}