package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver webDriver;
    WebDriverWait wait;

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void navigate() {
        webDriver.get("http://demo.guru99.com");
        wait.until(ExpectedConditions.titleIs("Guru99 Bank Home Page"));
    }

    public void navigateToAgilePage() {
        webDriver.findElement(By.cssSelector("a[href*='Agile']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='uid']")));
    }
}