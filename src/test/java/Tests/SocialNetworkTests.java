package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SocialNetworkTests extends BaseTest {
    String facebook = "https://www.facebook.com/saucelabs";
    String twit = "https://x.com/saucelabs";
    String linke = "https://www.linkedin.com/company/sauce-labs/";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void displayedNetworkIcons() {
        testUserLogIn();
        Assert.assertTrue(socialNetworkPage.iconForFacebookisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForTwitterisDisplayed());
        Assert.assertTrue(socialNetworkPage.iconForLinkedinIsDisplayed());
    }

    @Test
    public void userCanGoToFacebook() {
        testUserLogIn();
        socialNetworkPage.clickonFacebookIcon();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(facebook));

    }

    @Test
    public void userCanGoToTwitter() {
        testUserLogIn();
        socialNetworkPage.clickOnTwiter();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(twit));
    }

    @Test
    public void userCanGoToLinkedin() {
        testUserLogIn();
        socialNetworkPage.clickOnLinkedin();
        Assert.assertTrue(socialNetworkPage.isUrlOfNetwork(linke));
    }
}
