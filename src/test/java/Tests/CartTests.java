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

public class CartTests extends BaseTest {
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

    }

    @Test(priority = 10)
    public void userIsOnCartPage(){
     Assert.assertTrue(cartPage.isThereTitleYourCart());
     Assert.assertEquals(driver.getCurrentUrl(),cartPageURL);
    }
    @Test(priority = 20)
    public void userClickToContinueButton(){
        cartPage.clickOnContinueToShopButton();
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
    }
    @Test (priority =30)
    public void userClickToCheckOutButton(){
        cartPage.clickOnCheckOutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
    }
    @Test(priority =40)
    public void usersProductIsInTheCart(){

        Assert.assertTrue(cartPage.productName.getText().equals(productForProductPageTest));
    }
    @Test(priority = 50)
    public void productPriseIsTheSame(){
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, cartPage.productPrice.getText()));
    }

    @AfterMethod
    public void closetab(){
        driver.close();
    }
}
