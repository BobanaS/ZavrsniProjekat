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
 Test class for verifying functionality related to Checkout Step Two.
 Extends BaseTest for setup and after class operations.
 */

public class CheckOutStepTwoTest extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in user, adds a product to cart, navigates to checkout page, and inputs user information.
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
        homePage.addProductToCart(productForProductPageTest);
        cartPage.clickOnCartIcon();
        cartPage.clickOnCheckOutButton();
        userInputforCheckOut();
    }
    /*
     Test case to verify that user is on Checkout Step Two page.
     Asserts the current URL and the presence of cancel and finish buttons.
     */

    @Test (priority = 10)
    public void userIsOnCheckOutStepTwoPage(){
        Assert.assertEquals(driver.getCurrentUrl(), checkOutStepTwoPageURL);
        Assert.assertTrue(checkOutStepTwoPage.cancelButtonIsDisplayed());
        Assert.assertTrue(checkOutStepTwoPage.finisButtonIsDisplayed());
    }
    /*
      Test case to verify user can click on Cancel button.
      Clicks on the Cancel button and asserts navigation to the homepage.
     */
    @Test (priority = 20)
    public void userClickOnCancelButton(){
        checkOutStepTwoPage.clickonCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
    /*
      Test case to verify user can click on Finish button.
      Clicks on the Finish button and asserts navigation to the checkout complete page,
      and verifies the presence of checkout message and 'Back to Products' button.
     */
    @Test (priority = 30)
    public void userClickOnFinishButton(){
        checkOutStepTwoPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutCompletePageURL);
        Assert.assertTrue(checkOutCompletePage.isThereCheckOutMessage());
        Assert.assertTrue(checkOutCompletePage.isBackToProductButtonDisplayed());
    }
    /*
      Test case to verify that the product price on Checkout Step Two page matches the expected product price.
      Asserts that the product price displayed on the checkout page is the same as expected.
     */
    @Test(priority = 40)
    public void isThePriceGood(){
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, checkOutStepTwoPage.productprice.getText()));
    }
    /*
      Test case to verify the total summary price calculation on Checkout Step Two page.
      Asserts that the calculated total price (including tax) matches the displayed total price.
     */
    @Test(priority = 50)
    public void isTheTotalSumaryGood(){
        Assert.assertTrue(checkOutStepTwoPage.isTheTrueTotalPriceWhenYouAddTax());
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