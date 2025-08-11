package org.example.selenium.examples.session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //syntax :
        //http://username:password@the-internet.herokuapp.com/basic_auth
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
    }
}
