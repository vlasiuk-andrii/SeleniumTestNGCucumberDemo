import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class GuruTestNGTests {

    int timeOutSeconds = 5;
    String userId = "1303";
    String password = "Guru99";
    String cardNumber = "1111222233334444";
    String expirationMonthValue = "11";
    String expirationYearValue = "2019";
    String succesfullPaymentText = "Payment successfull!";

    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, timeOutSeconds);
    }

    @BeforeMethod
    public void navigateToBaseUrl(){
        webDriver.get("http://demo.guru99.com");
    }

    @Test
    public void authorizationTest(){
        webDriver.findElement(By.cssSelector("a[href*='Agile']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='uid']")));
        webDriver.findElement(By.cssSelector("input[name='uid']")).sendKeys(userId);
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        webDriver.findElement(By.cssSelector("input[value='LOGIN']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("barone")));
    }

    @Test
    public void paymentTest(){
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
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
    }
}
