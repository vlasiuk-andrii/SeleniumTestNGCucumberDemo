package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AgilePage extends BasePage {

    public AgilePage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    @FindBy(css = "input[name='uid']")
    WebElement usernameInput;
    @FindBy(css = "input[name='password']")
    WebElement passwordInput;
    @FindBy(css = "input[value='LOGIN']")
    WebElement loginButton;
    @FindBy(className = "barone")
    List<WebElement> welcomeMessage;

    public void enterUsername(String user) {
        usernameInput.sendKeys(user);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void verifyWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElements(welcomeMessage));
    }
}
