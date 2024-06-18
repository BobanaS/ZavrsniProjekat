package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        testUserLogIn();
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
}
