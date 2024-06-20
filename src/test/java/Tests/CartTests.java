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
 Test class for verifying functionality related to the shopping cart.
 Extends BaseTest for setup and after class operations.
 */
public class CartTests extends BaseTest {
    /*
      Setup method executed before each test method.
       Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
       initializes WebDriverWait, and initializes page objects.
       Logs in user, adds a product to cart, and navigates to cart page.
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
        testUserLogIn();
        homePage.addProductToCart(productForProductPageTest);
        cartPage.clickOnCartIcon();

    }
    /*
      Test case to verify that user is on the cart page.
      Asserts that the cart page title is displayed and verifies the current URL.
     */

    @Test(priority = 10)
    public void userIsOnCartPage() {
        Assert.assertTrue(cartPage.isThereTitleYourCart());
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
    }

    /*
      Test case to verify user can continue shopping from the cart page.
      Clicks on the 'Continue Shopping' button and asserts the navigation to the homepage.
     */
    @Test(priority = 20)
    public void userClickToContinueButton() {
        cartPage.clickOnContinueToShopButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
    /*
     Test case to verify user can proceed to checkout from the cart page.
     Clicks on the 'Checkout' button and asserts the navigation to the checkout page.
     */
    @Test(priority = 30)
    public void userClickToCheckOutButton() {
        cartPage.clickOnCheckOutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
    }
    /*
      Test case to verify that the added product is displayed in the cart.
      Asserts that the product name matches the expected product added earlier.
     */
    @Test(priority = 40)
    public void usersProductIsInTheCart() {

        Assert.assertTrue(cartPage.productName.getText().equals(productForProductPageTest));
    }
    /*
     Test case to verify that the product price in the cart matches the product price on the product page.
     Asserts that the product price displayed on the cart page is the same as expected.
     */
    @Test(priority = 50)
    public void productPriseIsTheSame() {
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, cartPage.productPrice.getText()));
    }
    /*
      After method executed after each test method.
      Closes the browser tab.
     */
    @AfterMethod
    public void closetab() {
        driver.close();
    }
}
