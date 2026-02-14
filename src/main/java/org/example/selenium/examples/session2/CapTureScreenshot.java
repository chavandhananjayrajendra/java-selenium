package org.example.selenium.examples.session2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CapTureScreenshot {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //1)Full Page Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
       File sourceFile =  ts.getScreenshotAs(OutputType.FILE);
       File targetFile = new File(System.getProperty("user.dir")+"\\ screenshots\\fullpage.png");
sourceFile.renameTo(targetFile);

//2) capture the screenshot of specific section

        driver.get("https://www.acer.com/in-en/support");

        WebElement support= driver.findElement(By.xpath("//header[@class=\"section__header section__header--center\"]"));
        File sourceFile1 = support.getScreenshotAs(OutputType.FILE);
        File targetFile1 = new File("D:\\bakup\\JavaSelenium\\ screenshots\\new1.png");
        sourceFile1.renameTo(targetFile1);


        //3) capute the screenshot of webElement
     WebElement win11 = driver.findElement(By.xpath("  //img[@alt=\"windows-11-banner\"]"));
     File srcfile = win11.getScreenshotAs(OutputType.FILE);
     File trgfile = new File("D:\\bakup\\JavaSelenium\\ screenshots\\new2.png");
     srcfile.renameTo(trgfile);  //copy sourcefile to targetfile

        driver.quit();

    }
}
