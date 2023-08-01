package annabudinova;

import object.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SkilloLogoTests extends TestObject {

    @DataProvider(name = "loginUser")
    public Object[][] loginUsers() {
        return new Object[][]{
                {"anbori@abv.bg", "_Passw0rd"},
        };
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                {"anbori@abv.bg", "_Passw0rd", "annabudinova"}, //login with username
        };
    }

    @Test
    public void skilloLogoGuestTest() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Assert.assertTrue(homePage.isUrlLoaded(), "The HOME URL is not correct!");
        Header header = new Header(driver);

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");

    }

    @Test(dataProvider = "loginUser")
    public void skilloLogoRegisterUserHome(String user, String password) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);
        Header header = new Header(driver);

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");

    }

    @Test(dataProvider = "getUsers")
    public void skilloLogoRegisterUserProfile(String user, String password, String name) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");
    }

    @Test(dataProvider = "loginUser")
    public void skilloLogoRegisterUserPostLink(String user, String password) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");
        Header header = new Header(driver);
        header.newPostLink();
        NewPostPage newPostPage = new NewPostPage(driver);
        Assert.assertTrue(newPostPage.isUrlLoaded(), "The Profile URL is not correct!");
        String isTextDisplayed = newPostPage.isTextDisplayed();
        Assert.assertEquals(isTextDisplayed, "Post a picture to share with your awesome followers");

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");
    }
    @Test
    public void skilloLogoWrongUrl() {
        WebDriver driver = getDriver();
        WrongUrl wrongUrl = new WrongUrl(driver);
        wrongUrl.navigateTo();
        Assert.assertTrue(wrongUrl.isUrlLoaded(), "The HOME URL is not correct!");
        Header header = new Header(driver);

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");
    }

    @Test
    public void skilloLogoRegisterPage() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "The HOME URL is not correct!");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.isUrlLoaded(), "The Register URL is not correct!");
        registerPage.isTextDisplayed();
        Header header = new Header(driver);

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");
    }

    @Test(dataProvider = "getUsers")
    public void skilloLogoEditRegisterUser(String user, String password, String name) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");
        profilePage.userEditButton();

        Assert.assertTrue(header.skilloLogo(),"The logo is not displayed");
    }
}
