
package com.automation.tests;

import com.automation.base.BaseTest2;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest2 extends BaseTest2 {

    @Test
    public void verifyHomepageTitle() {

        log.info("Test: Verify homepage title");

        String actualTitle = getDriver().getTitle();

        Assert.assertTrue(
                actualTitle.contains("Automation Exercise"),
                "Homepage title is incorrect");

        log.info("Homepage title verified successfully");
    }

    @Test
    public void verifyLogoDisplayed() {

        log.info("Test: Verify logo");

        HomePage homePage = new HomePage(getDriver());

        Assert.assertTrue(
                homePage.isLogoDisplayed(),
                "Logo is not displayed");

        log.info("Logo verified successfully");
    }

    @Test
    public void verifyNavigationMenu() {

        log.info("Test: Verify navigation menu");

        HomePage homePage = new HomePage(getDriver());

        Assert.assertTrue(homePage.isProductsLinkDisplayed());
        Assert.assertTrue(homePage.isCartLinkDisplayed());
        Assert.assertTrue(homePage.isLoginLinkDisplayed());
        Assert.assertTrue(homePage.isContactLinkDisplayed());

        log.info("Navigation menu verified successfully");
    }

    @Test
    public void verifyProductsNavigation() {

        log.info("Test: Verify Products navigation");

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickProducts();

        Assert.assertTrue(
                productsPage.isPageHeadingDisplayed(),
                "Products page heading not displayed");

        log.info("Products navigation verified successfully");
    }

    @Test
    public void verifyProductListing() {

        log.info("Test: Verify product listing");

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickProducts();

        Assert.assertTrue(
                productsPage.getProductCount() > 0,
                "No products found");

        log.info("Product listing verified successfully");
    }
}
