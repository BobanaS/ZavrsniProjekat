package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
/*
  The SocialNetworkPage class extends BaseTest and represents the social network part of the page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */

public class SocialNetworkPage extends BaseTest {

    public SocialNetworkPage() {
        PageFactory.initElements(driver, this);
    }
    // WebElements and their locators

    @FindBy(className = "social_twitter")
    public WebElement twitter;
    @FindBy(className = "social_facebook")
    public WebElement facebook;
    @FindBy(className = "social_linkedin")
    public WebElement linkedin;


    //----------------------------------------------
    /*
    Checks if the Facebook icon is displayed and scrolls to it if necessary.
    return true if the Facebook icon is displayed; false otherwise
     */
    public boolean iconForFacebookisDisplayed() {
        scrollToElement(facebook);
        return facebook.isDisplayed();
    }
    /*
    Checks if the Twitter icon is displayed and scrolls to it if necessary.
    return true if the Twitter icon is displayed; false otherwise
     */
    public boolean iconForTwitterisDisplayed() {
        scrollToElement(twitter);
        return twitter.isDisplayed();
    }
    /*
    Checks if the Linkedin icon is displayed and scrolls to it if necessary.
    return true if the Linkedin icon is displayed; false otherwise
     */

    public boolean iconForLinkedinIsDisplayed() {
        scrollToElement(linkedin);
        return linkedin.isDisplayed();
    }
    /*
    Clicks on the Facebook icon after scrolling to it.
    This method ensures the Facebook icon is visible before clicking.
    */
    public void clickonFacebookIcon() {

        scrollToElement(facebook);
        facebook.click();
    }
     /*
    Clicks on the Twitter icon after scrolling to it.
    This method ensures the Twitter icon is visible before clicking.
    */

    public void clickOnTwiter() {
        scrollToElement(twitter);
        twitter.click();

    }
     /*
    Clicks on the Linkedin icon after scrolling to it.
    This method ensures the Linkedin icon is visible before clicking.
    */

    public void clickOnLinkedin() {
        scrollToElement(linkedin);
        linkedin.click();
    }

    /*
      Switches to a new browser window.
      This method identifies the new window handle and switches focus to it.
      Get the handle of the main (parent) window
      Get all window handles
      Switch to the new window

     */
    public void newWindow() {
        String pocetnaStranica = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(pocetnaStranica)) {
                driver.switchTo().window(window);

            }
        }
    }
    /*
     Checks if the current URL matches the expected URL of a social network.
     param network the expected URL of the social network
     return true if the current URL matches the expected network URL; false otherwise
     */
    public boolean isUrlOfNetwork(String network) {

        newWindow();
        return driver.getCurrentUrl().equals(network);
    }
}