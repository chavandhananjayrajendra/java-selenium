package org.example.selenium.concepts.multithreading_9;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTask extends Thread {
    private String username;

    public LoginTask(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver", "D:\\bakup\\chromedriver-win64 latest\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println(username + " login test complete.");
        driver.quit();
    }
}

