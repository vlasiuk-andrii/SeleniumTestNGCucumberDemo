package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    @FindBy(css = "select[name='quantity']")
    WebElement quantityDropDown;
    @FindBy(id = "card_nmuber")
    WebElement cardNumberInput;
    @FindBy(id = "month")
    WebElement monthDropDown;
    @FindBy(id = "year")
    WebElement yearDropDown;
    @FindBy(id = "cvv_code")
    WebElement cvvInput;

    public void chooseQuantity(String quantity) {
        Select select = new Select(quantityDropDown);
        select.selectByValue(quantity);
    }

    public void clickOnButton(String buttonName) {
        webDriver.findElement(By.cssSelector("input[value='" + buttonName + "']")).click();
    }

    public void waitForText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public void entercardDetails(String cardNumber, String expirationMonthValue, String expirationYearValue, String cvvCode) {
        cardNumberInput.sendKeys(cardNumber);
        Select expirationMonth = new Select(monthDropDown);
        expirationMonth.selectByValue(expirationMonthValue);
        Select expirationYear = new Select(yearDropDown);
        expirationYear.selectByValue(expirationYearValue);
        cvvInput.sendKeys(cvvCode);
    }
}
