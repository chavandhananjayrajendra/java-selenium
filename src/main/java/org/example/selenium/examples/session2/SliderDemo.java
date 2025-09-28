package org.example.selenium.examples.session2;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Actions.dragAndDropBy(element, xOffset, yOffset) → moves the slider horizontally or vertically.
//
//xOffset = positive → moves right.
//
//xOffset = negative → moves left.
//
//yOffset usually 0 because we are moving horizontally.
//
//getLocation() → prints (x,y) coordinates before and after move (good for debugging).
//
//We used Thread.sleep() just so you can visually confirm the slider is moving.


public class SliderDemo {
    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver using WebDriverManager
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        // Create Actions object
        Actions act = new Actions(driver);

        // Locate minimum slider
        WebElement min_slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
        Point minLocation = min_slider.getLocation();
        System.out.println("Default location of MIN slider: " + minLocation);

        // Drag min slider towards right by 100 pixels
        act.dragAndDropBy(min_slider, 100, 0).perform();

        Point minLocationAfter = min_slider.getLocation();
        System.out.println("Location of MIN slider after moving: " + minLocationAfter);

        Thread.sleep(1000);

        // Locate maximum slider
        WebElement max_slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
        Point maxLocation = max_slider.getLocation();
        System.out.println("Default location of MAX slider: " + maxLocation);

        // Drag max slider towards left by 100 pixels
        act.dragAndDropBy(max_slider, -100, 0).perform();

        Point maxLocationAfter = max_slider.getLocation();
        System.out.println("Location of MAX slider after moving: " + maxLocationAfter);

        Thread.sleep(2000);
        driver.quit();
    }
}
