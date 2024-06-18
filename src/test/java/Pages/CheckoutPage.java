package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cancel")
    public WebElement cancelButton;
    @FindBy(id="continue")
    public WebElement continueButton;
    @FindBy(id="first-name")
    public WebElement firstNameField;
    @FindBy(id="last-name")
    public WebElement lastNameField;
    @FindBy(id="postal-code")
    public WebElement postalCodeField;
    @FindBy(className = "input_error")
    public WebElement errorForma;
    @FindBy(className = "error-message-container")
    public WebElement errorMessage;
    //------------------------------------
    public void clickCancel(){
        cancelButton.click();
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void inputPostCode(String postCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postCode);
    }
    public boolean cancelButtonIsDisplayed(){
        return elementDisplayed(cancelButton);
    }
    public boolean continueButtonIsDisplayed(){
        return elementDisplayed(continueButton);
    }
    public boolean firstNameFieldIsDiplayed(){
        return elementDisplayed(firstNameField);
    }
    public boolean errorFormaIsDisplayed(){
        return elementDisplayed(errorForma);
    }
    public boolean errorMessageIsDisplayed(){
    return errorMessage.getText().equals("Error: First Name is required");
    }
    public boolean errorPasswordMessageIsDisplayed(){
        return errorMessage.getText().equals("Error: Last Name is required");
    }
    public boolean errorPostCodeMessageIsDisplayed(){
        return errorMessage.getText().equals("Error: Postal Code is required");
    }
}
