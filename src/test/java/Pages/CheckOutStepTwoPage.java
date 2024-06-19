package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwoPage extends BaseTest {

    public CheckOutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }
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
    //-----------------------


    public boolean cancelButtonIsDisplayed(){
        return elementDisplayed(cancelButton);
    }
    public boolean finisButtonIsDisplayed(){
        return elementDisplayed(finishButton);
    }
    public boolean productpriceIsDisplayed(){
        return elementDisplayed(productprice);
    }
    public void clickonCancelButton(){
        cancelButton.click();
    }
    public void clickOnFinishButton(){
        finishButton.click();
    }
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
