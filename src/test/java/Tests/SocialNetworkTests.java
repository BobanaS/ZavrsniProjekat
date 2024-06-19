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

public class SocialNetworkTests extends BaseTest {
    String facebook = "https://www.facebook.com/saucelabs";
    String twit = "https://x.com/saucelabs";
    String linke = "https://www.linkedin.com/company/sauce-labs/";

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


    @Test
    public void displayedNetworkIcons() {
        Assert.assertTrue(socialNetworkPage.iconForFacebookisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForTwitterisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForLinkedinIsDisplayed());
    }

    @Test
    public void userCanGoToFacebook() {
        socialNetworkPage.clickonFacebookIcon();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(facebook));

    }

    @Test
    public void userCanGoToTwitter() {
        socialNetworkPage.clickOnTwiter();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(twit));
    }

    @Test
    public void userCanGoToLinkedin() {
        socialNetworkPage.clickOnLinkedin();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(linke));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
