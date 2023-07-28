package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private static WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public static String skilloLogo() {
        WebElement skilloLogo = driver.findElement(By.id("homeIcon"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(skilloLogo));
        return skilloLogo.getText();
    }
    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
    }
    public void newPostLink() {
        WebElement newPostLink = driver.findElement(By.id("nav-link-new-post"));
        newPostLink.click();
    }
}
