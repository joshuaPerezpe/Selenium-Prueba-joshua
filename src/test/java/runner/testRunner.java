package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = { "pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = "@Plan"
)

public class testRunner {

    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}


