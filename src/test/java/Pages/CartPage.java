package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
  The CartPage class extends BaseTest and represents the shopping cart page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class CartPage extends BaseTest {
    //Constructor of the page
    public CartPage() {
        PageFactory.initElements(driver, this);
    }


    // WebElements and their locators
    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;
    @FindBy(id = "continue-shopping")
    public WebElement continueButton;
    @FindBy(id = "checkout")
    public WebElement chekoutButton;
    @FindBy(className = "title")
    public WebElement titlecart;
    //Ukoliko je i proizvod ubacen
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartnumber;
    @FindBy(className = "cart_item")
    public WebElement product;
    @FindBy(className = "inventory_item_name")
    public WebElement productName;
    @FindBy(className = "inventory_item_price")
    public WebElement productPrice;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;

    //------------------------------------------------
    /*
      Checks if the specified cartIcon is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean cartIconIsDisplayed() {

        return elementDisplayed(cartIcon);
    }
    /*
      Method to click the cartIcon.
     This method initiates go to cartPage process by clicking the checkout button on the cart page.
     */
    public void clickOnCartIcon(){
        cartIcon.click();
    }
    /*
      Method to click the checkout button.
     This method initiates the continue to shop process by clicking the continue button on the cart page.
     */
    public void clickOnContinueToShopButton(){
        continueButton.click();
    }
    /*
      Method to click the checkout button.
      This method initiates the checkout process by clicking the checkout button on the cart page.
     */
    public void clickOnCheckOutButton(){
        chekoutButton.click();
    }
    /*
      Checks if the tittlecart is the "Your Cart".
      This method returns true if it equals, and false otherwise.
     */
    public boolean isThereTitleYourCart(){
        return titlecart.getText().equals("Your Cart");
    }
}