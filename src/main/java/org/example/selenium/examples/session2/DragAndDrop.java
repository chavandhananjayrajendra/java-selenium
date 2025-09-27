package org.example.selenium.examples.session2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


//drag and drop---> will have 2 parameters.
//(source,target)---> source would be a webelement from which the element to be dragged and target would be a webelement where the element to be dropped.

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {




                WebDriver driver = new ChromeDriver();

                driver.get("D:\\bakup\\JavaSelenium\\drag&drop.html"); // <-- update your path

                WebElement source = driver.findElement(By.id("dragBox"));
                WebElement target = driver.findElement(By.id("dropBox"));

                // Approach 1: Using Actions class (works for simple drag-drop)
                Actions actions = new Actions(driver);
                actions.dragAndDrop(source, target).perform();

                Thread.sleep(2000); // just to see result
                driver.quit();

            }
        }

