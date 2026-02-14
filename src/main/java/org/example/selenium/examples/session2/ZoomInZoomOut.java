package org.example.selenium.examples.session2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        Thread.sleep(5000);
        driver.manage().window().minimize();
        Thread.sleep(5000);
        driver.manage().window().maximize();


        //zoom in zoom out using javascriptExecutor
        JavascriptExecutor js = driver;
        js.executeScript("document.body.style.zoom= '50%'");
        Thread.sleep(5000);
        js.executeScript("document.body.style.zoom= '80%'");



    }
}
