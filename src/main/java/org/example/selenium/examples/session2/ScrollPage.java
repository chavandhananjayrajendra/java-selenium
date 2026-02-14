package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPage {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = driver;
        //1) Scroll down page by pixel number

        js.executeScript("window.scrollBy(0,1000)","");
        System.out.println(js.executeScript("return window.pageYOffset;"));//1000

//2) Scroll the page till element is visible
        driver.get("https://www.flipkart.com");
        WebElement ele = driver.findElement(By.xpath("(//a[normalize-space()='Brand Directory'])[1]"));


        js.executeScript("arguments[0].scrollIntoView();",ele);
        System.out.println(js.executeScript("return window.pageYOffSet"));


        //3) scroll page till end of the page.

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");


        //scrolling up to initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");




    }
}
