package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.naming.Name;
import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    public List<WebElement> products;
    @FindBy(className = "inventory_item_name")
    public List<WebElement> productName;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrice;
    @FindBy(id = "react-burger-menu-btn")
    public WebElement sideBarButton;
    @FindBy(className = "product_sort_container")
    public WebElement sortOptions;
    @FindBy(id="add-to-cart-sauce-labs-onesie")
    public WebElement addToCart;
    //---------------------------
    public boolean displayedProduct() {
        return elementDisplayed(products.get(2));
    }

    public void clickOnSortOptionMenu() {
        sortOptions.click();
    }

    public boolean optionIsDisplayed() {
        List<WebElement> options = sortOptions.findElements(By.tagName("option"));
        return elementDisplayed(options.getFirst());
    }

    public void selectOptionFromProductsSorter(String optionName) {
        List<WebElement> options = sortOptions.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getAttribute("value").equals(optionName)) {
                option.click();
                break;
            }
        }

    }

    public void userSortProductByNameAZ() {
        selectOptionFromProductsSorter("az");
    }

    public void userSortProductByNameZtoA() {
        selectOptionFromProductsSorter("za");
    }

    public void userSortProductByPriceLowToHigh() {
        selectOptionFromProductsSorter("lohi");
    }

    public void userSortProductByPriceHighToLow() {
        selectOptionFromProductsSorter("hilo");
    }

    public boolean isProductSortedByNameAZ() {
        String previousName = "";
        for (WebElement productName : productName) {
            String currentName = productName.getText();
            if (currentName.compareTo(previousName) < 0) {
                return false;
            }
            previousName = currentName;

        }
        return true;
    }

    public boolean isProductSortedByNameZA() {
        String previousName = "Z";
        for (WebElement productName : productName) {
            String currentName = productName.getText();
            if (currentName.compareTo(previousName) > 0) {
                return false;
            }
            previousName = currentName;

        }
        return true;
    }

    public boolean isSortedByPriceLowToHigh() {
        double previousPrice = 0.0;
        for (WebElement productprice : productPrice) {
            String priceText = productprice.getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);
            if (currentPrice < previousPrice) {
                return false;
            }
            previousPrice = currentPrice;
        }
        return true;
    }

    public boolean isSortedByPriceHighToLow() {
        double previousPrice = Double.MAX_VALUE;
        for (WebElement productprice : productPrice) {
            String priceText = productprice.getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);
            if (currentPrice > previousPrice) {
                return false;
            }
            previousPrice = currentPrice;
        }
        return true;
    }
    public void goTOproductPage(String productname){
        for(WebElement productName:productName){
            if(productName.getText().equals(productname)){
                productName.click();
                break;
            }
        }
    }
    public void addProductToCart(String productNam){
        for(WebElement product:products){
            if(product.findElement(By.className("inventory_item_name")).getText().equals(productNam)){
                product.findElement(By.className("btn_inventory")).click();
                break;
            }
        }
    }
    public void removeProductToCart(String productNam){
        for(WebElement product:products){
            if(product.findElement(By.className("inventory_item_name")).getText().equals(productNam)){
                product.findElement(By.className("btn_inventory")).click();
                break;
            }
        }
    }
    public boolean productPrice(String productName, String pricesecond){
        boolean x=true;
        for(WebElement product: products){
            if((product.findElement(By.className("inventory_item_name")).getText().equals(productName))){
                if (product.findElement(By.className("inventory_item_price")).getText().equals(pricesecond)){
                    return true;
                }
                else {
                    x=false;
                }

            }
        }
        return x;
    }

}



