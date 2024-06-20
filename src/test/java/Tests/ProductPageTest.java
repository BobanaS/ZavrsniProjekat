package Tests;

import Base.BaseTest;
import Pages.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
/*
  Test class for verifying functionalities on the Product Page.
  Extends BaseTest for setup and after class operations.
 */
public class ProductPageTest extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in a test user and navigates to a specific product page.
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
        homePage.goTOproductPage(productForProductPageTest);
    }

    /*
      Test case to verify that the user is on the correct product page.
      Asserts the current URL and product name.
     */
    @Test(priority = 10)
    public void userIsOnTheProductPage() {
        Assert.assertEquals(driver.getCurrentUrl(), productForProductPageTestURL);
        Assert.assertTrue(productPage.productName.getText().equals(productForProductPageTest));
    }
    /*
      Test case to verify that the user can navigate back to the product listing page.
      Clicks the back button and asserts the current URL.
     */
    @Test(priority = 20)
    public void userClickOnBactToProduct() {
        productPage.clickBactoProducts();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }

    /*
      Test case to verify that the user can navigate to the shopping cart from the product page.
      Clicks the shopping cart icon and asserts the current URL.
     */
    @Test(priority = 30)
    public void userCanGoToTheShopCartFromProductPage() {
        productPage.clickOnShopingCart();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
    }

    /*
      Test case to verify that the user can add a product to the cart.
      Clicks the add to cart button, verifies the remove button is displayed,
      and checks that the product is listed in the cart.
     */
    @Test(priority = 40)
    public void userClickAddToCart() {
        productPage.clickAddToCartonPage();
        Assert.assertTrue(productPage.removeButtonIsDisplayed());
        Assert.assertTrue(cartPage.elementDisplayed(cartPage.cartnumber));
        productPage.clickOnShopingCart();
        Assert.assertTrue(cartPage.productName.getText().equals(productForProductPageTest));
    }
    /*
      Test case to verify that the user can remove a product from the cart.
      Clicks the remove button and asserts that the add to cart button is displayed.
    */
    @Test(priority = 50)
    public void userRemoveProductFromCart() {
        productPage.clickAddToCartonPage();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(productPage.elementDisplayed(productPage.addtoCartButton));
    }
    /*
      Test case to verify that the product price is consistent between the home page and product page.
      Asserts that the product price on the home page matches the product price on the product page.
     */
    @Test(priority = 60)
    public void productHasTheSamePriceOnHomeAndProductPage() {
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, productPage.productPrice.getText()));
    }
    /*
      After method executed after each test method.
      Closes the browser tab.
    */
    @AfterMethod()
    public void closeTab(){
        driver.close();
    }

}
