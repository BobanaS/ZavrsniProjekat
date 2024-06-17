package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogInPage extends BaseTest {

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

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
    public void inputUserName(String userName) {
        usernameField.clear();
        usernameField.sendKeys(userName);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public boolean logoIsdispleyd() {
        return elementDisplayed(logo);
    }
    public boolean boxIsDisplayed(){
        return  elementDisplayed(boxwithCredentials);
    }

    public void clickOnLogInButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logInButton);
    }
    public boolean noPasswordErrorMessage(){
        return errorMessage.getText().equals("Epic sadface: Password is required");
    }

}