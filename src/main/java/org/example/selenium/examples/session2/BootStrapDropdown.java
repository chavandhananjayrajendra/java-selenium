package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


/*

Bootstrap dropdowns are not <select> tags, so Select class won’t work.
 Options are usually inside a <div> or <ul>, not <option> elements.
We handle them like normal clickable elements.

Since it’s not a <select>, don’t use `Select` class.
 */


public class BootStrapDropdown {
    public static void main(String[] args) throws InterruptedException {

        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Load your HTML page locally
        driver.get("C:\\Users\\chava\\Downloads\\JavaSelenium\\bootstrapdropdown.html");

        // Click the dropdown button
        WebElement dropdownBtn = driver.findElement(By.cssSelector(".dropdown-toggle"));
        dropdownBtn.click();

// Wait for options to appear
        List<WebElement> options = driver.findElements(By.cssSelector(".dropdown-menu .dropdown-item"));
        System.out.println("Total options: " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equals("Option 2")) {
                option.click();
                break;
            }
        }


        Thread.sleep(2000); // Just to see the action before closing
        driver.quit();
    }
}
