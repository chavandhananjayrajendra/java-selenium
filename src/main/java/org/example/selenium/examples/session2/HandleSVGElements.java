package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleSVGElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();

   //relative xpath using text
//        driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();


        //identify SVG Element
//        driver.findElement(By.xpath("//a[normalize-space()=\"\"]//*[name()=\"svg\"]")).click();
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
    }
}
