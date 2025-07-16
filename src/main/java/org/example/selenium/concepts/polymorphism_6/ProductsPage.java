package org.example.selenium.concepts.polymorphism_6;

import org.openqa.selenium.WebDriver;


// ✅ Demonstrates Runtime Polymorphism (method overriding)

import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }
}
