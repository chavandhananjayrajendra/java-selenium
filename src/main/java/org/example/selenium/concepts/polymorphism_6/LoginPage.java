package org.example.selenium.concepts.polymorphism_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// 🔁 Polymorphism Example in Selenium
// ✅ Demonstrates method overloading (compile-time polymorphism)


public class    LoginPage {
    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Overloaded method - takes both username and password
    public void login(String u, String p) {
        driver.findElement(username).sendKeys(u);
        driver.findElement(password).sendKeys(p);
        driver.findElement(loginBtn).click();
    }

    // ✅ Overloaded method - uses default password
    public void login(String u) {
        login(u, "secret_sauce"); // default password used
    }
}
