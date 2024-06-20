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

/*
  The HomePage class extends BaseTest and represents the home page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class HomePage extends BaseTest {

    //Constructor of the page

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements and their locators

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
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement addToCart;
    //---------------------------


    /*
      Checks if the specified product is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean displayedProduct() {
        return elementDisplayed(products.get(2));
    }

    /*
       Method to click the sortOption.
       This method initiates opent Sort Option menu by clicking the sort option button on the home page.
    */
    public void clickOnSortOptionMenu() {
        sortOptions.click();
    }
    /*
      Checks if the specified option is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */

    public boolean optionIsDisplayed() {
        List<WebElement> options = sortOptions.findElements(By.tagName("option"));
        return elementDisplayed(options.getFirst());
    }
    /*
      Selects the specified option from the products sorter dropdown.
      This method finds all options in the sorter dropdown, compares their values
      with the given optionName, and clicks on the matching option.
      String valueName the name of the value to select from the products sorter
     */
    public void selectOptionFromProductsSorter(String valueName) {
        List<WebElement> options = sortOptions.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getAttribute("value").equals(valueName)) {
                option.click();
                break;
            }
        }

    }
    /*
        Allows the user to sort products by name in order (A to Z).
        This method selects the 'az' option from the products sorter dropdown.
     */

    public void userSortProductByNameAZ() {
        selectOptionFromProductsSorter("az");
    }
    /*
        Allows the user to sort products by name in order (Z to A).
        This method selects the 'za' option from the products sorter dropdown.
     */

    public void userSortProductByNameZtoA() {
        selectOptionFromProductsSorter("za");
    }
    /*
        Allows the user to sort products by price in order by Low To High.
        This method selects the 'lohi' option from the products sorter dropdown.
     */

    public void userSortProductByPriceLowToHigh() {
        selectOptionFromProductsSorter("lohi");
    }
     /*
        Allows the user to sort products by price in order by High To Low.
        This method selects the 'hilo' option from the products sorter dropdown.
     */

    public void userSortProductByPriceHighToLow() {
        selectOptionFromProductsSorter("hilo");
    }
    /*
/*
    Checks if the products are sorted by name in order (A to Z).
    This method iterates through the list of product names, compares each name with the previous one,
    and returns true if all names are in order, otherwise returns false.
    If current name is lexicographically less than previous name, return false
    return true if products are sorted by name in order(A to Z); false otherwise
 */
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
    /*
       Checks if the products are sorted by name in descending order (Z to A).
       This method iterates through the list of product names, compares each name with the previous one,
       and returns true if all names are in descending order, otherwise returns false.
       return true if products are sorted by name in descending order; false otherwise
       If current name is lexicographically greater than previous name, return false
     */

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
/*
   Checks if the products are sorted by price in ascending order (low to high).
   This method iterates through the list of product prices, compares each price with the previous one,
   and returns true if all prices are in ascending order, otherwise returns false.
   return true if products are sorted by price in ascending order; false otherwise
 */
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
    /*
      Checks if the products are sorted by price in descending order (high to low).
      This method iterates through the list of product prices, compares each price with the previous one,
      and returns true if all prices are in descending order, otherwise returns false
      return true if products are sorted by price in descending order; false otherwise
     */

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
    /*
     **
       Navigates to the page of the specified product.
       This method iterates through a list of product names, compares each name with the provided product name,
       and clicks on the matching product name to navigate to its page.
       param productName the name of the product to navigate to
     */
    public void goTOproductPage(String productname) {
        for (WebElement productName : productName) {
            if (productName.getText().equals(productname)) {
                productName.click();
                break;
            }
        }
    }
    /*
    Adds the specified product to the shopping cart.
    This method iterates through a list of products, finds the product with the matching name,
    and clicks the add to cart button for that product.
    param productName the name of the product to add to the cart
     */
    public void addProductToCart(String productNam) {
        for (WebElement product : products) {
            if (product.findElement(By.className("inventory_item_name")).getText().equals(productNam)) {
                product.findElement(By.className("btn_inventory")).click();
                break;
            }
        }
    }
    /*
    Removes the specified product from the shopping cart.
    This method iterates through a list of products, finds the product with the matching name,
    and clicks the remove from cart button for that product.
    param productName the name of the product to add to the cart
     */
    public void removeProductToCart(String productNam) {
        for (WebElement product : products) {
            if (product.findElement(By.className("inventory_item_name")).getText().equals(productNam)) {
                product.findElement(By.className("btn_inventory")).click();
                break;
            }
        }
    }
/*
    Checks if the price of a product matches the expected price on other pages compared to the homepage.
    This method iterates through a list of products, compares the product name with the provided name,
    and checks if the product price matches the expected price.
    param productName the name of the product to check the price for
    param pricesecond the expected price of the product on other pages
    return true if the product price matches the price second; false otherwise
 */
    public boolean productPrice(String productName, String pricesecond) {
        boolean x = true;
        for (WebElement product : products) {
            if ((product.findElement(By.className("inventory_item_name")).getText().equals(productName))) {
                if (product.findElement(By.className("inventory_item_price")).getText().equals(pricesecond)) {
                    return true;
                } else {
                    x = false;
                }

            }
        }
        return x;
    }

}



