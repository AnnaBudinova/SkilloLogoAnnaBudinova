package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotFoundPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/not-found";
    private final WebDriver driver;

    public NotFoundPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(NotFoundPage.PAGE_URL));
    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
}
