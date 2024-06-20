package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
  The SidebarPage class extends BaseTest and represents the sidebar page of the application.
  This class contains WebElements and their locators,
  as well as methods to interact with these elements.
 */
public class SidebarPage extends BaseTest {
    //Constructor of the page

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }
    // WebElements and their locators
    @FindBy(id = "react-burger-menu-btn")
    public WebElement sideBarButton;
    @FindBy(className = "bm-item")
    public List<WebElement>sideBarManu;
    @FindBy(id="react-burger-cross-btn")
    public WebElement closeSideBarButton;
//--------------------------------------
    /*
    Checks if the sidebar button is displayed on the page.
    return true if the sidebar button is displayed; false otherwise
     */
    public boolean sideBarButtonIsDisplayed(){
    return  elementDisplayed(sideBarButton);
    }
    /*
     Clicks on the sidebar button to open the sidebar.
     */
    public void openSideBar(){
        sideBarButton.click();
    }
    /*
     Clicks on the close button of the sidebar to close it.
     */
    public void closeSideBar(){
        closeSideBarButton.click();
    }
    /*
      Clicks on the specified item in the sidebar menu.
      @param option the name of the item to click on
     */
    public void clickOnSideBarItem(String option) {
        for(WebElement opcija : sideBarManu) {
            if(opcija.getText().equals(option)) {
                opcija.click();
                break;
            }
        }
    }

}