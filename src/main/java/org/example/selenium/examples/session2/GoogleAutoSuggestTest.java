package org.example.selenium.examples.session2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


/*

-----------Auto-Suggestion Dropdowns-----------
    - Auto-suggestion dropdowns are dynamic lists that appear when typing into a search field.
    - Unlike <select> dropdowns, these are generated dynamically (usually via AJAX) and are not static HTML elements.
    - Example: Google Search suggestions.

    --Challenges:

    - Suggestions load asynchronously — timing issues can occur if you don’t wait properly.
    - Not a traditional "Select" element → cannot use Select class.
    - Locators can change dynamically → must use stable attributes (role, span text)

    --Ways to handle
    Type the search query into the input field.
    b) Use EXPLICIT WAIT to wait until the suggestion list is visible.
    c) Fetch all suggestion elements into a List<WebElement>.
    d) Loop through them and match with the expected suggestion text.




 */

public class GoogleAutoSuggestTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium tutorial");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li")));
        //ul[@role='listbox']//li//span  → Fetches text from each suggestion item.

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
            if (suggestion.getText().equalsIgnoreCase("selenium tutorial")) {
                suggestion.click();
                break;
            }
        }


    }
}
