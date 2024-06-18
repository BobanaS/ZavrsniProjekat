package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
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
}
