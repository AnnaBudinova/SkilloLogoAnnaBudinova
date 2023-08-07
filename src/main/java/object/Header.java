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

    public boolean isSkilloLogoDisplayed() {
        WebElement isSkilloLogoDisplayed = driver.findElement(By.id("homeIcon"));
        return isSkilloLogoDisplayed.isDisplayed();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
    }
    public void newPostLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newPostLink = driver.findElement(By.id("nav-link-new-post"));
        newPostLink.click();
    }
}
