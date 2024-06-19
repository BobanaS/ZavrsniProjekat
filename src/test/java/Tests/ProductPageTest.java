package Tests;

import Base.BaseTest;
import Pages.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        logInPage = new LogInPage();
        socialNetworkPage = new SocialNetworkPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkOutStepTwoPage = new CheckOutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();
        productPage = new ProductPage();
        testUserLogIn();
        homePage.goTOproductPage(productForProductPageTest);
    }

    @Test(priority = 10)
    public void userIsOnTheProductPage() {
        Assert.assertEquals(driver.getCurrentUrl(), productForProductPageTestURL);
        Assert.assertTrue(productPage.productName.getText().equals(productForProductPageTest));
    }

    @Test(priority = 20)
    public void userClickOnBactToProduct() {
        productPage.clickBactoProducts();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
    @Test(priority = 30)
    public void userCanGoToTheShopCartFromProductPage() {
        productPage.clickOnShopingCart();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
    }

    @Test(priority = 40)
    public void userClickAddToCart() {
        productPage.clickAddToCartonPage();
        Assert.assertTrue(productPage.removeButtonIsDisplayed());
        Assert.assertTrue(cartPage.elementDisplayed(cartPage.cartnumber));
        productPage.clickOnShopingCart();
        Assert.assertTrue(cartPage.productName.getText().equals(productForProductPageTest));
    }

    @Test(priority = 50)
    public void userRemoveProductFromCart() {
        productPage.clickAddToCartonPage();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(productPage.elementDisplayed(productPage.addtoCartButton));
    }

    @Test(priority = 60)
    public void productHasTheSamePriceOnHomeAndProductPage() {
        Assert.assertTrue(homePage.productPrice(productForProductPageTest, productPage.productPrice.getText()));
    }
    @AfterMethod()
    public void closeTab(){
        driver.close();
    }

}
