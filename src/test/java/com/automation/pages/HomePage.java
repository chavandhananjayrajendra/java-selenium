
package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By logo =
            By.cssSelector("img[src='/static/images/home/logo.png']");

    private final By productsLink =
            By.cssSelector("a[href='/products']");

    private final By cartLink =
            By.cssSelector("a[href='/view_cart']");

    private final By loginLink =
            By.cssSelector("a[href='/login']");

    private final By contactLink =
            By.cssSelector("a[href='/contact_us']");

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
    }

    public boolean isLogoDisplayed() {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(logo));

        return element.isDisplayed();
    }

    public boolean isProductsLinkDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(productsLink))
                .isDisplayed();
    }

    public boolean isCartLinkDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(cartLink))
                .isDisplayed();
    }

    public boolean isLoginLinkDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(loginLink))
                .isDisplayed();
    }

    public boolean isContactLinkDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(contactLink))
                .isDisplayed();
    }

    public void clickProducts() {

        wait.until(ExpectedConditions.elementToBeClickable(productsLink))
                .click();
    }
}
