package cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = {""},
        plugin = {"pretty", "html:target/htmlreports"}
)
public class CucumberRunner {

    @BeforeClass
    public static void startUp() {
        SeleniumDriver.initDriver();
        SeleniumDriver.initWaiter();
    }

    @AfterClass
    public static void teardown() {
        SeleniumDriver.webDriver.close();
    }
}
