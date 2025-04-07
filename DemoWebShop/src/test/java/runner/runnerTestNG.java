package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import utilities.ListenersClass;

@Listeners(ListenersClass.class)
@CucumberOptions(
        features = "src/test/resources/features", 
        glue = "definitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports1.html",
                "json:target/cucumber1.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class runnerTestNG extends AbstractTestNGCucumberTests {
}
