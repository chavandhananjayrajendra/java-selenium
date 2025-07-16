package org.example.selenium.concepts.encapsulation_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// 🔐 Encapsulation Example in Selenium



public class LoginPage {

    // ✅ Private WebDriver and Locators (Encapsulation)
    private WebDriver driver;

    // These locators are hidden from outside classes (data hiding)
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    // ✅ Public constructor allows external class to inject WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Public method to perform login
    // This exposes behavior, but hides internal details (Encapsulation)
    public void login(String u, String p) {
        driver.findElement(username).sendKeys(u);
        driver.findElement(password).sendKeys(p);
        driver.findElement(loginBtn).click();
    }

    // Only login() is exposed — the internal working and locators are hidden.
}
