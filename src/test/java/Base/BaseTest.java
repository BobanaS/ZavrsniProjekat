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

public class BaseTest {
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
    public String checkOutPageURL="https://www.saucedemo.com/checkout-step-one.html";
    public String cartPageURL="https://www.saucedemo.com/cart.html";
    public String homePageUrl="https://www.saucedemo.com/inventory.html";
    public String checkOutStepTwoPageURL="https://www.saucedemo.com/checkout-step-two.html";
    public String checkOutCompletePageURL ="https://www.saucedemo.com/checkout-complete.html";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        logInPage = new LogInPage();
        socialNetworkPage = new SocialNetworkPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkOutStepTwoPage = new CheckOutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("", element);
    }

    public void waitForElementVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void testUserLogIn() {
        logInPage.inputUserName("standard_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
    }

    public void userInputforCheckOut(){
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.inputLastName("Simikic");
        checkoutPage.inputPostCode("22000");
        checkoutPage.clickContinue();
    }
    public boolean elementDisplayed(WebElement element) {
     return   element.isDisplayed();
    }
    @AfterClass
    public void theEndOfAllTest(){
        driver.quit();
    }
}