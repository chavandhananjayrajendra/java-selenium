package org.example.selenium.concepts.constructor_this_2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ✅ USING `this` IN SELENIUM (Page Object Model)
 * - Constructor receives WebDriver from test class
 * - `this.driver` is instance variable
 * - `driver` is constructor parameter
 */
public class LoginPage {
    WebDriver driver;

    // ✅ Constructor: injects driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;  // `this` refers to the class-level variable
    }

    // Actions
    public void enterUsername(String name) {
        driver.findElement(By.id("username")).sendKeys(name);
    }

    public void enterPassword(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(By.id("submit")).click();
    }
}
