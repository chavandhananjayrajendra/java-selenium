package org.example.selenium.concepts.inheritence_3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ✅ Base class for browser setup
 */
public class BaseTest {
    WebDriver driver;

    public void launchBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void tearDown() {
        driver.quit();
    }
}
