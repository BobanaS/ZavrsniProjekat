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
  Test class for verifying functionalities related to the Sidebar.
 Extends BaseTest for setup and after class operations.
 */
public class SideBarTests extends BaseTest {

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
      Test case to verify that the sidebar button is displayed.
    */

    @Test(priority = 10)
    public void sideBarButtonDisplayed() {
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
    }
    /*
      Test case to verify that the user can open the sidebar menu.
      Asserts the presence and text of sidebar menu items.
    */
    @Test(priority = 20)
    public void userOpenTheSideManu() {
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        Assert.assertEquals(sidebarPage.sideBarManu.get(0).getText(), "All Items");
        Assert.assertEquals(sidebarPage.sideBarManu.get(1).getText(), "About");
        Assert.assertEquals(sidebarPage.sideBarManu.get(2).getText(), "Logout");
        Assert.assertEquals(sidebarPage.sideBarManu.get(3).getText(), "Reset App State");
    }
    /*
     Test case to verify that the user can close the sidebar.
     */
    @Test(priority = 30)
    public void userCanCloseTheSidebar() {
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.closeSideBar();
        waitForElementVisibility(sidebarPage.sideBarButton);
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());

    }
    /*
      Test case to verify that the "All Items" button in the sidebar works correctly.
      Asserts the current URL after clicking the "All Items" button.
     */
    @Test(priority = 40)
    public void userTestAllItemsButton(){
        waitForElementVisibility(sidebarPage.sideBarButton);
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("All Items");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    /*
      Test case to verify that the "About" button in the sidebar works correctly.
      Asserts the current URL after clicking the "About" button.
     */
    @Test(priority =50)
    public void userClickAbout(){
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("About");
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
    }
    /*
      Test case to verify that the user can log out via the sidebar.
      Asserts the current URL and presence of the login page elements after logging out.
     */
    @Test (priority = 60)
    public void userClickLogOut() {
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("Logout");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.usernameField));
    }
    /*
      Test case to verify that the user can reset the app state via the sidebar.
      Adds a product to the cart, resets the app state, and asserts that the product is removed from the cart.
     */
    @Test(priority = 70)
    public void userClickResetAppState(){
        homePage.addProductToCart(productForProductPageTest);
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("Reset App State");
        driver.navigate().refresh();
        waitForElementVisibility(homePage.addToCart);
        Assert.assertTrue((homePage.addToCart.isDisplayed()));

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

