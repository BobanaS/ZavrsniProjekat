package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SideBarTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }



    @Test(priority = 10)
    public void sideBarButtonDisplayed() {
        testUserLogIn();
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
    }

    @Test(priority = 20)
    public void userOpenTheSideManu() {
        testUserLogIn();
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        Assert.assertEquals(sidebarPage.sideBarManu.get(0).getText(), "All Items");
        Assert.assertEquals(sidebarPage.sideBarManu.get(1).getText(), "About");
        Assert.assertEquals(sidebarPage.sideBarManu.get(2).getText(), "Logout");
        Assert.assertEquals(sidebarPage.sideBarManu.get(3).getText(), "Reset App State");
    }

    @Test(priority = 30)
    public void userCanCloseTheSidebar() {
        testUserLogIn();
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.closeSideBar();
        waitForElementVisibility(sidebarPage.sideBarButton);
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());

    }
    @Test(priority = 40)
    public void userTestAllItemsButton(){
        testUserLogIn();
        waitForElementVisibility(sidebarPage.sideBarButton);
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("All Items");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test(priority =50)
    public void userClickAbout(){
        testUserLogIn();
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.clickOnSideBarItem("About");
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
    }
    @Test (priority = 60)
    public void userClickLogOut() {
        testUserLogIn();
        sidebarPage.openSideBar();
        sidebarPage.clickOnSideBarItem("Logout");
        waitForElementVisibility(logInPage.logo);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(logInPage.elementDisplayed(logInPage.usernameField));
    }
}

