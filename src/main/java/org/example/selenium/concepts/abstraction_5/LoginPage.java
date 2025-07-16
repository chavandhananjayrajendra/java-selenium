package org.example.selenium.concepts.abstraction_5;

// 🔐 LoginPage extending BasePage
// ✅ Demonstrates Abstraction - implements abstract method with page-specific behavior

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators specific to login page
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver); // Call to BasePage constructor
    }

    // ✅ Implement abstract method
    @Override
    public void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String u, String p) {
        driver.findElement(username).sendKeys(u);
        driver.findElement(password).sendKeys(p);
        driver.findElement(loginBtn).click();
    }
}
