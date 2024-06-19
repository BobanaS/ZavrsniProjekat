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

public class LogInPageTests extends BaseTest {
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
        productPage=new ProductPage();
    }

    @Test(priority = 10)
    public void userIsOnLogInPage() {
        Assert.assertTrue(logInPage.logoIsdispleyd());
        Assert.assertTrue(logInPage.boxIsDisplayed());
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 20)
    public void userClickOnLoginButtonWithOutCredentials() {
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));

    }

    @Test(priority = 30)
    public void userClickOnLogInButtonWithoutPassword() {
        logInPage.inputUserName("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
        Assert.assertTrue(logInPage.noPasswordErrorMessage());
    }

    @Test(priority = 40)
    public void userTryLogInWithWrongCredentials() {
        logInPage.inputUserName("Bobana");
        logInPage.inputPassword("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
    }

    @Test(priority = 50)
    public void standardUserTryLogInWithWrongCredentials() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("Bobana");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.logInButton));
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.errorButton));
    }

    @Test(priority = 60)
    public void standardUserTryLogIn() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    @Test(priority = 70)
    public void lockedOutUserTryLogIn() {
        logInPage.inputUserName("locked_out_user");
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
    @Test(priority = 90)
    public void PerformanceUserTryLogIn() {
        logInPage.inputUserName("performance_glitch_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    @Test(priority = 100)
    public void errorUserTryLogIn() {
        logInPage.inputUserName("error_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }
    @Test(priority = 110)
    public void visualUserTryLogIn() {
        logInPage.inputUserName("visual_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
        Assert.assertTrue(cartPage.cartIconIsDisplayed());
    }


    @AfterMethod
    public void theEndOfTest(){
        driver.manage().deleteAllCookies();
        driver.close();
        }
}