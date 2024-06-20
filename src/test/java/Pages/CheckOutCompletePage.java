package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
  The CheckOutCompletePage class extends BaseTest and represents the check out complete page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class CheckOutCompletePage extends BaseTest {
    //Constructor of the page
    public CheckOutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements and their locators
    @FindBy(id = "back-to-products")
    public WebElement backToProductButton;

    @FindBy(className = "title")
    public WebElement checkOutTitle;

    @FindBy(className = "complete-header")
    public WebElement checkOutMessage;


    //------------------------------
    /*
      Checks if the BackToProductButton is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean isBackToProductButtonDisplayed() {
        return elementDisplayed(backToProductButton);
    }
    /*
      Checks if the CheckOutMessage is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean isThereCheckOutMessage() {
        return elementDisplayed(checkOutMessage);
    }
    /*
      Checks if the CheckOutMessage is the "Thank you for your order!".
      This method returns true if it equals, and false otherwise.
     */

    public boolean isCheckOutMessage() {
        return checkOutMessage.getText().equals("Thank you for your order!");
    }
     /*
      Checks if the CheckOutTittle is the "Checkout: Complete!").
      This method returns true if it equals, and false otherwise.
     */

    public boolean isCheckOutTittle() {
        return checkOutTitle.getText().equals("Checkout: Complete!");
    }
     /*
      Method to click the BackToProductbutton.
     This method initiates back to product process by clicking the continue button on the cart page.
     */

    public void clickOnBackToProductsButton() {
        backToProductButton.click();
    }

}