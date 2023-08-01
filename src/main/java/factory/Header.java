package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    @FindBy(id = "homeIcon")
    private WebElement skilloLogo;
    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;
    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public boolean skilloLogo() {
        return skilloLogo.isDisplayed();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }
    public void newPostLink() {
        newPostLink.click();
    }
}
