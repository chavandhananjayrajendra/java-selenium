package org.example.selenium.concepts.polymorphism_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// 🔁 Polymorphism Test in Selenium
// ✅ Shows method overloading + overriding in one flow

public class PolymorphismTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Method Overloading (Compile-time Polymorphism)
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user"); // single param version
        // loginPage.login("standard_user", "secret_sauce"); // also valid

        // Method Overriding (Runtime Polymorphism)
        BasePage page = new ProductsPage(driver); // super class reference
        page.openPage(); // actual method of child class is executed

        System.out.println("✅ Page title: " + page.getPageTitle());

        driver.quit();
    }
}
