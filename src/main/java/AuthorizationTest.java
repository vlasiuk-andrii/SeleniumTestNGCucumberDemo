import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationTest {

    static int timeOutSeconds = 5;
    static String userId = "1303";
    static String password = "Guru99";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutSeconds);

        webDriver.get("http://demo.guru99.com");
        webDriver.findElement(By.cssSelector("a[href*='Agile']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='uid']")));
        webDriver.findElement(By.cssSelector("input[name='uid']")).sendKeys(userId);
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        webDriver.findElement(By.cssSelector("input[value='LOGIN']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("barone")));

        webDriver.close();
    }
}
