package org.example.selenium.concepts.abstraction_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class AbstractionTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // ✅ Use BasePage reference to hold child class object (Polymorphism + Abstraction)
        BasePage page = new LoginPage(driver);

        // ✅ Calls the overridden method in LoginPage
        page.openPage();

        // Cast to LoginPage to call login (safe here as we know the actual object type)
        ((LoginPage) page).login("standard_user", "secret_sauce");

        System.out.println("Page Title: " + page.getPageTitle());

        driver.quit();
    }
}
