package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void chooseQuantity(String quantity) {
        Select quantitySelect = new Select(webDriver.findElement(By.cssSelector("select[name='quantity']")));
        quantitySelect.selectByValue(quantity);
    }

    public void clickOnButton(String buttonName) {
        webDriver.findElement(By.cssSelector("input[value='" + buttonName + "']")).click();
    }

    public void waitForText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public void entercardDetails(String cardNumber, String expirationMonthValue, String expirationYearValue) {
        webDriver.findElement(By.id("card_nmuber")).sendKeys(cardNumber);
        Select expirationMonth = new Select(webDriver.findElement(By.id("month")));
        expirationMonth.selectByValue(expirationMonthValue);
        Select expirationYear = new Select(webDriver.findElement(By.id("year")));
        expirationYear.selectByValue(expirationYearValue);
        webDriver.findElement(By.id("cvv_code"));
    }
}
