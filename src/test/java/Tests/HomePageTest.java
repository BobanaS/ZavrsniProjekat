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
  Test class for verifying various functionalities on the Home Page.
 Extends BaseTest for setup and after class operations.
 */
public class HomePageTest extends BaseTest {
    /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in the user to prepare for tests.
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
      Test case to verify that the sort option menu can be opened.
      Clicks on the sort option menu and asserts its visibility.
     */
    @Test(priority = 10)
    public void userOpenSortOption(){
        homePage.clickOnSortOptionMenu();
        Assert.assertTrue(homePage.optionIsDisplayed());
    }
    /*
      Test case to verify sorting products by name from A to Z.
      Sorts products by name A-Z and asserts the sorting order.
     */
    @Test (priority = 20)
    public void userClickSortByNameAZ(){
        homePage.userSortProductByNameAZ();
        Assert.assertTrue(homePage.isProductSortedByNameAZ());
    }
    /*
      Test case to verify sorting products by name from Z to A.
      Sorts products by name Z-A and asserts the sorting order.
     */
    @Test (priority=30)
    public void userClickSortByNameZA(){
        homePage.userSortProductByNameZtoA();
        Assert.assertTrue(homePage.isProductSortedByNameZA());
    }
    /*
      Test case to verify sorting products by price from low to high.
      Sorts products by price low to high and asserts the sorting order.
     */
    @Test (priority=40)
    public void userClickSortByPriceLH(){
        homePage.userSortProductByPriceLowToHigh();
    Assert.assertTrue(homePage.isSortedByPriceLowToHigh());
    }
    /*
      Test case to verify sorting products by price from high to low.
      Sorts products by price high to low and asserts the sorting order.
     */
    @Test (priority = 50)
    public void userClickSortByNameHL(){
        homePage.userSortProductByPriceHighToLow();
    Assert.assertTrue(homePage.isSortedByPriceHighToLow());
    }
    /*
      Test case to verify navigation to the Sauce Labs Onesie product page.
      Clicks on the Sauce Labs Onesie product and asserts the correct URL and product name.
     */
    @Test(priority =60)
    public void userGoToSauceLabsOnesie(){
        homePage.goTOproductPage("Sauce Labs Onesie");
        Assert.assertEquals(driver.getCurrentUrl(), sauceLabsOnecieURL);
        Assert.assertTrue(productPage.productName.getText().equals("Sauce Labs Onesie"));
    }
    /*
      Test case to verify adding a product to the cart.
      Adds the Sauce Labs Onesie product to the cart and asserts its presence in the cart.
     */
    @Test(priority=70)
    public void userAddProductToCart(){
        homePage.addProductToCart("Sauce Labs Onesie");
        Assert.assertTrue(cartPage.elementDisplayed(cartPage.cartnumber));
        cartPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.productName.getText().equals("Sauce Labs Onesie"));
    }
    /*
      Test case to verify removing a product from the cart.
      Adds and then removes the Sauce Labs Onesie product from the cart and asserts the add to cart button is displayed.
    */
    @Test(priority=80)
    public void userRemoveProductToCart() {
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.removeProductToCart("Sauce Labs Onesie");
        Assert.assertTrue(elementDisplayed(homePage.addToCart));
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