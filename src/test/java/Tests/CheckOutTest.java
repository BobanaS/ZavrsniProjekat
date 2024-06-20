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
  Test class for verifying Checkout functionality.
  Extends BaseTest for setup and after class operations.
 */
public class CheckOutTest extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in user, navigates to cart page, and proceeds to checkout page.
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
    }
    /*
     Test case to verify that user is on Checkout page.
     Asserts the current URL and the presence of continue and cancel buttons.
     */
    @Test(priority = 10)
    public void userIsOnCheckOutStepTwoPage() {
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.continueButtonIsDisplayed());
        Assert.assertTrue(checkoutPage.cancelButtonIsDisplayed());
    }
    /*
      Test case to verify user can click on Cancel button.
      Clicks on the Cancel button and asserts navigation to the cart page.
      Verifies the presence of cart title on the redirected page.
     */
    @Test(priority = 20)
    public void userClickCancelButton() {
        checkoutPage.clickCancel();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
        Assert.assertTrue(cartPage.isThereTitleYourCart());
    }
    /*
      Test case to verify user cannot continue with empty data fields.
      Clicks on the Continue button and asserts validation error messages.
      Verifies the presence of error form and error message elements.
     */
    @Test(priority = 30)
    public void userClickContinueWithEmptyDataFields() {
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorMessageIsDisplayed());
    }

    /*
      Test case to verify user cannot continue with only inputting first name.
      Inputs first name, clicks on Continue button, and asserts validation error messages.
      Verifies the presence of error form and specific error message related to password.
     */
    @Test(priority = 40)
    public void userClickContinueWithInputFirstNameOnly() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorPasswordMessageIsDisplayed());
    }
    /*
      Test case to verify user cannot continue without inputting postcode.
      Inputs first name, last name, clicks on Continue button, and asserts validation error messages.
      Verifies the presence of error form and specific error message related to postcode.
     */

    @Test(priority = 50)
    public void userClickContinueWithoutPostCodeInput() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.inputLastName("Simikic");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorPostCodeMessageIsDisplayed());
    }
    /*
      Test case to verify user can successfully continue with valid inputs.
      Inputs first name, last name, postcode, clicks on Continue button,
      and asserts navigation to Checkout Step Two page.
     Verifies the presence of cancel and finish buttons on the next page.
     */
    @Test(priority = 60)
    public void userClickContinueWithValidInputs() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.inputLastName("Simikic");
        checkoutPage.inputPostCode("22000");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutStepTwoPageURL);
        Assert.assertTrue(checkOutStepTwoPage.cancelButtonIsDisplayed());
        Assert.assertTrue(checkOutStepTwoPage.finisButtonIsDisplayed());
    }
    /*
     * After method executed after each test method.
     * Closes the browser tab.
     */
    @AfterMethod
    public void closetab(){
        driver.close();
    }
}
