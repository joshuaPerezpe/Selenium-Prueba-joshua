package pages;

public class GridPage extends BasePage {

    private String cell = "//*[@id='root']/div/";
    private String yesButton = "//a[@id='btn-answer-yes']";

    public GridPage(){
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app");
        clickElement(yesButton);
    }


    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }

}