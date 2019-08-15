package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

    static public WebDriver webDriver;
    static public WebDriverWait wait;

    static WebDriver initDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        return webDriver;
    }

    static WebDriverWait initWaiter(){
        wait = new WebDriverWait(webDriver, 5);
        return wait;
    }
}
