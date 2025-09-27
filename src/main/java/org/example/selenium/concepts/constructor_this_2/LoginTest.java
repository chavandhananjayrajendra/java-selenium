package org.example.selenium.concepts.constructor_this_2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // ✅ Create object of LoginPage and pass driver
        LoginPage page = new LoginPage(driver);

        // ✅ Use methods from page class
        page.enterUsername("student");
        page.enterPassword("password123");
        page.clickLogin();
        System.out.println("Login Successful");

        // Close browser
        driver.quit();
    }
}
