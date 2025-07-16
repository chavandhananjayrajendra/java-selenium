package org.example.selenium.concepts.abstraction_5;

import org.openqa.selenium.WebDriver;


// 🧠 Abstract class to represent common page structure in Selenium
// ✅ Demonstrates Abstraction - defining common structure without implementation


public abstract class BasePage {
    protected WebDriver driver;

    // Constructor to initialize driver in all child pages
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Abstract method - must be implemented by child classes
    public abstract void openPage();

    // ✅ Common method - all pages can use this
    public String getPageTitle() {
        return driver.getTitle();
    }
}
