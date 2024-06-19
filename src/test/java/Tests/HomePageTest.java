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

public class HomePageTest extends BaseTest {
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
    @Test(priority = 10)
    public void userOpenSortOption(){
        homePage.clickOnSortOptionMenu();
        Assert.assertTrue(homePage.optionIsDisplayed());
    }
    @Test (priority = 20)
    public void userClickSortByNameAZ(){
        homePage.userSortProductByNameAZ();
        Assert.assertTrue(homePage.isProductSortedByNameAZ());
    }
    @Test (priority=30)
    public void userClickSortByNameZA(){
        homePage.userSortProductByNameZtoA();
        Assert.assertTrue(homePage.isProductSortedByNameZA());
    }
    @Test (priority=40)
    public void userClickSortByPriceLH(){
        homePage.userSortProductByPriceLowToHigh();
    Assert.assertTrue(homePage.isSortedByPriceLowToHigh());
    }
    @Test (priority = 50)
    public void userClickSortByNameHL(){
        homePage.userSortProductByPriceHighToLow();
    Assert.assertTrue(homePage.isSortedByPriceHighToLow());
    }
    @Test(priority =60)
    public void userGoToSauceLabsOnesie(){
        homePage.goTOproductPage("Sauce Labs Onesie");
        Assert.assertEquals(driver.getCurrentUrl(), sauceLabsOnecieURL);
        Assert.assertTrue(productPage.productName.getText().equals("Sauce Labs Onesie"));
    }
    @Test(priority=70)
    public void userAddProductToCart(){
        homePage.addProductToCart("Sauce Labs Onesie");
        Assert.assertTrue(cartPage.elementDisplayed(cartPage.cartnumber));
        cartPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.productName.getText().equals("Sauce Labs Onesie"));
    }
    @Test(priority=70)
    public void userRemoveProductToCart(){
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.removeProductToCart("Sauce Labs Onesie");
        Assert.assertTrue(elementDisplayed(homePage.addToCart));
    }
    @AfterMethod
    public void closetab(){
        driver.close();
    }

}