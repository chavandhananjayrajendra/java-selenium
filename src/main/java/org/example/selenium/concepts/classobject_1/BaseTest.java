package org.example.selenium.concepts.classobject_1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ✅ CLASS: BaseTest
 * Reusable base class to manage browser setup.
 *here we are using basetest to setup the classes and objects concept using selenium
 */
public class BaseTest {
    WebDriver driver;

    // ✅ Method to launch browser and open site
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    // ✅ Method to close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
