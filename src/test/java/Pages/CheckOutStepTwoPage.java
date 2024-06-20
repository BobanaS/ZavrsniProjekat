package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
  The CheckOutStepTwoPage class extends BaseTest and represents the checkout step two page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class CheckOutStepTwoPage extends BaseTest {
    //Constructor of the page
    public CheckOutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements and their locators

    @FindBy(id="cancel")
    public WebElement cancelButton;
    @FindBy(id="finish")
    public WebElement finishButton;
    @FindBy(className = "inventory_item_name")
    public WebElement product;
    @FindBy(className = "inventory_item_price")
    public WebElement productprice;
    @FindBy (className = "summary_tax_label")
    public WebElement tax;
    @FindBy (className = "summary_total_label")
    public WebElement totalPrice;

    //-------------------------------------------------

    /*
      Checks if the specified cancelButton is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean cancelButtonIsDisplayed(){
        return elementDisplayed(cancelButton);
    }
    /*
      Checks if the specified finishButton is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean finisButtonIsDisplayed(){
        return elementDisplayed(finishButton);
    }
    /*
      Checks if the specified productprice is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean productpriceIsDisplayed(){
        return elementDisplayed(productprice);
    }
    /*
     Method to click the cancelButton.
    This method initiates cancel process by clicking the checkout button on the cart page.
    */
    public void clickonCancelButton(){
        cancelButton.click();
    }
    /*
     Method to click the finishButton.
    This method initiates finish process by clicking the checkout button on the cart page.
    */
    public void clickOnFinishButton(){
        finishButton.click();
    }
    /*
      Checks if the total price matches the sum of the product price and tax amount.
      This method retrieves the product price, tax amount, and total price from their respective elements,
      parses them into double values, and compares the sum of product price and tax with the total price.
     return true if the total price matches the sum of product price and tax; false otherwise
     */
    public boolean isTheTrueTotalPriceWhenYouAddTax(){
        String priceText = productprice.getText().replace("$", "");
        String taxText=tax.getText().replace("Tax: $", "");
        String totalText=totalPrice.getText().replace("Total: $", "");
        double productp = Double.parseDouble(priceText);
        double taxx=Double.parseDouble(taxText);
        double totaly=Double.parseDouble(totalText);
        if(totaly==(productp+taxx)){
            return true;
        }
        else{
            return false;
        }
    }
}
