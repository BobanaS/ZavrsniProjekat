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
 Test class for verifying Checkout Complete functionality.
 Extends BaseTest for setup and after class operations.
 */
public class ChekOutCompleteTest extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in user, navigates through the checkout process to reach the Checkout Complete page.
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
        productPage=new ProductPage();
        testUserLogIn();
        cartPage.clickOnCartIcon();
        cartPage.clickOnCheckOutButton();
        userInputforCheckOut();
        checkOutStepTwoPage.clickOnFinishButton();
    }

    /*
      Test case to verify that user is on Checkout Complete page.
      Asserts the current URL and the presence of checkout message and back to product button.
     */
    @Test(priority = 10)
    public void userIsOnCheckOutCompletePage(){
        Assert.assertEquals(driver.getCurrentUrl(), checkOutCompletePageURL);
        Assert.assertTrue(checkOutCompletePage.isThereCheckOutMessage());
        Assert.assertTrue(checkOutCompletePage.isBackToProductButtonDisplayed());

    }
    /*
     Test case to verify user can click on Back to Products button.
     Clicks on the Back to Products button and asserts navigation to the homepage.
     */
    @Test (priority = 20)
    public void userClickOnBackToProducts(){
        checkOutCompletePage.clickOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
    }
    /*
      Test case to verify the presence of checkout messages.
      Asserts the presence of both checkout message and checkout title on the Checkout Complete page.
     */
    @Test (priority = 30)
    public void checkOutMessagesAreThere(){
      Assert.assertTrue(checkOutCompletePage.isCheckOutMessage());
      Assert.assertTrue(checkOutCompletePage.isCheckOutTittle());
    }
    /*
      After method executed after each test method.
      Closes the browser tab.
     */
    @AfterMethod
    public void closetab(){
        driver.close();
    }
}