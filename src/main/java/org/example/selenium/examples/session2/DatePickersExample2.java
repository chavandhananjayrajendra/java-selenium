package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

// 1. Switch to iframe if datepicker is inside one
// 2. Open the calendar by clicking the input box
// 3. Compare displayed month & year with target month & year
// 4. Keep clicking "Next" until target month & year is displayed
// 5. Once month-year matches, click on the day number
// 6. This approach works for future dates; for past dates click "Previous" button instead

public class DatePickersExample2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Open datepicker
        driver.findElement(By.id("datepicker")).click();

        // Target date (Change for testing)
        String targetDate = "10-September-2023";  // <-- Change date here
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        LocalDate td = LocalDate.parse(targetDate, formatter);

        String targetMonth = td.getMonth().name().substring(0, 1).toUpperCase() +
                td.getMonth().name().substring(1).toLowerCase();
        String targetMonthYear = targetMonth + " " + td.getYear();

        while (true) {
            String currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

            if (currentMonthYear.equalsIgnoreCase(targetMonthYear)) {
                break;
            }

            // Compare dates to decide navigation direction
            LocalDate currentDate = LocalDate.now(); // current system date
            if (td.isAfter(currentDate)) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Next
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Previous
            }
        }

        // Select the day
        driver.findElement(By.xpath("//a[text()='" + td.getDayOfMonth() + "']")).click();

        driver.quit();
    }
}
