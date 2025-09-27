package org.example.selenium.examples.session2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


/*
Multi-Select Dropdown Notes:

1. HTML should have <select multiple> attribute for multi-selection.
2. Use org.openqa.selenium.support.ui.Select class.
3. Key Methods:
    - selectByVisibleText("Text")
    - selectByValue("value")
    - selectByIndex(index)
    - getAllSelectedOptions()
    - deselectByVisibleText("Text")
    - deselectByValue("value")
    - deselectByIndex(index)
    - deselectAll()
4. Always check select.isMultiple() before performing multiple selections.
5. Can use Ctrl/Shift in real UI, but in Selenium, we call select methods multiple times.
*/


public class MultiSelectDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Load local HTML file (change path as per your machine)
        driver.get("D:\\bakup\\JavaSelenium\\multiselectdropdown.html");

        // Locate the multi-select dropdown
        WebElement multiSelect = driver.findElement(By.id("languages"));

        // Create Select object
        Select select = new Select(multiSelect);

        // Check if multi-select is supported
        System.out.println("Is Multiple? " + select.isMultiple());

        // Select multiple options
        select.selectByVisibleText("Java");
        select.selectByValue("python");
        select.selectByIndex(2); // JavaScript

        Thread.sleep(2000);

        // Get all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        System.out.println("Selected Languages:");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Deselect one option
        select.deselectByVisibleText("Java");

        Thread.sleep(2000);

        // Deselect all
        select.deselectAll();

        driver.quit();
    }
}
