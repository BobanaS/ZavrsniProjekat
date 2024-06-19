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

public class CheckOutStepTwoTest extends BaseTest {
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

    @Test (priority = 10)
    public void userIsOnCheckOutStepTwoPage(){
        Assert.assertEquals(driver.getCurrentUrl(), checkOutStepTwoPageURL);
        Assert.assertTrue(checkOutStepTwoPage.cancelButtonIsDisplayed());
        Assert.assertTrue(checkOutStepTwoPage.finisButtonIsDisplayed());
    }
    @Test (priority = 20)
    public void userClickOnCancelButton(){
        checkOutStepTwoPage.clickonCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
    @Test (priority = 30)
    public void userClickOnFinishButton(){
        checkOutStepTwoPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutCompletePageURL);
        Assert.assertTrue(checkOutCompletePage.isThereCheckOutMessage());
        Assert.assertTrue(checkOutCompletePage.isBackToProductButtonDisplayed());
    }
    @Test(priority = 40)
    public void isThePriceGood(){
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, checkOutStepTwoPage.productprice.getText()));
    }
    @Test(priority = 50)
    public void isTheTotalSumaryGood(){
        Assert.assertTrue(checkOutStepTwoPage.isTheTrueTotalPriceWhenYouAddTax());
    }
    @AfterMethod
    public void closetab(){
        driver.close();
    }
}