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
 Test class for verifying functionalities related to social network icons on the page.
 Extends BaseTest for setup and after class operations.
 */
public class SocialNetworkTests extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in a test user.
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
    }

    /*
      Test case to verify that all social network icons are displayed on the page.
     */
    @Test (priority = 10)
    public void displayedNetworkIcons() {
        Assert.assertTrue(socialNetworkPage.iconForFacebookisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForTwitterisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForLinkedinIsDisplayed());
    }
    /*
      Test case to verify that the user can navigate to Facebook via the icon.
      Asserts the URL after clicking the Facebook icon.
     */
    @Test(priority = 20)
    public void userCanGoToFacebook() {
        socialNetworkPage.clickonFacebookIcon();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(facebook));

    }
    /*
     Test case to verify that the user can navigate to Twitter via the icon.
     Asserts the URL after clicking the Twitter icon.
     */

    @Test (priority = 30)
    public void userCanGoToTwitter() {
        socialNetworkPage.clickOnTwiter();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(twit));
    }
    /*
      Test case to verify that the user can navigate to LinkedIn via the icon.
      Asserts the URL after clicking the LinkedIn icon.
    */

    @Test (priority = 40)
    public void userCanGoToLinkedin() {
        socialNetworkPage.clickOnLinkedin();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(linke));
    }
    /*
     * After method executed after each test method.
     * Closes the browser tab.
     */
    @AfterMethod
    public void close(){

        driver.close();
    }
}
