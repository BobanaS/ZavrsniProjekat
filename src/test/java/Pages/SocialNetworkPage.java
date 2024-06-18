package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;


public class SocialNetworkPage extends BaseTest {

    public SocialNetworkPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "social_twitter")
    public WebElement twitter;
    @FindBy(className = "social_facebook")
    public WebElement facebook;
    @FindBy(className = "social_linkedin")
    public WebElement linkedin;

    //----------------------------------------------
    public boolean iconForFacebookisDisplayed() {
        scrollToElement(facebook);
        return facebook.isDisplayed();
    }

    public boolean iconForTwitterisDisplayed() {
        scrollToElement(twitter);
        return twitter.isDisplayed();
    }

    public boolean iconForLinkedinIsDisplayed() {
        scrollToElement(linkedin);
        return linkedin.isDisplayed();
    }

    public void clickonFacebookIcon() {

        scrollToElement(facebook);
        facebook.click();
    }

    public void clickOnTwiter() {
        scrollToElement(twitter);
        twitter.click();

    }

    public void clickOnLinkedin() {
        scrollToElement(linkedin);
        linkedin.click();
    }


    public void newWindow() {
        String pocetnaStranica = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(pocetnaStranica)) {
                driver.switchTo().window(window);

            }
        }
    }

    public boolean isUrlOfNetwork(String network) {

        newWindow();
        return driver.getCurrentUrl().equals(network);
    }
}