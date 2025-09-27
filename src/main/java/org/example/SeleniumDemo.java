package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        driver.get("https://youtu.be/LSUR0075KLI?si=0hWRrZeHiSpSectH");
        Thread.sleep(30000);
    }
}
