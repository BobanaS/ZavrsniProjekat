package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
  Test class for verifying various login functionalities on the Login Page.
  Extends BaseTest for setup and after class operations.
 */
public class LogInPageTests extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
     */
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        logInPage = new LogInPage();
        socialNetworkPage = new SocialNetworkPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkOutStepTwoPage = new CheckOutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();
        productPage = new ProductPage();
    }

    /*
      Test case to verify that the user is on the login page.
      Asserts the visibility of the logo, login box, and login button, and verifies the current URL.
     */

    @Test(priority = 10)
    public void userIsOnLogInPage() {
        Assert.assertTrue(logInPage.logoIsdispleyd());
        Assert.assertTrue(logInPage.boxIsDisplayed());
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    /*
      Test case to verify login attempt without credentials.
      Clicks on the login button without entering credentials and asserts the current URL and error message.
     */
    @Test(priority = 20)
    public void userClickOnLoginButtonWithOutCredentials() {
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));

    }
    /*
      Test case to verify login attempt with only username and no password.
      Enters username, clicks on the login button, and asserts the current URL and error message.
     */

    @Test(priority = 30)
    public void userClickOnLogInButtonWithoutPassword() {
        logInPage.inputUserName("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
        Assert.assertTrue(logInPage.noPasswordErrorMessage());
    }
    /*
      Test case to verify login attempt with wrong credentials.
      Enters wrong username and password, clicks on the login button, and asserts the current URL and error message.
     */
    @Test(priority = 40)
    public void userTryLogInWithWrongCredentials() {
        logInPage.inputUserName("Bobana");
        logInPage.inputPassword("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
    }
    /*
      Test case to verify login attempt with a valid username and wrong password.
      Enters valid username and wrong password, clicks on the login button, and asserts the current URL
      and error message.
     */
    @Test(priority = 50)
    public void standardUserTryLogInWithWrongCredentials() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
    }
    /*
      Test case to verify login attempt with valid credentials for standard user.
      Enters valid username and password, clicks on the login button,
      and asserts the current URL and visibility of side bar and cart icon.
     */
    @Test(priority = 60)
    public void standardUserTryLogIn() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }


    @Test(priority = 80)
    public void problemUserTryLogIn() {
        logInPage.inputUserName("problem_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    /*
      Test case to verify login attempt with valid credentials for performance glitch user.
      Enters valid username and password, clicks on the login button,
      and asserts the current URL and visibility of side bar and cart icon.
     */
    @Test(priority = 90)
    public void PerformanceUserTryLogIn() {
        logInPage.inputUserName("performance_glitch_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    /*
      Test case to verify login attempt with valid credentials for error user.
      Enters valid username and password, clicks on the login button,
      and asserts the current URL and visibility of side bar and cart icon.
     */
    @Test(priority = 100)
    public void errorUserTryLogIn() {
        logInPage.inputUserName("error_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    /*
      Test case to verify login attempt with valid credentials for visual user.
      Enters valid username and password, clicks on the login button,
      and asserts the current URL and visibility of side bar and cart icon.
     */
    @Test(priority = 110)
    public void visualUserTryLogIn() {
        logInPage.inputUserName("visual_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }

    /*
      After method executed after each test method.
      Deletes all cookies and closes the browser tab.
     */
    @AfterMethod
    public void theEndOfTest() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}