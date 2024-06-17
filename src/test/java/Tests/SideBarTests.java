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

    public void TestUserLogIn() {
        logInPage.inputUserName("standar_user");
        logInPage.inputPassword("secret_sauce");
        logInPage.clickOnLogInButton();
    }

    @Test(priority = 10)
    public void sideBarButtonDisplayed() {
        TestUserLogIn();
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());
    }

    @Test(priority = 20)
    public void userOpenTheSideManu() {
        TestUserLogIn();
        sidebarPage.openSideBar();
        Assert.assertEquals(sidebarPage.sideBarManu.get(0).getText(), "All Items");
        Assert.assertEquals(sidebarPage.sideBarManu.get(1).getText(), "About");
        Assert.assertEquals(sidebarPage.sideBarManu.get(2).getText(), "Logout");
        Assert.assertEquals(sidebarPage.sideBarManu.get(3).getText(), "Reset App State");
    }

    @Test(priority = 30)
    public void userCanCloseTheSidebar() {
        TestUserLogIn();
        sidebarPage.openSideBar();
        waitForElementVisibility(sidebarPage.closeSideBarButton);
        sidebarPage.closeSideBar();
        Assert.assertTrue(sidebarPage.sideBarButtonIsDisplayed());


    }
}
