
package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeading =
            By.xpath("//h2[normalize-space()='All Products']");

    private final By productCards =
            By.cssSelector(".features_items .product-image-wrapper");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
    }

    public boolean isPageHeadingDisplayed() {

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(pageHeading))
                .isDisplayed();
    }

    public int getProductCount() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productCards));

        return driver.findElements(productCards).size();
    }
}
