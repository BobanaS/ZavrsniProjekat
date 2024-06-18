package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BaseTest {

    public CheckOutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backToProductButton;

    @FindBy(className = "title")
    public WebElement checkOutTitle;

    @FindBy(className = "complete-header")
    public WebElement checkOutMessage;


    //------------------------------
    public boolean isBackToProductButtonDisplayed(){
        return elementDisplayed(backToProductButton);
    }
    public boolean isThereCheckOutMessage(){
        return elementDisplayed(checkOutMessage);
    }
    public boolean isCheckOutMessage(){
        return checkOutMessage.getText().equals("Thank you for your order!");
    }
    public boolean isCheckOutTittle(){
        return checkOutTitle.getText().equals("Checkout: Complete!");
    }
    public void clickOnBackToProductsButton(){
        backToProductButton.click();
    }

}