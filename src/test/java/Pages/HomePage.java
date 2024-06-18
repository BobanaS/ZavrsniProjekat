package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> products;


    //---------------------------
    public boolean displayedProduct() {
        return elementDisplayed(products.get(2));
    }
}