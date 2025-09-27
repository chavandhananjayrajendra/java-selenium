package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicPaginationTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/table.xhtml");
        driver.manage().window().maximize();

        // 1. Row Count & Column Count
        List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@role='grid']/thead/tr/th"));
        System.out.println("Total rows: " + rows.size());
        System.out.println("Total columns: " + columns.size());

        // 2. Get progress value for a specific course
        String progress = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td[1]")).getText();
        System.out.println("Progress for Learn to interact with Elements: " + progress);

        // 3. Click the checkbox for a specific course
        WebElement checkbox = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td[2]//div[contains(@class,'ui-chkbox-box')]"));
        checkbox.click();

        // 4. Find minimum progress and click its checkbox
        List<WebElement> allProgress = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[2]"));
        int minValue = Integer.MAX_VALUE;
        WebElement minRowCheckbox = null;

        for (WebElement cell : allProgress) {
            String value = cell.getText().replace("%", "");
            int progressValue = Integer.parseInt(value);

            if (progressValue < minValue) {
                minValue = progressValue;
                minRowCheckbox = cell.findElement(By.xpath("following-sibling::td//div[contains(@class,'ui-chkbox-box')]"));
            }
        }
        System.out.println("Minimum progress value: " + minValue + "%");
        if (minRowCheckbox != null) minRowCheckbox.click();

        // 5. (Optional) Pagination Handling Example
        // Loop through pages until data is found
        boolean found = false;
        while (!found) {
            List<WebElement> dataRows = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
            for (WebElement row : dataRows) {
                if (row.getText().contains("Learn to interact with Elements")) {
                    System.out.println("Found row on current page!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next Page']"));
                if (nextButton.getAttribute("class").contains("ui-state-disabled")) {
                    System.out.println("Reached last page. Data not found.");
                    break;
                }
                nextButton.click();
                Thread.sleep(1000);
            }
        }

        driver.quit();
    }
}
