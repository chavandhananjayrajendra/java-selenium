package org.example.selenium.concepts.encapsulation_4;

// 👨‍🔧 Test class using the encapsulated LoginPage class

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        // 1️⃣ Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // 2️⃣ Launch the browser
        WebDriver driver = new ChromeDriver();

        // 3️⃣ Open the target website
        driver.get("https://www.saucedemo.com/");

        // 4️⃣ Create an object of LoginPage (pass the driver)
        LoginPage loginPage = new LoginPage(driver);

        // 5️⃣ Call the public login() method (this is abstraction in use, based on encapsulated class)
        loginPage.login("standard_user", "secret_sauce");

        // 6️⃣ Validate login using URL or page element
        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("✅ Login successful for inventory user");
        } else {
            System.out.println("❌ Login failed");
        }

        // 7️⃣ Close the browser
        driver.quit();
    }
}
