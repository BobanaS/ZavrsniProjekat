package Pages;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BaseTest {

    public CheckOutCompletePage() {
        PageFactory.initElements(driver, this);
    }
}