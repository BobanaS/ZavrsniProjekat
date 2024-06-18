package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutStepTwoTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        testUserLogIn();
        cartPage.clickOnCartIcon();
        cartPage.clickOnCheckOutButton();
        userInputforCheckOut();
    }

    @Test
    public void userIsOnCheckOutStepTwoPage(){
        Assert.assertEquals(driver.getCurrentUrl(), checkOutStepTwoPageURL);
        Assert.assertTrue(checkOutStepTwoPage.cancelButtonIsDisplayed());
        Assert.assertTrue(checkOutStepTwoPage.finisButtonIsDisplayed());
    }
    @Test
    public void userClickOnCancelButton(){
        checkOutStepTwoPage.clickonCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
    @Test
    public void userClickOnFinishButton(){
        checkOutStepTwoPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkOutCompletePageURL);
        Assert.assertTrue(checkOutCompletePage.isThereCheckOutMessage());
        Assert.assertTrue(checkOutCompletePage.isBackToProductButtonDisplayed());
    }
}