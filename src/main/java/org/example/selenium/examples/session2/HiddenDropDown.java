package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/*
Hidden Dropdown
 A dropdown that is present in the DOM but not visible on page load.
   - It becomes visible only after some action (click/hover).
   - Sometimes options are hidden via `display:none` or are inside a hidden container.
-----------------
   identification
    Look for `style="display:none"` or hidden attributes.
   - Option list exists in DOM but is not visible.
   - Requires action before interacting.


 */

public class HiddenDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users//chava\\Downloads\\JavaSelenium\\hiddendropdown.html"); // update your path

        driver.findElement(By.id("showMenuBtn")).click();
        Thread.sleep(1000); // Wait for it to become visible

        // Step 2: Click dropdown toggle
        driver.findElement(By.cssSelector("#hiddenMenu .dropdown-toggle")).click();

        // Step 3: Get dropdown items
        List<WebElement> options = driver.findElements(By.cssSelector("#hiddenMenu .dropdown-item"));
        System.out.println("Hidden dropdown options: " + options.size());

        // Step 4: Select a specific option
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equals("Hidden Option 2")) {
                option.click();
                break;
            }
        }

        driver.quit();
    }
}
