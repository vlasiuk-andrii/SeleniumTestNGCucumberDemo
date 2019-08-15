package cucumber.steps;

import cucumber.SeleniumDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.AgilePage;
import cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationSteps {

    WebDriver webDriver = SeleniumDriver.webDriver;
    WebDriverWait wait = SeleniumDriver.wait;

    HomePage homePage = new HomePage(webDriver, wait);
    AgilePage agilePage = new AgilePage(webDriver, wait);

    @Given("^user is on home page$")
    public void user_is_on_homepage() {
        homePage.navigate();
    }

    @When("^user navigates to agile page$")
    public void user_navigates_to_agile_page() {
        homePage.navigateToAgilePage();
    }

    @When("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_and_password(String user, String password) {
        agilePage.enterUsername(user);
        agilePage.enterPassword(password);
    }

    @When("^click login button$")
    public void click_login_button() {
        agilePage.clickOnLoginButton();
    }

    @Then("^welcome message is correct$")
    public void welcome_message_is_correct() {
        agilePage.verifyWelcomeMessage();
    }
}
