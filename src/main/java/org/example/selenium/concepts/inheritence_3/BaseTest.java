package org.example.selenium.concepts.inheritence_3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ✅ Base class for browser setup
 */
public class BaseTest {
    WebDriver driver;

    public void launchBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "D://bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void tearDown() {
        driver.quit();
    }
}
