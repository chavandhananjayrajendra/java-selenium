package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/* frames
--------------------
driver.switchTo().frame(name)
driver.switchTo().frame(id)
driver.switchTo().frame(WebElement)
driver.switchTo().frame(index)



REMEMBER:
Frame-to-Frame : can't directly switch..... need to use         driver.switchTo().defaultContent();- go to main page and then a specific frame


in inner frames scenarios--- main page ->f1 -> f2 possible
f2-> f1 not possible u have to navigate like f2----> mainpage----->f1   i...e..  top-down is possible in case of frames


 */
public class HandleFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");

        //Frame1
        WebElement frame1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Dhananjay");


        driver.switchTo().defaultContent();

        //Frame2
        WebElement frame2 = driver.findElement(By.xpath("/html/frameset/frameset/frame[1]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Rajendra");

        //everytime have to use to before  switch or move to another frame
        driver.switchTo().defaultContent();

        WebElement frame3 = driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Chavan");




//switch to inner frame which is ( part of frame3)
//inner frames / nested frame

        driver.switchTo().frame(0);   //switch to inner frame as no unique attribute for iframe is present

        driver.findElement(By.xpath("//*[@id=\"i6\"]/div[3]")).click();



        //difference between page and form
    //page is opened through the URL----> form is open when the page is loaded
        //page can compose of multiple forms embedded in iframe but iframe //form doesn't have a page

        //can switch from one form to another based upon the requirement


        //if u display external page into a current page---> iframe

        //frame is local which is related to a page itself


        //frame-> frame can switch through index
        //frame-> iframce can also switch but not vice versa--- > need defaultcontent switch for reversal

        // iframe cannot have webelement as it is an external page only  ---.> can switch through using index,name,id --> cannot be get as  webelement
        //normal frame can be accessed through index, name,id, WebElement


















    }
}
