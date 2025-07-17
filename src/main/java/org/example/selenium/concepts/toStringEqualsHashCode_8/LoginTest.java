package org.example.selenium.concepts.toStringEqualsHashCode_8;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Create test metadata
        TestMetaData test1 = new TestMetaData("Login Test", "https://www.saucedemo.com");
        TestMetaData test2 = new TestMetaData("Login Test", "https://www.saucedemo.com");

        // ✅ Logging using toString()
        System.out.println(test1);  // Output: Test: Login Test, URL: https://www.saucedemo.com

        // ✅ Comparing tests
        System.out.println(test1.equals(test2)); // true, because both test name & URL match

        // ✅ hashCode (not visible but useful if stored in HashMap/HashSet)
        System.out.println("Hash Code: " + test1.hashCode());

        // Selenium example usage
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(test1.toString()); // just for demo; normally you’d use test1.getUrl()
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.quit();
    }
}
