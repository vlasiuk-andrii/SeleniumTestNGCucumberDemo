package cucumber.steps;

import cucumber.SeleniumDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentSteps {

    WebDriver webDriver = SeleniumDriver.webDriver;
    WebDriverWait wait = SeleniumDriver.wait;

    @When("user navigates to payment page")
    public void user_navigates_to_payment_page() {
        webDriver.findElement(By.cssSelector("a[href*='payment']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src*='Toy']")));
    }

    @When("user choose quantity {string}")
    public void user_choose_quantity(String quantity) {
        Select quatity = new Select(webDriver.findElement(By.cssSelector("select[name='quantity']")));
        quatity.selectByValue(quantity);
    }

    @When("click {string}")
    public void click(String buttonName) {
        webDriver.findElement(By.cssSelector("input[value='" + buttonName + "']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'$40.00')]")));
    }

    @When("enter card details")
    public void enter_card_details() {
        String cardNumber = "1111222233334444";
        String expirationMonthValue = "11";
        String expirationYearValue = "2019";
        webDriver.findElement(By.id("card_nmuber")).sendKeys(cardNumber);
        Select expirationMonth = new Select(webDriver.findElement(By.id("month")));
        expirationMonth.selectByValue(expirationMonthValue);
        Select expirationYear = new Select(webDriver.findElement(By.id("year")));
        expirationYear.selectByValue(expirationYearValue);
        webDriver.findElement(By.id("cvv_code"));
    }

    @When("click on {string}")
    public void click_on(String buttonName) {
        webDriver.findElement(By.cssSelector("input[value='" + buttonName + "']")).click();
    }

    @Then("{string} message is shown")
    public void message_is_shown(String succesfullPaymentText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + succesfullPaymentText +"')]")));
    }

}
