package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
  The ProductPage class extends BaseTest and represents the product page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class ProductPage extends BaseTest {
    //Constructor of the page
    public ProductPage() {

        PageFactory.initElements(driver, this);
    }

    // WebElements and their locators

    @FindBy(id = "back-to-products")
    public WebElement backToProductsPage;
    @FindBy(id="add-to-cart")
    public WebElement addtoCartButton;
    @FindBy(className = "inventory_details_img")
    public WebElement productImage;
    @FindBy(className = "inventory_details_name")
    public WebElement productName;
    @FindBy(className = "inventory_details_price")
    public WebElement productPrice;
    @FindBy(className = "inventory_details_desc")
    public WebElement productDescription;
    @FindBy(id="remove")
    public WebElement removeButton;
    @FindBy(className = "shopping_cart_link")
    public WebElement shopCart;
    //-----------
    /*
     *
     Clicks on the 'Back to Products' button.
     This method navigates the user back to the products page.
     */
    public void clickBactoProducts(){
        backToProductsPage.click();
    }
    /*
      Clicks on the 'Add to Cart' button on the current page.
     This method adds the product to the shopping cart.
     */
    public void clickAddToCartonPage(){
        addtoCartButton.click();
    }
    /*
     Checks if the user is on the page of the specified product.
     param product the name of the product to check
     return true if the user is on the page of the specified product; false otherwise
     */
    public boolean userIsOnProductPage(String product){
        return productName.getText().equals(product);
    }
    /*
     Checks if the product image is displayed on the page.
     return true if the product image is displayed; false otherwise
     */
    public boolean imageIsDisplayed(){
        return productImage.isDisplayed();
    }
    /*
     Checks if the product price is displayed on the page.
     return true if the product price is displayed; false otherwise
     */
    public boolean priceisDisplayed(){
        return productPrice.isDisplayed();
    }
    /*
     Checks if the removeButton is displayed on the page.
     return true if the removeButton is displayed; false otherwise
     */
    public boolean removeButtonIsDisplayed(){
    return removeButton.isDisplayed();
    }
    /*
     Clicks on the remove button for the product.
     This method removes the product from the shopping cart.
     */
    public void clickOnRemoveButton(){
        removeButton.click();
    }
    /*
    Clicks on the 'Shopping Cart' button.
    This method navigates the user to the shopping cart page.
    */

    public void clickOnShopingCart(){
        shopCart.click();
    }
}
