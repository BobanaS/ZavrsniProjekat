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

public class ChekOutCompleteTest extends BaseTest {
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
        userInputforCheckOut();
        checkOutStepTwoPage.clickOnFinishButton();
    }

    @Test
    public void userIsOnCheckOutCompletePage(){
        Assert.assertEquals(driver.getCurrentUrl(), checkOutCompletePageURL);
        Assert.assertTrue(checkOutCompletePage.isThereCheckOutMessage());
        Assert.assertTrue(checkOutCompletePage.isBackToProductButtonDisplayed());

    }
    @Test
    public void userClickOnBackToProducts(){
        checkOutCompletePage.clickOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
    }
    @Test
    public void checkOutMessagesAreThere(){
      Assert.assertTrue(checkOutCompletePage.isCheckOutMessage());
      Assert.assertTrue(checkOutCompletePage.isCheckOutTittle());
    }
    @AfterMethod
    public void closetab(){
        driver.close();
    }
}