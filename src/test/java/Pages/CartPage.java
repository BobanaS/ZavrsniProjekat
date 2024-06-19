package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }
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
    public boolean cartIconIsDisplayed() {

        return elementDisplayed(cartIcon);
    }
    public void clickOnCartIcon(){
        cartIcon.click();
    }
    public void clickOnContinueToShopButton(){
        continueButton.click();
    }
    public void clickOnCheckOutButton(){
        chekoutButton.click();
    }
    public boolean isThereTitleYourCart(){
        return titlecart.getText().equals("Your Cart");
    }
}