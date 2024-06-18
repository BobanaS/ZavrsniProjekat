package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement sideBarButton;
    @FindBy(className = "bm-item")
    public List<WebElement>sideBarManu;
    @FindBy(id="react-burger-cross-btn")
    public WebElement closeSideBarButton;
//-------

    public boolean sideBarButtonIsDisplayed(){
    return  elementDisplayed(sideBarButton);
    }
    public void openSideBar(){
        sideBarButton.click();
    }
    public void closeSideBar(){
        closeSideBarButton.click();
    }

    public void clickOnSideBarItem(String option) {
        for(WebElement opcija : sideBarManu) {
            if(opcija.getText().equals(option)) {
                opcija.click();
                break;
            }
        }
    }

}