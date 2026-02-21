package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#input")).sendKeys("Dhananjay");


        //---------------------if we want to access element directly,then the code will throw error as Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#input"}

//        driver.findElement(By.cssSelector("#input")).sendKeys("Dhananjay");

//        // 1) This Element is inside single shadow DOM.
//
//        String cssSelectorForHost = "#shadow-root";
//        Thread.sleep(1000);
//        SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//        Thread.sleep(1000);
//        shadow.findElement(By.cssSelector("#shadow-element"));
//
//
//
//        // 2) This Element is inside 2 nested shadow DOM.
//        String cssSelectorForHost1 = "#shadow-root";
//        String cssSelectorForHost2 = "#inner-shadow-dom";
//        Thread.sleep(1000);
//        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//        Thread.sleep(1000);
//        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
//        Thread.sleep(1000);
//        shadow1.findElement(By.cssSelector("#nested-shadow-root"));
//
//
//
//        // 3)
//        //This Element is inside 3 nested shadow DOM.
//        String cssSelectorForHost4 = "#shadow-root";
//        String cssSelectorForHost5 = "#inner-shadow-dom";
//        String cssSelectorForHost6 = "#nested-shadow-dom";
//        Thread.sleep(1000);
//        SearchContext shadow2 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//        Thread.sleep(1000);
//        SearchContext shadow3 = shadow2.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
//        Thread.sleep(1000);
//        SearchContext shadow4 = shadow3.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
//        Thread.sleep(1000);
//        shadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));
    }
}
