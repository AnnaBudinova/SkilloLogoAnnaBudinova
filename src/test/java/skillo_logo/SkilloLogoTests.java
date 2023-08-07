package skillo_logo;

import factory.*;
import org.openqa.selenium.WebDriver;
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
                {"anbori@abv.bg", "_Passw0rd", "annabudinova"},
        };
    }

    @Test
    public void testLogoHomePageGuestUser() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "The HOME URL is not correct!");
        Header header = new Header(driver);
        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test
    public void testLogoLoginPage() {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String isTextDisplayed = loginPage.isTextDisplayed();
        Assert.assertEquals(isTextDisplayed, "Sign in");
        Header header = new Header(driver);
        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test(dataProvider = "loginUser")
    public void testLogoHomePageRegisterUser(String user, String password) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test(dataProvider = "getUsers")
    public void testLogoProfilePageRegisterUser(String user, String password, String name) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        Header header = new Header(driver);
        header.clickProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");

        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test(dataProvider = "loginUser")
    public void testLogoPostPageRegisterUser(String user, String password) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        header.newPostLink();
        PostPage postPage = new PostPage(driver);
        Assert.assertTrue(postPage.isUrlLoaded(), "The Profile URL is not correct!");
        String isTextDisplayed = postPage.isTextDisplayed();
        Assert.assertEquals(isTextDisplayed, "Post a picture to share with your awesome followers");

        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }
    @Test
    public void testLogoNotFoundPage() {
        WebDriver driver = getDriver();
        NotFoundPage notFoundPage = new NotFoundPage(driver);
        notFoundPage.navigateTo();
        Assert.assertTrue(notFoundPage.isUrlLoaded(), "The Wrong URL is not correct!");

        Header header = new Header(driver);
        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test
    public void testLogoRegisterPage() {
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

        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }

    @Test(dataProvider = "getUsers")
    public void testLogoEditRegisterUser(String user, String password, String name) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        Header header = new Header(driver);
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");

        profilePage.userEditButton();
        Assert.assertTrue(profilePage.editTextWindow(), "The modal profile page is not displayed!");
        Assert.assertTrue(header.isSkilloLogoDisplayed(),"The logo is not displayed");
    }
}
