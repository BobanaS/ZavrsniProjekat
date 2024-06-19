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

public class CheckOutTest extends BaseTest {
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

    @Test(priority = 10)
    public void userIsOnCheckOutStepTwoPage() {
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.continueButtonIsDisplayed());
        Assert.assertTrue(checkoutPage.cancelButtonIsDisplayed());
    }

    @Test(priority = 20)
    public void userClickCancelButton() {
        checkoutPage.clickCancel();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
        Assert.assertTrue(cartPage.isThereTitleYourCart());
    }

    @Test(priority = 30)
    public void userClickContinueWithEmptyDataFields() {
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorMessageIsDisplayed());
    }

    @Test(priority = 40)
    public void userClickContinueWithInputFirstNameOnly() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorPasswordMessageIsDisplayed());
    }

    @Test(priority = 50)
    public void userClickContinueWithoutPostCodeInput() {
        checkoutPage.inputFirstName("Bobana");
        checkoutPage.inputLastName("Simikic");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutPageURL);
        Assert.assertTrue(checkoutPage.errorFormaIsDisplayed());
        Assert.assertTrue(checkoutPage.errorPostCodeMessageIsDisplayed());
    }

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
    @AfterMethod
    public void closetab(){
        driver.close();
    }
}
