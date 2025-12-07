package org.example.selenium.examples.session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");

        //Selenium4.x
        driver.switchTo().newWindow(WindowType.TAB);  //opens new tab
        driver.get("https://creately.com/");


        driver.switchTo().newWindow(WindowType.WINDOW);  //opens new tab in new window
        driver.get("https://meet n nn n .google.com/qid-hkjn-eck?pli=1");


    }
}
