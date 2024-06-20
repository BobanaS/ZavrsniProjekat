package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

/*
 * BaseTest class contains setup and theEndOfAllTests methods annotated with @BeforeClass and @AfterClass.
 * It includes instances of all classes and utility strings and methods required for the tests.
 */
public class BaseTest {
    //instances of all classes
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public LogInPage logInPage;
    public SocialNetworkPage socialNetworkPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckOutCompletePage checkOutCompletePage;
    public ProductPage productPage;

    //Utility strings
    public String checkOutPageURL = "https://www.saucedemo.com/checkout-step-one.html";
    public String cartPageURL = "https://www.saucedemo.com/cart.html";
    public String homePageUrl = "https://www.saucedemo.com/inventory.html";
    public String checkOutStepTwoPageURL = "https://www.saucedemo.com/checkout-step-two.html";
    public String checkOutCompletePageURL = "https://www.saucedemo.com/checkout-complete.html";
    public String sauceLabsOnecieURL = "https://www.saucedemo.com/inventory-item.html?id=2";
    public String productForProductPageTest = "Sauce Labs Backpack";
    public String productForProductPageTestURL = "https://www.saucedemo.com/inventory-item.html?id=4";
    public String facebook = "https://www.facebook.com/saucelabs";
    public String twit = "https://x.com/saucelabs";
    public String linke = "https://www.linkedin.com/company/sauce-labs/";
    /*
      This method is executed once before any test methods in this class.
      It sets up the necessary environment and initializes required resources.
     */

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    /*
    Scrolls to the specified web element on the page.
    This method ensures that the element is brought into view so it can be interacted with.
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("", element);
    }
    /*
      Waits for the specified web element to become visible on the page.
      This method will repeatedly check the visibility status of the element
      until it is visible or a timeout occurs.
      */
    public void waitForElementVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }
    /*
      Automates the login process for a test user.
      This method inputs the username and password, and then clicks the login button.
      It is used to quickly log in a standard test user for automated tests.
     */
    public void testUserLogIn() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
    }
    /*
      Automates the checkOut process for a test user.
      This method inputs the firstname, lastname, postcode, and then clicks the continue button.
      It is used to quickly log in a standard test user for automated tests.
     */
    public void userInputforCheckOut() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.inputLastName("Simikic");
        checkoutPage.inputPostCode("22000");
        checkoutPage.clickContinue();
    }

    /*
      Checks if the specified web element is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean elementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /*
    This method is executed once after all test methods in this class have been run.
    It closes driver
     */
    @AfterClass
    public void theEndOfAllTest() {
        driver.quit();
    }

}