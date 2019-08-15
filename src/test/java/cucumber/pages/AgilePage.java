package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgilePage extends BasePage {

    public AgilePage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void enterUsername(String user) {
        webDriver.findElement(By.cssSelector("input[name='uid']")).sendKeys(user);
    }

    public void enterPassword(String password) {
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
    }

    public void clickOnLoginButton() {
        webDriver.findElement(By.cssSelector("input[value='LOGIN']")).click();
    }

    public void verifyWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("barone")));
    }
}
