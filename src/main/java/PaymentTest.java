import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentTest {

    static int timeOutSeconds = 5;
    static String cardNumber = "1111222233334444";
    static String expirationMonthValue = "11";
    static String expirationYearValue = "2019";
    static String succesfullPaymentText = "Payment successfull!";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutSeconds);

        webDriver.get("http://demo.guru99.com");
        webDriver.findElement(By.cssSelector("a[href*='payment']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src*='Toy']")));

        Select quatity = new Select(webDriver.findElement(By.cssSelector("select[name='quantity']")));
        quatity.selectByValue("2");
        webDriver.findElement(By.cssSelector("input[value='Buy Now']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'$40.00')]")));

        webDriver.findElement(By.id("card_nmuber")).sendKeys(cardNumber);
        Select expirationMonth = new Select(webDriver.findElement(By.id("month")));
        expirationMonth.selectByValue(expirationMonthValue);
        Select expirationYear = new Select(webDriver.findElement(By.id("year")));
        expirationYear.selectByValue(expirationYearValue);
        webDriver.findElement(By.id("cvv_code"));
        webDriver.findElement(By.cssSelector("input[value='Pay $40.00']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + succesfullPaymentText +"')]")));

        webDriver.close();
    }
}
