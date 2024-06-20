package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
  The login class extends BaseTest and represents the login page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */

public class LogInPage extends BaseTest {
    //Constructor of the page
    public LogInPage() {
        PageFactory.initElements(driver, this);
    }
    // WebElements and their locators
    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement logInButton;

    @FindBy(className = "login_credentials_wrap-inner")
    public WebElement boxwithCredentials;
    @FindBy(className = "login_logo")
    public WebElement logo;
    @FindBy(className = "error-button")
    public WebElement errorButton;
    @FindBy (css = "#login_button_container > div > form > div.error-message-container.error")
    public WebElement errorMessage;

    //---------------------------------------------

    /*
       Enters the given username into the username field.
       userName the username to be entered
     */
    public void inputUserName(String userName) {
        usernameField.clear();
        usernameField.sendKeys(userName);
    }
    /*
       Enters the given password into the password field.
       param password the password to be entered
     */

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    /*
       Checks if the logo element is displayed on the page
       return true if the logo is displayed; false otherwise
    */

    public boolean logoIsdispleyd() {
        return elementDisplayed(logo);
    }
    /*
     Checks if the box with credentials is displayed on the page.
     return true if the box with credentials is displayed; false otherwise
     */

    public boolean boxIsDisplayed(){
        return  elementDisplayed(boxwithCredentials);
    }
    /*
      Clicks on the login button using JavaScript executor.
    */
    public void clickOnLogInButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logInButton);
    }
    /*
     Checks if the error message for missing password is displayed.
     return true if the error message is "Epic sadface: Password is required"; false otherwise
     */
    public boolean noPasswordErrorMessage(){
        return errorMessage.getText().equals("Epic sadface: Password is required");
    }

}