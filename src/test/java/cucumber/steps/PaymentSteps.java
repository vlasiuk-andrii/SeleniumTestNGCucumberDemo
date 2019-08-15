package cucumber.steps;

import cucumber.SeleniumDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.HomePage;
import cucumber.pages.PaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentSteps {

    WebDriver webDriver = SeleniumDriver.webDriver;
    WebDriverWait wait = SeleniumDriver.wait;

    HomePage homePage = new HomePage(webDriver, wait);
    PaymentPage paymentPage = new PaymentPage(webDriver, wait);

    @When("user navigates to payment page")
    public void user_navigates_to_payment_page() {
        homePage.navigateToPaymentPage();
    }

    @When("user choose quantity {string}")
    public void user_choose_quantity(String quantity) {
        paymentPage.chooseQuantity(quantity);
    }

    @When("click {string}")
    public void click(String buttonName) {
        paymentPage.clickOnButton(buttonName);
    }

    @When("{string} text is shown")
    public void text_is_shown(String text){
        paymentPage.waitForText(text);
    }

    @When("enter card details")
    public void enter_card_details() {
        String cardNumber = "1111222233334444";
        String expirationMonthValue = "11";
        String expirationYearValue = "2019";
        paymentPage.entercardDetails(cardNumber, expirationMonthValue, expirationYearValue);
    }

    @Then("{string} message is shown")
    public void message_is_shown(String succesfullPaymentText) {
        paymentPage.waitForText(succesfullPaymentText);
    }

}
