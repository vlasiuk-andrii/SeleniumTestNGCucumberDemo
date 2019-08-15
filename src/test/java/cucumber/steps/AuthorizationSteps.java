package cucumber.steps;

import cucumber.SeleniumDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationSteps {

    WebDriver webDriver = SeleniumDriver.webDriver;
    WebDriverWait wait = SeleniumDriver.wait;

    @Given("^user is on home page$")
    public void user_is_on_homepage() {
        webDriver.get("http://demo.guru99.com");
        wait.until(ExpectedConditions.titleIs("Guru99 Bank Home Page"));
    }

    @When("^user navigates to agile page$")
    public void user_navigates_to_agile_page() {
        webDriver.findElement(By.cssSelector("a[href*='Agile']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='uid']")));
    }

    @When("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_and_password(String user, String password) {
        webDriver.findElement(By.cssSelector("input[name='uid']")).sendKeys(user);
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
    }

    @When("^click login button$")
    public void click_login_button() {
        webDriver.findElement(By.cssSelector("input[value='LOGIN']")).click();
    }

    @Then("^welcome message is correct$")
    public void welcome_message_is_correct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("barone")));
    }
}
