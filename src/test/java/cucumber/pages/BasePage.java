package cucumber.pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver webDriver;
    WebDriverWait wait;

    public BasePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;

        //// Usual init:
        // PageFactory.initElements(webDriver, this);
        //// or
        //// Here, when an operation is performed on an element the wait for its visibility starts from that moment only:
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriver, Constants.defaultTimeoutSeconds);
        PageFactory.initElements(factory, this);
    }
}
