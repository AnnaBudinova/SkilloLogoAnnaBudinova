package annabudinova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Vessi {

    @Test
   public void testLogo(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/users/login");
        WebElement homeLogo = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(homeLogo.isDisplayed(),"The logo is not displayed");
        driver.close();
    }
}
