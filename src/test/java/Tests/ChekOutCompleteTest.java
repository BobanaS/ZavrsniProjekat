package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChekOutCompleteTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
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
}