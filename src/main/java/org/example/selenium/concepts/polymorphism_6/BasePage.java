package org.example.selenium.concepts.polymorphism_6;

import org.openqa.selenium.WebDriver;



public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openPage();

    public String getPageTitle() {
        return driver.getTitle();
    }
}
