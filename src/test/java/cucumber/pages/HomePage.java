package cucumber.pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    @FindBy(css = "a[href*='Agile']")
    WebElement agilePageLink;
    @FindBy(css = "a[href*='payment']")
    WebElement paymentPageLink;
    @FindBy(css = "input[name='uid']")
    List<WebElement> usernameInputs;
    @FindBy(css = "img[src*='Toy']")
    List<WebElement> paymentPageImages;

    public void navigate() {
        webDriver.get(Constants.homePageUrl);
        wait.until(ExpectedConditions.titleIs(Constants.homePageTitle));
    }

    public void navigateToAgilePage() {
        agilePageLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(usernameInputs));
    }

    public void navigateToPaymentPage() {
        paymentPageLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentPageImages));
    }
}
