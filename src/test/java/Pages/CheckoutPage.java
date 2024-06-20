package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
  The CheckoutPage class extends BaseTest and represents the checkout  page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class CheckoutPage extends BaseTest {
    //Constructor of the page
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements and their locators
    @FindBy(id = "cancel")
    public WebElement cancelButton;
    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(id = "first-name")
    public WebElement firstNameField;
    @FindBy(id = "last-name")
    public WebElement lastNameField;
    @FindBy(id = "postal-code")
    public WebElement postalCodeField;
    @FindBy(className = "input_error")
    public WebElement errorForma;
    @FindBy(className = "error-message-container")
    public WebElement errorMessage;

    //------------------------------------
     /*
      Method to click the cancelButton.
     This method initiates cancel process by clicking the checkout button on the cart page.
     */
    public void clickCancel() {
        cancelButton.click();
    }

    /*
     Method to click the continueButton.
    This method initiates continue process by clicking the checkout button on the cart page.
    */
    public void clickContinue() {
        continueButton.click();
    }
    /*
      Inputs the given first name into the first name field.
      This method clears any existing text in the field and then types the provided first name.
     */

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    /*
         Inputs the given last name into the last name field.
         This method clears any existing text in the field and then types the provided last name.
        */
    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    /*
       Inputs the given  post code into the post code field.
       This method clears any existing text in the field and then types the provided post code.
        */
    public void inputPostCode(String postCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postCode);
    }
     /*
      Checks if the specified cancelButton is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean cancelButtonIsDisplayed() {
        return elementDisplayed(cancelButton);
    }

    /*
      Checks if the specified continueButton is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean continueButtonIsDisplayed() {
        return elementDisplayed(continueButton);
    }

    /*
      Checks if the specified firstNameField is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
    */
    public boolean firstNameFieldIsDiplayed() {
        return elementDisplayed(firstNameField);
    }
    /*
      Checks if the specified errorForma is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean errorFormaIsDisplayed() {
        return elementDisplayed(errorForma);
    }
    /*
      Checks if the specified errorMessage equals "Error: First Name is required".
      This method returns true if the element equals, and false otherwise.
     */

    public boolean errorMessageIsDisplayed() {
        return errorMessage.getText().equals("Error: First Name is required");
    }
     /*
      Checks if the specified errorPasswordMessage equals "Error: Last Name is required".
      This method returns true if the element equals, and false otherwise.
     */

    public boolean errorPasswordMessageIsDisplayed() {
        return errorMessage.getText().equals("Error: Last Name is required");
    }
     /*
      Checks if the specified errorPostCodeMessage equals "Error: Postal Code is required".
      This method returns true if the element equals, and false otherwise.
     */

    public boolean errorPostCodeMessageIsDisplayed() {
        return errorMessage.getText().equals("Error: Postal Code is required");
    }
}
