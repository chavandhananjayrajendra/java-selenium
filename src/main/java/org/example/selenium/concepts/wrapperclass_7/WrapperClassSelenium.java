package org.example.selenium.concepts.wrapperclass_7;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrapperClassSelenium {

    public static void main(String[] args) {
        // Set the path to your local ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // Locate login button
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // ✅ Using Boolean (Wrapper class) instead of primitive
        Boolean isButtonVisible = loginButton.isDisplayed();  // returns boolean, auto-boxed to Boolean

        // Wrapper class gives you access to methods and object behavior
        System.out.println("Login Button Visible? " + isButtonVisible.toString());

        // Example: compare two Boolean objects
        Boolean expectedVisibility = Boolean.TRUE;
        if (isButtonVisible.equals(expectedVisibility)) {
            System.out.println("Button is visible as expected.");
        } else {
            System.out.println("Button visibility not as expected.");
        }

        driver.quit();
    }
}
