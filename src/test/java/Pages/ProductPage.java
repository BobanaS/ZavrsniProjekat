package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {

    public ProductPage() {

        PageFactory.initElements(driver, this);
    }


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

    public void clickBactoProducts(){
        backToProductsPage.click();
    }
    public void clickAddToCartonPage(){
        addtoCartButton.click();
    }
    public boolean userIsOnProductPage(String product){
        return productName.getText().equals(product);
    }
    public boolean imageIsDisplayed(){
        return productImage.isDisplayed();
    }
    public boolean priceisDisplayed(){
        return productPrice.isDisplayed();
    }
    public boolean removeButtonIsDisplayed(){
    return removeButton.isDisplayed();
    }
    public void clickOnRemoveButton(){
        removeButton.click();
    }
    public void clickOnShopingCart(){
        shopCart.click();
    }
}
